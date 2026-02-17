package com.hit.hit.Repository;


import com.hit.hit.model.Gates;
import com.hit.hit.model.Visits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GatesRepository extends JpaRepository<Gates, Long> {
}
