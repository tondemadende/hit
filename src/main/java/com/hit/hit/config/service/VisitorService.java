package com.hit.hit.config.service;

import com.hit.hit.Repository.VisitorRepository;
import com.hit.hit.model.Visitors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitorService {

    @Autowired
    private VisitorRepository visitorRepository;

    public Visitors save(Visitors visitors){
        return visitorRepository.save(visitors);
    }

    public List<Visitors> getAllVisitors() {
        return visitorRepository.findAll();
    }

    public Optional<Visitors> getVisitor(Long id) {
        return visitorRepository.findById(id);
    }

//    public List<Visitor> getByFname(String name){
//        return visitorRepository.findVisitorByFirstName(name);
//    }
//
//    public List<Visitor> getByLname(String name){
//        return visitorRepository.findVisitorByLastName(name);
//    }
//
//    public List<Visitor> getByNationalId(String name){
//        return visitorRepository.findVisitorByNationalId(name);
//    }
}
