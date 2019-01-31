package com.ds.baza.dsbaza.commands;

import com.ds.baza.dsbaza.model.*;
import com.ds.baza.dsbaza.model.Constraints.FirmeValidatorConstraint;
import com.ds.baza.dsbaza.model.Constraints.RmValidatorConstraint;
import com.ds.baza.dsbaza.model.Constraints.SrpskaSlavaValidatorConstraint;
import com.ds.baza.dsbaza.model.Constraints.ZanimanjeValidatorConstraint;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

public class LicniPodaciCommand {

    private String imeRoditelja;
    @NotEmpty
    private String adresa;
    @NotEmpty
    private String prezime;
    @NotEmpty
    private String ime;
    private String kontaktAdresa;
    private String tel1;
    private String tel2;
    private String tel3;
    private String pol;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date datumRodjenja;
    private String bracnoStanje;
    private String pejdzer;
    private String email;
    private String foto;
    private String radniStatus;
    private String ss;
    @NotEmpty
    @Size(min = 13, max = 13)
    //@MlbValidatorConstraint
    private String mlb; //not null 13char
    private String ostalaZanimanja;
    private int sifMesto;   //nisam uneo

    @SrpskaSlavaValidatorConstraint
    private SrpskaSlava srpskaSlava;
    @ZanimanjeValidatorConstraint
    private Zanimanje zanimanje;
    @FirmeValidatorConstraint
    private Firme firme;
    @RmValidatorConstraint
    private Rm rm;
    private int sindikat; //nisam uneo
    @NotEmpty
    private String blk;
    private String smsMobile;
    private String smsMobilePom;

    private Clanovi clanovi;

    public LicniPodaciCommand() {
    }

    public LicniPodaciCommand(String imeRoditelja, @NotEmpty String adresa, @NotEmpty String prezime, @NotEmpty String ime, String kontaktAdresa, String tel1, String tel2, String tel3, String pol, Date datumRodjenja, String bracnoStanje, String pejdzer, String email, String foto, String radniStatus, String ss, @NotEmpty @Size(min = 13, max = 13) String mlb, String ostalaZanimanja, int sifMesto, SrpskaSlava srpskaSlava, Zanimanje zanimanje, Firme firme, Rm rm, int sindikat, @NotEmpty String blk, String smsMobile, String smsMobilePom, Clanovi clanovi) {
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
        this.firme = firme;
        this.rm = rm;
        this.sindikat = sindikat;
        this.blk = blk;
        this.smsMobile = smsMobile;
        this.smsMobilePom = smsMobilePom;
        this.clanovi = clanovi;
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

    public Zanimanje getZanimanje() {
        return zanimanje;
    }

    public void setZanimanje(Zanimanje zanimanje) {
        this.zanimanje = zanimanje;
    }

    public Firme getFirme() {
        return firme;
    }

    public void setFirme(Firme firme) {
        this.firme = firme;
    }

    public Rm getRm() {
        return rm;
    }

    public void setRm(Rm rm) {
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

    public Clanovi getClanovi() {
        return clanovi;
    }

    public void setClanovi(Clanovi clanovi) {
        this.clanovi = clanovi;
    }
}
