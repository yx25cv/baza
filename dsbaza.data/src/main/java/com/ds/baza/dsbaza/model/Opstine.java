package com.ds.baza.dsbaza.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "OPSTINE")
public class Opstine extends BaseEntity {
	private int SIFRA_OPSTINE;
	private String NAZIV;
	private int SIF_MESTO;
	private int REGION;
}
