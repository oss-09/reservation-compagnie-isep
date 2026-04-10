package com.isep;

import java.util.ArrayList;
import java.util.List;

public class Vol {

    private String numeroVol;
    private Aeroport origine;
    private Aeroport destination;
    private String dateHeureDepart;
    private String dateHeureArrivee;
    private String etat;
    private Avion avion;
    private Pilote pilote;
    private List<PersonnelCabine> equipageCabine;
    private List<Passager> passagers;

    // liste statique partagee entre tous les vols
    private static List<Vol> planning = new ArrayList<>();

    public Vol(String numeroVol, Aeroport origine, Aeroport destination, String dateHeureDepart, String dateHeureArrivee) {
        this.numeroVol = numeroVol;
        this.origine = origine;
        this.destination = destination;
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
        this.etat = "planifie";
        this.equipageCabine = new ArrayList<>();
        this.passagers = new ArrayList<>();
    }

    public String getNumeroVol() { return numeroVol; }
    public Aeroport getOrigine() { return origine; }
    public Aeroport getDestination() { return destination; }
    public String getEtat() { return etat; }
    public Avion getAvion() { return avion; }
    public List<Passager> getPassagers() { return passagers; }
    public static List<Vol> getPlanning() { return planning; }
   

    public void obtenirInfos() {
        System.out.println("Numero vol : " + numeroVol);
        System.out.println("De : " + origine.getVille());
        System.out.println("Vers : " + destination.getVille());
        System.out.println("Depart : " + dateHeureDepart);
        System.out.println("Arrivee : " + dateHeureArrivee);
        System.out.println("Etat : " + etat);
    }
}
