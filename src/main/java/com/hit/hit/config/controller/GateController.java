package com.hit.hit.config.controller;


import com.hit.hit.config.service.GatesService;
import com.hit.hit.config.service.VisitsService;
import com.hit.hit.model.Gates;
import com.hit.hit.model.Visits;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gates")
@CrossOrigin(origins = "*")
public class GateController {


    private static final Logger log = LoggerFactory.getLogger(GateController.class);

    @Autowired
    private GatesService gatesService;


    @PostMapping("/save")
    public Gates save(@RequestBody Gates gates){
        return gatesService.save(gates);
    }

    @GetMapping("/get-all")
    public List<Gates> getAll(){
        return gatesService.getAll();
    }

}
