package com.hit.hit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Visits {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String visitor_id;

    private String gate_id;

    private Date checked_in_at;

    private Date checked_out_at;

    private String passCode;

    private String createdBy;






}
