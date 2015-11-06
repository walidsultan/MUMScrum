/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webs.mumscrum.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 984627
 */
@Entity
public class UserStory implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Integer DevEstimate;
    private Integer DevActual;
    private Integer TesterEstimate;
    private Integer TesterActual;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDevEstimate() {
        return DevEstimate;
    }

    public void setDevEstimate(Integer DevEstimate) {
        this.DevEstimate = DevEstimate;
    }

    public Integer getDevActual() {
        return DevActual;
    }

    public void setDevActual(Integer DevActual) {
        this.DevActual = DevActual;
    }

    public Integer getTesterEstimate() {
        return TesterEstimate;
    }

    public void setTesterEstimate(Integer TesterEstimate) {
        this.TesterEstimate = TesterEstimate;
    }

    public Integer getTesterActual() {
        return TesterActual;
    }

    public void setTesterActual(Integer TesterActual) {
        this.TesterActual = TesterActual;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
