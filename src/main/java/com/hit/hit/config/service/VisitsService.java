package com.hit.hit.config.service;

import com.hit.hit.Repository.VisitsRepository;
import com.hit.hit.model.Visits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VisitsService {

    @Autowired
    private VisitsRepository visitsRepository;

    public Visits save(Visits visits){

        boolean checkedIn = false;

        List<Visits> v = visitsRepository.findVisitsByVisitorId(visits.getVisitorId());

        for (Visits value : v) {
            if (value.getCheckedOutAt() == null) {
                checkedIn = true;
                break;
            }
        }

        visits.setCheckedInAt(new Date());

        if(!checkedIn)
            return visitsRepository.save(visits);

        return null;
    }

    public List<Visits> getAllVisits() {
      return  visitsRepository.findAll();
    }

    public Optional<Visits> getVisitor(Long id) {
        return visitsRepository.findById(id);
    }

    public Visits checkout(Visits visits) {


        Optional<Visits> v = visitsRepository.findById(visits.getId());

        if(v.isPresent()){
            visits.setCheckedInAt(new Date());
        }

        if(v.isPresent()) {

            return visitsRepository.save(visits);
        }

        return  null;
    }


}
