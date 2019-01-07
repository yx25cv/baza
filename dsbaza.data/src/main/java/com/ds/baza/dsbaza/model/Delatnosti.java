package com.ds.baza.dsbaza.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "DELATNOSTI")
public class Delatnosti extends BaseEntity {
	private String NAZIV;
	private int SIFRA_DELATNOSTI;
}
