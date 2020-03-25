package com.yaqin.conferencedemo.controllers;

import com.yaqin.conferencedemo.models.Session;
import com.yaqin.conferencedemo.models.Speaker;
import com.yaqin.conferencedemo.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {
    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> list(){
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}") //add additional id to the url (api/vi/sessions)
    public Speaker get(@PathVariable Long id){
        return speakerRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //maps 201 to http world
    public Speaker create(@RequestBody final Speaker speaker){
        return speakerRepository.saveAndFlush(speaker);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        //also need to check for children records before deleting
        //this will only delete without children records at this current implementation
        speakerRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    //for update, you can choose PUT and PATCH verb
    public Speaker update(@PathVariable Long id, @RequestBody Session session){

        //TODO: Add validation that all attributes are passed in, otherwise return a 400 bad payload
        Speaker existingSpeaker = speakerRepository.getOne(id);
        BeanUtils.copyProperties(session,existingSpeaker,"speaker_id");
        return speakerRepository.saveAndFlush(existingSpeaker);
    }
}
