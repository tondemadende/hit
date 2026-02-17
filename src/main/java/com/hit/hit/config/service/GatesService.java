package com.hit.hit.config.service;


import com.hit.hit.Repository.GatesRepository;
import com.hit.hit.model.Gates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class GatesService {


    @Autowired
    private GatesRepository gatesRepository;

    public Gates save(Gates gate){
        return gatesRepository.save(gate);
    }

}
