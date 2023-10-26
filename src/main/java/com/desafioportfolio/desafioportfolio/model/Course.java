package com.desafioportfolio.desafioportfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Discipline")
public class Course {
	
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE )
	private Long id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Amount_Semester")
	private int amount_semester;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAmount_semester() {
		return amount_semester;
	}

	public void setAmount_semester(int amount_semester) {
		this.amount_semester = amount_semester;
	}

}
