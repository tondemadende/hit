package com.hit.hit.config.controller;


import com.hit.hit.config.service.VisitorService;
import com.hit.hit.model.Visitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/visitor")
@CrossOrigin(origins = "*")
public class VisitorController {
    private static final Logger log = LoggerFactory.getLogger(VisitorController.class);

    @Autowired
    private VisitorService visitorService;


    @PostMapping("/save")
    public Visitor save(@RequestBody Visitor visitor){
        return visitorService.save(visitor);
    }

    @GetMapping("/get-all")
    public List<Visitor> getAll(){
        return visitorService.getAllVisitors();
    }

    @GetMapping("/get-by-id/{id}")
    public Optional<Visitor> getAll(long id){
        return visitorService.getVisitor(id);
    }


}
