package com.ds.baza.dsbaza.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "MESNI_ODBORI")
public class MesniOdbori extends BaseEntity {
	private int BROJ_CLANOVA;
	private int SIFRA_ODBORA;
	private int SIFRA_MESNOG;
	private String NAZIV;
}
