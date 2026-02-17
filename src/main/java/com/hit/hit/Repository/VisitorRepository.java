package com.hit.hit.Repository;


import com.hit.hit.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long> {

//    List<Visitor> findVisitorByFirstName(String name);
//
//    List<Visitor> findVisitorByLastName(String name);
//
//    List<Visitor> findVisitorByNationalId(String name);
}
