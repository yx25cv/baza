package com.ds.baza.dsbaza.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ODBORI")
public class Odbori extends BaseEntity {
	private int BROJ_CLANOVA;
	private int SIFRA_ODBORA;
	private String KOMENTAR;
	private int SIF_MESTO;
	private int SIFRA_OPSTINE;
	private String NAZIV;
}
