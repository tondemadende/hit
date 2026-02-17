package com.hit.hit.config.service;


import com.hit.hit.Repository.GatesRepository;
import com.hit.hit.model.Gates;
import com.hit.hit.model.Visits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GatesService {

    @Autowired
    private GatesRepository gatesRepository;

    public Gates save(Gates gate){
        return gatesRepository.save(gate);
    }

    public List<Gates> getAll(){
        return gatesRepository.findAll();
    }

}
