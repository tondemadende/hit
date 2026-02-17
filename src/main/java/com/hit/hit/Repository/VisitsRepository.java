package com.hit.hit.Repository;

import com.hit.hit.model.Visits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VisitsRepository extends JpaRepository<Visits, Long> {
    List<Visits> findVisitsByVisitorId(String id);


}
