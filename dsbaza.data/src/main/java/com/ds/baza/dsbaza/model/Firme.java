package com.ds.baza.dsbaza.model;
//: drop table, cascade constraint

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FIRME")
public class Firme extends BaseEntity {
	private String Naziv;
	private int NAZIV_FIRME;
	private String TEL;
	private String ADRESA_FIRME;
	private int SIFRA_OPSTINE;
	private String SVOJINA;
	private int SIFRA_DELATNOSTI;
	private int BR_ZAP;
}
