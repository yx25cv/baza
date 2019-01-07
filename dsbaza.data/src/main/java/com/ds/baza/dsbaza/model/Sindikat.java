package com.ds.baza.dsbaza.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SINDIKAT")
public class Sindikat extends BaseEntity {
	private String NAZIV;
	private int SINDIKAT;
}
