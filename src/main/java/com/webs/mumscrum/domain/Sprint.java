/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.webs.mumscrum.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author 984627
 */
@Entity
public class Sprint implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Release getRelease() {
        return release;
    }

    public void setReleases(Release release) {
        this.release = release;
    }

    public Employee getScrumMaster() {
        return scrumMaster;
    }

    public void setScrumMaster(Employee scrumMaster) {
        this.scrumMaster = scrumMaster;
    }
    
    private Date startDate;
    private Date endDate;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Release release;
     
    @OneToOne(cascade = CascadeType.ALL)
    private Employee scrumMaster;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
