package com.ds.baza.dsbaza.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "MESTO")
public class Mesto extends BaseEntity {
	private String NAZIV;
	private int SIF_MESTO;
	private int SIF_DRZAVE;
}
