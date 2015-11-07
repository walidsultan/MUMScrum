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
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author 984627
 */
@Entity
public class Sprint implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty
	private String name;

	@NotNull 
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date startDate;
	@NotNull 
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date endDate;

	@OneToOne(cascade = CascadeType.ALL)
	@Valid
	private Release release;

	@OneToOne(cascade = CascadeType.ALL)
	@Valid
	private Employee scrumMaster;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
