package com.ds.baza.dsbaza.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table (name = "CLANOVI")
public class Clanovi extends BaseEntity {

	@Column(name = "DATUM_POSL_EVID")
	private Date datumPoslednjeEvid;
	@Column(name = "DATUM_PRISTUPA")
	private Date datumPristupa;
	@Column(name = "RAZLOG_ISTUPA")
	private String razlogIstupa;
	@Column(name = "SIFRA_CLANA")
	private int sifraClana; //not null
	@Column(name = "OVERIO")
	private String overio;
	@Column(name = "KOMENTAR_ISTUPA")
	private String komentarIstupa;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "ARHIVIRAN")
	private String arhiviran;
	@Column(name = "KOMENTAR")
	private String komentar;
	@NotEmpty
	@Column(name = "DOPRINOSI")
	private String doprinosi;
	@OneToOne
	@JoinColumn(name = "MLB")
	private LicniPodaci licniPodaci;
	@OneToOne
	@JoinColumn(name = "SIFRA_ODBORA")
	private Odbori odbori;
	@Column(name = "SIFRA_OPSTINE")
	private int sifraOpstine;
	@Column(name = "BM")
	private int bm;
	@Column(name = "SIFRA_MESNOG")
	private int sifraMesnog;
	@Column(name = "DPE_REZ")
	private Date dpeRez;
	@Column(name = "DP_REZ")
	private Date dpRez;
	@Column(name = "DATUM_PROMENE_ODBORA")
	private Date datumPromeneOdbora;
	@Column(name = "STATUS_REVIZIJA")
	private String statusRevizija;
	@Column(name = "REVIDIRAN_2004")
	private String revidiran2004;

	public Clanovi() {
	}

	public Clanovi(Date datumPoslednjeEvid, Date datumPristupa, String razlogIstupa, int sifraClana, String overio, String komentarIstupa, String status, String arhiviran, String komentar, String doprinosi, LicniPodaci licniPodaci, Odbori odbori, int sifraOpstine, int bm, int sifraMesnog, Date dpeRez, Date dpRez, Date datumPromeneOdbora, String statusRevizija, String revidiran2004) {
		this.datumPoslednjeEvid = datumPoslednjeEvid;
		this.datumPristupa = datumPristupa;
		this.razlogIstupa = razlogIstupa;
		this.sifraClana = sifraClana;
		this.overio = overio;
		this.komentarIstupa = komentarIstupa;
		this.status = status;
		this.arhiviran = arhiviran;
		this.komentar = komentar;
		this.doprinosi = doprinosi;
		this.licniPodaci = licniPodaci;
		this.odbori = odbori;
		this.sifraOpstine = sifraOpstine;
		this.bm = bm;
		this.sifraMesnog = sifraMesnog;
		this.dpeRez = dpeRez;
		this.dpRez = dpRez;
		this.datumPromeneOdbora = datumPromeneOdbora;
		this.statusRevizija = statusRevizija;
		this.revidiran2004 = revidiran2004;
	}

	public Date getDatumPoslednjeEvid() {
		return datumPoslednjeEvid;
	}

	public void setDatumPoslednjeEvid(Date datumPoslednjeEvid) {
		this.datumPoslednjeEvid = datumPoslednjeEvid;
	}

	public Date getDatumPristupa() {
		return datumPristupa;
	}

	public void setDatumPristupa(Date datumPristupa) {
		this.datumPristupa = datumPristupa;
	}

	public String getRazlogIstupa() {
		return razlogIstupa;
	}

	public void setRazlogIstupa(String razlogIstupa) {
		this.razlogIstupa = razlogIstupa;
	}

	public int getSifraClana() {
		return sifraClana;
	}

	public void setSifraClana(int sifraClana) {
		this.sifraClana = sifraClana;
	}

	public String getOverio() {
		return overio;
	}

	public void setOverio(String overio) {
		this.overio = overio;
	}

	public String getKomentarIstupa() {
		return komentarIstupa;
	}

	public void setKomentarIstupa(String komentarIstupa) {
		this.komentarIstupa = komentarIstupa;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getArhiviran() {
		return arhiviran;
	}

	public void setArhiviran(String arhiviran) {
		this.arhiviran = arhiviran;
	}

	public String getKomentar() {
		return komentar;
	}

	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}

	public String getDoprinosi() {
		return doprinosi;
	}

	public void setDoprinosi(String doprinosi) {
		this.doprinosi = doprinosi;
	}

	public LicniPodaci getLicniPodaci() {
		return licniPodaci;
	}

	public void setLicniPodaci(LicniPodaci licniPodaci) {
		this.licniPodaci = licniPodaci;
	}

	public Odbori getOdbori() {
		return odbori;
	}

	public void setOdbori(Odbori odbori) {
		this.odbori = odbori;
	}

	public int getSifraOpstine() {
		return sifraOpstine;
	}

	public void setSifraOpstine(int sifraOpstine) {
		this.sifraOpstine = sifraOpstine;
	}

	public int getBm() {
		return bm;
	}

	public void setBm(int bm) {
		this.bm = bm;
	}

	public int getSifraMesnog() {
		return sifraMesnog;
	}

	public void setSifraMesnog(int sifraMesnog) {
		this.sifraMesnog = sifraMesnog;
	}

	public Date getDpeRez() {
		return dpeRez;
	}

	public void setDpeRez(Date dpeRez) {
		this.dpeRez = dpeRez;
	}

	public Date getDpRez() {
		return dpRez;
	}

	public void setDpRez(Date dpRez) {
		this.dpRez = dpRez;
	}

	public Date getDatumPromeneOdbora() {
		return datumPromeneOdbora;
	}

	public void setDatumPromeneOdbora(Date datumPromeneOdbora) {
		this.datumPromeneOdbora = datumPromeneOdbora;
	}

	public String getStatusRevizija() {
		return statusRevizija;
	}

	public void setStatusRevizija(String statusRevizija) {
		this.statusRevizija = statusRevizija;
	}

	public String getRevidiran2004() {
		return revidiran2004;
	}

	public void setRevidiran2004(String revidiran2004) {
		this.revidiran2004 = revidiran2004;
	}
}
