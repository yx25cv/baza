package com.ds.baza.dsbaza.model;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table (name = "CLANOVI")
public class Clanovi extends BaseEntity {
	private Date DATUM_POSL_EVID;
	private Date DATUM_PRISTUPA;
	private String RAZLOG_ISTUPA;
	private int SIFRA_CLANA; //not null
	private String OVERIO;
	private String KOMENTAR_ISTUPA;
	private String STATUS;
	private String ARHIVIRAN;
	private String KOMENTAR;
	private String DOPRINOSI;
	private String MLB;
	private int SIFRA_ODBORA;
	private int SIFRA_OPSTINE;
	private int BM;
	private int SIFRA_MESNOG;
	private Date DPE_REZ;
	private Date DP_REZ;
	private Date DATUM_PROMENE_ODBORA;
	private String STATUS_REVIZIJA;
	private String REVIDIRAN_2004;
}
