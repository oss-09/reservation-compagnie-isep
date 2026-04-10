package com.isep;

import java.util.ArrayList;
import java.util.List;

public class Passager extends Personne {

    private String passeport;
    private List<Reservation> reservations;

    public Passager(String identifiant, String nom, String adresse, String contact, String passeport) {
        super(identifiant, nom, adresse, contact);
        this.passeport = passeport;
        this.reservations = new ArrayList<>();
    }

    public String getPasseport() { return passeport; }
    public List<Reservation> getReservations() { return reservations; }

    // le passager réserve un vol
    public void reserverVol(Reservation reservation) {
        reservations.add(reservation);
        reservation.confirmerReservation();
        System.out.println(getNom() + " a reserve le vol " + reservation.getVol().getNumeroVol());
    }

    // annuler une réservation par son ID
    public void annulerReservation(String numeroReservation) {
        Reservation trouve = obtenirReservations(numeroReservation);
        if (trouve != null) {
            trouve.annulerReservation();
            reservations.remove(trouve);
        } else {
            System.out.println("Reservation " + numeroReservation + " introuvable");
        }
    }

    // obtenir une réservation par son ID
    public Reservation obtenirReservations(String numeroReservation) {
        for (Reservation r : reservations) {
            if (r.getNumeroReservation().equals(numeroReservation)) {
                return r;
            }
        }
        return null;
    }

    public void obtenirInfos() {
        super.obtenirInfos();
        System.out.println("Passeport : " + passeport);
    }
}
