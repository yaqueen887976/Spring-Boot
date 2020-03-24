package com.yaqin.conferencedemo.controllers;

import com.yaqin.conferencedemo.models.Speaker;
import com.yaqin.conferencedemo.repositories.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/speakers")
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
    /*
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //maps 201 to http world
    public Speaker create(@RequestBody final Speaker speaker){
        return speakerRepository.saveAndFlush(speaker);
    }*/
}
