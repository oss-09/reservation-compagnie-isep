package com.isep;

public class PersonnelCabine extends Employe {

    private String qualification;

    public PersonnelCabine(String identifiant, String nom, String adresse, String contact, String numeroEmploye, String dateEmbauche, String qualification) {
        super(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche);
        this.qualification = qualification;
    }

    public String getQualification() { return qualification; }
    public void setQualification(String qualification) { this.qualification = qualification; }

    public String obtenirRole() {
        return "Personnel Cabine";
    }

    public void obtenirInfos() {
        super.obtenirInfos();
        System.out.println("Qualification : " + qualification);
    }
}
