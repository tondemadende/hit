package com.hit.hit.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Visits {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String visitorId;
    @Column(nullable = false)
    private String gateId;
    @Column(nullable = false)
    private Date checkedInAt;

    @Column(nullable = true)
    private Date checkedOutAt;
    @Column(nullable = false)
    private String passCode;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Visitor createdBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public String getGateId() {
        return gateId;
    }

    public void setGateId(String gateId) {
        this.gateId = gateId;
    }

    public Date getCheckedInAt() {
        return checkedInAt;
    }

    public void setCheckedInAt(Date checkedInAt) {
        this.checkedInAt = checkedInAt;
    }

    public Date getCheckedOutAt() {
        return checkedOutAt;
    }

    public void setCheckedOutAt(Date checkedOutAt) {
        this.checkedOutAt = checkedOutAt;
    }

    public String getPassCode() {
        return passCode;
    }

    public void setPassCode(String passCode) {
        this.passCode = passCode;
    }

    public Visitor getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Visitor createdBy) {
        this.createdBy = createdBy;
    }
}
