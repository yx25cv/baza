package com.ds.baza.dsbaza.model;
//: drop table, cascade constraint

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@Table(name = "FIRME")
public class Firme {
	@Id
	@GeneratedValue
	@Column(name = "NAZIV_FIRME")
	private Long id;
	@Column(name = "NAZIV")
	private String naziv;
	@Column(name = "TEL")
	private String tel;
	@Column(name = "ADRESA_FIRME")
	private String adresaFirme;
	@Column(name = "SIFRA_OPSTINE")
	private int sifraOpstine;
	@Column(name = "SVOJINA")
	private String svojina;
	@Column(name = "SIFRA_DELATNOSTI")
	private int sifraDelatnosti;
	@Column(name = "BR_ZAP")
	private int brZap = 0;

	public Firme() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdresaFirme() {
		return adresaFirme;
	}

	public void setAdresaFirme(String adresaFirme) {
		this.adresaFirme = adresaFirme;
	}

	public int getSifraOpstine() {
		return sifraOpstine;
	}

	public void setSifraOpstine(int sifraOpstine) {
		this.sifraOpstine = sifraOpstine;
	}

	public String getSvojina() {
		return svojina;
	}

	public void setSvojina(String svojina) {
		this.svojina = svojina;
	}

	public int getSifraDelatnosti() {
		return sifraDelatnosti;
	}

	public void setSifraDelatnosti(int sifraDelatnosti) {
		this.sifraDelatnosti = sifraDelatnosti;
	}

	public int getBrZap() {
		return brZap;
	}

	public void setBrZap(int brZap) {
		this.brZap = brZap;
	}
}
