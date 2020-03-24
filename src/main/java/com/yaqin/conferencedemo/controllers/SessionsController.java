package com.yaqin.conferencedemo.controllers;

import com.yaqin.conferencedemo.models.Session;
import com.yaqin.conferencedemo.repositories.SessionRepository;
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
}
