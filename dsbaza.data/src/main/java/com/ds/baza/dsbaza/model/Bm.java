package com.ds.baza.dsbaza.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "BM")
public class Bm extends BaseEntity{
	private int BM;
	private String NAZIV;
	private int SIFRA_OPSTINE;
	private String OPIS;
	private int IJ;
	private int BR_BIR;
}
