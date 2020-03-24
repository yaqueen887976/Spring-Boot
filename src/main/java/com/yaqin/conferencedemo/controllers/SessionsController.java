package com.yaqin.conferencedemo.controllers;

import com.yaqin.conferencedemo.models.Session;
import com.yaqin.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/sessions")
public class SessionsController {
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> list(){
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}") //add additional id to the url (api/vi/sessions)
    public Session get(@PathVariable Long id){
        return sessionRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //maps 201 to http world
    public Session create(@RequestBody final Session session){
        return sessionRepository.saveAndFlush(session);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        //also need to check for children records before deleting
        //this will only delete without children records at this current implementation
        sessionRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    //for update, you can choose PUT and PATCH verb
    public Session update(@PathVariable Long id, @RequestBody Session session){
        //put replace all attribute on the record you are updating, patch will allow
        //just a portion of the attributes to be updated
        //TODO: Add validation that all attributes are passed in, otherwise return a 400 bad payload
        Session existingSession = sessionRepository.getOne(id);
        //beanutils objects takes the existingSession and copies the incoming session
        //data onto it. third one: ignore things that we don't want to copy,because session id we don't want to replace it. if not
        //ignore, it will copy null
        BeanUtils.copyProperties(session,existingSession,"session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }

}
