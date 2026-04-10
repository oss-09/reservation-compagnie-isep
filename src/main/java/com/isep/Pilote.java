package com.isep;

public class Pilote extends Employe {

    private String licence;
    private int heuresDeVol;

    public Pilote(String identifiant, String nom, String adresse, String contact, String numeroEmploye, String dateEmbauche, String licence, int heuresDeVol) {
        super(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche);
        this.licence = licence;
        this.heuresDeVol = heuresDeVol;
    }

    public String getLicence() { return licence; }
    public int getHeuresDeVol() { return heuresDeVol; }
    public void setHeuresDeVol(int heuresDeVol) { this.heuresDeVol = heuresDeVol; }

    public String obtenirRole() {
        return "Pilote";
    }

    public void obtenirInfos() {
        super.obtenirInfos();
        System.out.println("Licence : " + licence);
        System.out.println("Heures de vol : " + heuresDeVol);
    }
}
