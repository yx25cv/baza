package com.ds.baza.dsbaza.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "DRZAVA")
public class Drzava extends BaseEntity {
	private int SIF_DRZAVE;
	private String NAZIV;
}
