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
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

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
    
    @NotEmpty
    private String name;
    private String description;
    @NotNull
    private Integer DevEstimate;
    private Integer DevActual;
    @NotNull
    private Integer TesterEstimate;
    private Integer TesterActual;

    @OneToOne
    private Sprint sprint;

    @OneToOne
    private Role developer;
 
	@OneToOne
    private Role tester;
    
    public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

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
    
    public Role getDeveloper() {
  		return developer;
  	}

  	public void setDeveloper(Role developer) {
  		this.developer = developer;
  	}

  	public Role getTester() {
  		return tester;
  	}

  	public void setTester(Role tester) {
  		this.tester = tester;
  	}


  	@Override
    public int hashCode() {
        return Math.toIntExact(this.id);
    }
  	
  	@Override
    public boolean equals(Object item) {
  		UserStory userStory= (UserStory) item;
  		if(userStory.getId().equals(this.id)){
  			return true;
  		}else
  		{
  			return false;
  		}
    }
    
}
