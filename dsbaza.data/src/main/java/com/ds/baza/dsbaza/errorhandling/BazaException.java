package com.ds.baza.dsbaza.errorhandling;

import org.springframework.web.bind.annotation.ExceptionHandler;


public class BazaException extends RuntimeException{

    int statusCode;

    String statusMessage;

    String polje;

    public String getPolje() {
        return polje;
    }

    public void setPolje(String polje) {
        this.polje = polje;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public BazaException() {
        // TODO Auto-generated constructor stub
    }

    public BazaException(int statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public BazaException(Pair<Integer, String> pair) {
        this(pair.getFirst(), pair.getSecond());
    }

    public BazaException(Pair<Integer, String> pair, String polje) {
        this(pair.getFirst(), pair.getSecond());
        this.polje = polje;
    }


    public Pair<Integer, String> getError () {
        return new Pair<Integer, String>(this.statusCode, this.statusMessage);
    }



    public static Pair<Integer, String> OK = new Pair<Integer, String>(0, "Success");
    public static Pair<Integer, String> JMBG_NIJE_ISPRAVAN = new Pair<Integer, String>(1, "JMBG nije ispravan");
    public static Pair<Integer, String> THERE_IS_NO_RESULT = new Pair<Integer, String>(109, "Nije pronadjen nijedan rezultat!");
    public static Pair<Integer, String> INVALID_DATE = new Pair<Integer, String>(110, "Datum mora biti unet u sledecem formatu DD.MM.YYYY.");
    public static Pair<Integer, String> NASLOV = new Pair<Integer, String>(102, "Naslov nije dobar");
    public static Pair<Integer, String> KRATAK_SADRZAJ = new Pair<Integer, String>(103, "Kratak sadrzaj nije dobar");
    public static Pair<Integer, String> SADRZAJ = new Pair<Integer, String>(104, "Sadrzaj nije dobar");
    public static Pair<Integer, String> CATEGORY = new Pair<Integer, String>(105, "Kategorija nije dobra");
    public static Pair<Integer, String> PROBLEM_SA_BAZOM = new Pair<Integer, String>(106, "Nije uspeo upis u bazu");
    public static Pair<Integer, String> ALREADY_EXIST = new Pair<Integer, String>(107, "Vec postoji objekat u bazi sa istim imenom");
    public static Pair<Integer, String> ID_DOESNT_EXIST = new Pair<Integer, String>(108, "ID nije pronadjen");


}
