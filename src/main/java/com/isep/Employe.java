package com.isep;

public class Employe extends Personne {

    private String numeroEmploye;
    private String dateEmbauche;

    public Employe(String identifiant, String nom, String adresse, String contact, String numeroEmploye, String dateEmbauche) {
        super(identifiant, nom, adresse, contact);
        this.numeroEmploye = numeroEmploye;
        this.dateEmbauche = dateEmbauche;
    }

    public String getNumeroEmploye() { return numeroEmploye; }
    public String getDateEmbauche() { return dateEmbauche; }

    public String obtenirRole() {
        return "Employe";
    }

    public void obtenirInfos() {
        super.obtenirInfos();
        System.out.println("Numero employe : " + numeroEmploye);
        System.out.println("Date embauche : " + dateEmbauche);
        System.out.println("Role : " + obtenirRole());
    }
}
