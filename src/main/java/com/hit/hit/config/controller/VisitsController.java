package com.hit.hit.config.controller;


import com.hit.hit.config.service.VisitsService;
import com.hit.hit.model.Visits;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/visits")
@CrossOrigin(origins = "*")
public class VisitsController {

    private static final Logger log = LoggerFactory.getLogger(VisitsController.class);

    @Autowired
    private VisitsService visitsService;


    @PostMapping("/save")
    public Visits save(@RequestBody Visits visitor){
        return visitsService.save(visitor);
    }

    @GetMapping("/get-all")
    public List<Visits> getAll(){
        return visitsService.getAllVisits();
    }

    @GetMapping("/get-by-id/{id}")
    public Optional<Visits> getAll(Long id){
        return visitsService.getVisitor(id);
    }

    @PostMapping("/checkout")
    public Visits checkout(@RequestBody Visits visitor){
        return visitsService.checkout(visitor);
    }







}
