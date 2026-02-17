package com.hit.hit.config.service;

import com.hit.hit.Repository.GatesRepository;
import com.hit.hit.Repository.VisitsRepository;
import com.hit.hit.model.Gates;
import com.hit.hit.model.Visits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitsService {

    @Autowired
    private VisitsRepository visitsRepository;

    public Visits save(Visits visits){
        return visitsRepository.save(visits);
    }
}
