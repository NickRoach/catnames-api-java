package com.catnames.controllers;

import com.catnames.entities.CatnamesEntity;
import com.catnames.payloads.requests.CatCreatePayload;
import com.catnames.services.CatnamesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "https://nickroach.github.io/", maxAge = 3600)
public class CatnamesController {

    @Autowired
    private CatnamesService service;

    public CatnamesController(CatnamesService service) {
        this.service = service;
    }

    @GetMapping
    public List<CatnamesEntity> all() {
        return this.service.all();
    }

    @DeleteMapping
    public List<CatnamesEntity> delete(@Valid @RequestBody CatCreatePayload payload) throws JsonProcessingException {
        return this.service.delete(payload);
    }

    @PostMapping
    public List<CatnamesEntity> create(@Valid @RequestBody CatCreatePayload payload) throws JsonProcessingException {
        return this.service.create(payload);
    }
}
