package com.ds.baza.dsbaza.model;

import com.ds.baza.dsbaza.model.Constraints.ZanimanjeValidatorConstraint;

import javax.persistence.*;

@Entity
@Table(name = "ZANIMANJE")
public class Zanimanje {
	@ZanimanjeValidatorConstraint
	@Column(name = "NAZIV")
	private String naziv;
	@Id
	@GeneratedValue
	@Column(name = "ZANIMANJE")
	private Long id;

	public Zanimanje() {
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
