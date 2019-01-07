package com.ds.baza.dsbaza.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "LICNI_PODACI")
public class LicniPodaci extends BaseEntity {
	@Column(name = "IME_RODITELJA")
	private String imeRoditelja;
	@NotEmpty
	@Column(name = "ADRESA")
	private String adresa;
	@NotEmpty
	@Column(name = "PREZIME")
	private String prezime;
	@NotEmpty
	@Column(name = "IME")
	private String ime;
	@Column(name = "KONTAKT_ADRESA")
	private String kontaktAdresa;
	@Column(name = "TEL1")
	private String tel1;
	@Column(name = "TEL2")
	private String tel2;
	@Column(name = "TEL3")
	private String tel3;
	@Column(name = "POL")
	private String pol;
	@Column(name = "DATUM_RODJENJA")
	private Date datumRodjenja;
	@Column(name = "BRACNO_STANJE")
	private String bracnoStanje;
	@Column(name = "PEJDZER")
	private String pejdzer;
	@Column(name = "E_MAIL")
	private String email;
	@Column(name = "FOTO")
	private String foto;
	@Column(name = "RADNI_STATUS")
	private String radniStatus;
	@Column(name = "SS")
	private String ss;
	@NotEmpty
	@Size(min = 13, max = 13)
	@Column(name = "MLB")
	private String mlb; //not null 13char
	@Column(name = "OSTALA_ZANIMANJA")
	private String ostalaZanimanja;
	@Column(name = "SIF_MESTO")  //nisam uneo
	private int sifMesto;


	//@ManyToOne
	@OneToOne//(mappedBy = "licniPodaci")
	@JoinColumn(name = "SRPSKA_SLAVA")
	private SrpskaSlava srpskaSlava;

	@Column(name = "ZANIMANJE")
	private int zanimanje;
	@Column(name = "NAZIV_FIRME")
	private int nazivFirme;
	@Column(name = "RM")
	private int rm;
	@Column(name = "SINDIKAT") //nisam uneo
	private int sindikat;
	@NotEmpty
	@Column(name = "BLK")
	private String blk;
	@Column(name = "SMS_MOBILE")
	private String smsMobile;
	@Column(name = "SMS_MOBILE_POM")
	private String smsMobilePom;

	public LicniPodaci() {
	}

	public LicniPodaci(String imeRoditelja, String adresa, String prezime, String ime, String kontaktAdresa, String tel1, String tel2, String tel3, String pol, Date datumRodjenja, String bracnoStanje, String pejdzer, String email, String foto, String radniStatus, String ss, String mlb, String ostalaZanimanja, int sifMesto, SrpskaSlava srpskaSlava, int zanimanje, int nazivFirme, int rm, int sindikat, String blk, String smsMobile, String smsMobilePom) {
		this.imeRoditelja = imeRoditelja;
		this.adresa = adresa;
		this.prezime = prezime;
		this.ime = ime;
		this.kontaktAdresa = kontaktAdresa;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.tel3 = tel3;
		this.pol = pol;
		this.datumRodjenja = datumRodjenja;
		this.bracnoStanje = bracnoStanje;
		this.pejdzer = pejdzer;
		this.email = email;
		this.foto = foto;
		this.radniStatus = radniStatus;
		this.ss = ss;
		this.mlb = mlb;
		this.ostalaZanimanja = ostalaZanimanja;
		this.sifMesto = sifMesto;
		this.srpskaSlava = srpskaSlava;
		this.zanimanje = zanimanje;
		this.nazivFirme = nazivFirme;
		this.rm = rm;
		this.sindikat = sindikat;
		this.blk = blk;
		this.smsMobile = smsMobile;
		this.smsMobilePom = smsMobilePom;
	}

	public String getImeRoditelja() {
		return imeRoditelja;
	}

	public void setImeRoditelja(String imeRoditelja) {
		this.imeRoditelja = imeRoditelja;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getKontaktAdresa() {
		return kontaktAdresa;
	}

	public void setKontaktAdresa(String kontaktAdresa) {
		this.kontaktAdresa = kontaktAdresa;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getTel3() {
		return tel3;
	}

	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}

	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getBracnoStanje() {
		return bracnoStanje;
	}

	public void setBracnoStanje(String bracnoStanje) {
		this.bracnoStanje = bracnoStanje;
	}

	public String getPejdzer() {
		return pejdzer;
	}

	public void setPejdzer(String pejdzer) {
		this.pejdzer = pejdzer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getRadniStatus() {
		return radniStatus;
	}

	public void setRadniStatus(String radniStatus) {
		this.radniStatus = radniStatus;
	}

	public String getSs() {
		return ss;
	}

	public void setSs(String ss) {
		this.ss = ss;
	}

	public String getMlb() {
		return mlb;
	}

	public void setMlb(String mlb) {
		this.mlb = mlb;
	}

	public String getOstalaZanimanja() {
		return ostalaZanimanja;
	}

	public void setOstalaZanimanja(String ostalaZanimanja) {
		this.ostalaZanimanja = ostalaZanimanja;
	}

	public int getSifMesto() {
		return sifMesto;
	}

	public void setSifMesto(int sifMesto) {
		this.sifMesto = sifMesto;
	}

	public SrpskaSlava getSrpskaSlava() {
		return srpskaSlava;
	}

	public void setSrpskaSlava(SrpskaSlava srpskaSlava) {
		this.srpskaSlava = srpskaSlava;
	}

	public int getZanimanje() {
		return zanimanje;
	}

	public void setZanimanje(int zanimanje) {
		this.zanimanje = zanimanje;
	}

	public int getNazivFirme() {
		return nazivFirme;
	}

	public void setNazivFirme(int nazivFirme) {
		this.nazivFirme = nazivFirme;
	}

	public int getRm() {
		return rm;
	}

	public void setRm(int rm) {
		this.rm = rm;
	}

	public int getSindikat() {
		return sindikat;
	}

	public void setSindikat(int sindikat) {
		this.sindikat = sindikat;
	}

	public String getBlk() {
		return blk;
	}

	public void setBlk(String blk) {
		this.blk = blk;
	}

	public String getSmsMobile() {
		return smsMobile;
	}

	public void setSmsMobile(String smsMobile) {
		this.smsMobile = smsMobile;
	}

	public String getSmsMobilePom() {
		return smsMobilePom;
	}

	public void setSmsMobilePom(String smsMobilePom) {
		this.smsMobilePom = smsMobilePom;
	}
}
