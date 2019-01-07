package com.ds.baza.dsbaza.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ZANIMANJE")
public class Zanimanje extends BaseEntity {
	private String NAZIV;
	private int ZANIMANJE;
}
