package com.ds.baza.dsbaza.model;

import javax.persistence.*;

@Entity
@Table(name = "RM")
public class Rm {
	@Column(name = "NAZIV")
	private String naziv;
	@Id
	@GeneratedValue
	@Column(name = "RM")
	private Long id;

	public Rm() {
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
