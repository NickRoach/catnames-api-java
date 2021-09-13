package com.catnames.controllers;

import com.catnames.entities.CatnamesEntity;
import com.catnames.services.CatnamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("")
public class CatnamesController {

    @Autowired
    private CatnamesService service;

    public CatnamesController(CatnamesService service) {
        this.service = service;
    }


    //to get the whole list
    @GetMapping
    public List<CatnamesEntity> all() {
        return this.service.all();
    }

    @DeleteMapping(value = "/{id}")
    public List<CatnamesEntity> delete(@PathVariable Integer id){
        return this.service.deleteById(id);
    }

    @PostMapping(value = "/{name}")
    public List<CatnamesEntity> post(@PathVariable String name){
        return this.service.post(name);
    }
}
