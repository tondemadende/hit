package com.hit.hit.Repository;


import com.hit.hit.model.Visitors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository extends JpaRepository<Visitors, Long> {

//    List<Visitor> findVisitorByFirstName(String name);
//
//    List<Visitor> findVisitorByLastName(String name);
//
//    List<Visitor> findVisitorByNationalId(String name);
}
