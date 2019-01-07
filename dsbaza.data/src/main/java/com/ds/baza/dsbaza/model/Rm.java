package com.ds.baza.dsbaza.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "RM")
public class Rm extends BaseEntity {
	private String NAZIV;
	private int RM;
}
