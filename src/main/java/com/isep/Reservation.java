package com.isep;

public class Reservation {

    private String numeroReservation;
    private String dateReservation;
    private String statut;
    private Passager passager;
    private Vol vol;

    public Reservation(String numeroReservation, String dateReservation, Passager passager, Vol vol) {
        this.numeroReservation = numeroReservation;
        this.dateReservation = dateReservation;
        this.passager = passager;
        this.vol = vol;
        this.statut = "en attente";
    }

    public String getNumeroReservation() { return numeroReservation; }
    public String getStatut() { return statut; }
    public Passager getPassager() { return passager; }
    public Vol getVol() { return vol; }

    public void obtenirInfos() {
        System.out.println("Numero : " + numeroReservation);
        System.out.println("Date : " + dateReservation);
        System.out.println("Statut : " + statut);
        System.out.println("Passager : " + passager.getNom());
        System.out.println("Vol : " + vol.getNumeroVol());
    }
}
