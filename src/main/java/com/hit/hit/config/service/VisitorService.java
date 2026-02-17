package com.hit.hit.config.service;

import com.hit.hit.Repository.GatesRepository;
import com.hit.hit.Repository.VisitorRepository;
import com.hit.hit.model.Gates;
import com.hit.hit.model.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitorService {

    @Autowired
    private VisitorRepository visitorRepository;

    public Visitor save(Visitor visitor){
        return visitorRepository.save(visitor);
    }

    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }

    public Optional<Visitor> getVisitor(Integer id) {
        return visitorRepository.findById(id);
    }
}
