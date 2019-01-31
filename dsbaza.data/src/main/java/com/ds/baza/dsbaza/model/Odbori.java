package com.ds.baza.dsbaza.model;


import javax.persistence.*;

@Entity
@Table(name = "ODBORI")
public class Odbori {

	@Column(name = "BROJ_CLANOVA")
	private int brojClanova;
	@Id
	@GeneratedValue
	@Column(name = "SIFRA_ODBORA")
	private Long id;
	@Column(name = "KOMENTAR")
	private String komentar;
	@Column(name = "SIF_MESTO")
	private int sifMesto;
	@Column(name = "SIFRA_OPSTINE")
	private int sifraOpstine;
	@Column(name = "NAZIV")
	private String naziv;

}
