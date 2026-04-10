package com.isep;

public class Main {

    // Le lien : https://github.com/oss-09/reservation-compagnie-isep
    // Tim Schoulmann-Doré
    // Osama ALAHYANE

    public static void main(String[] args) {

        Aeroport paris = new Aeroport("CDG", "Paris", "Charles de Gaulle");
        Aeroport london = new Aeroport("LHR", "Londres", "Heathrow");
        Aeroport madrid = new Aeroport("MAD", "Madrid", "Adolfo Suarez");

        Avion avion1 = new Avion("F-GKXA", "Airbus A320", 180);
        Avion avion2 = new Avion("F-GKXB", "Boeing 737", 160);

        Pilote pilote1 = new Pilote("P001", "Oss", "Paris", "0601020304", "EMP001", "2026-06-11", "ATPL-001", 5000);
        PersonnelCabine steward1 = new PersonnelCabine("PC001", "Marie Martin", "Lyon", "0607080910", "EMP002", "2026-03-15", "Service Premium");

        Vol vol1 = new Vol("AF101", paris, london, "2026-04-20 08:00", "2026-04-20 09:30");
        Vol vol2 = new Vol("AF102", paris, madrid, "2026-04-20 12:00", "2026-04-20 14:00");

        // planifier les vols
        vol1.planifierVol();
        vol2.planifierVol();

        // afficher le planning
        Vol.afficherPlanning();

        // affecter equipage
        vol1.affecterVol(avion1, pilote1, steward1);
        vol2.affecterVol(avion2, pilote1, steward1);

        // obtenir un vol par ID
        Vol trouve = Vol.obtenirVol("AF101");
        if (trouve != null) {
            trouve.obtenirInfos();
        }

        // annuler un vol par ID
        Vol.annulerVol("AF102");

        // afficher planning apres annulation
        Vol.afficherPlanning();

        // tester reservation
        Passager passager1 = new Passager("PA001", "Osama tim", "Mar", "0698765432", "TN123456");
        Reservation res1 = new Reservation("RES001", "2025-04-10", passager1, vol1);
        passager1.reserverVol(res1);

        vol1.listingPassagers();

        passager1.annulerReservation("RES001");

        vol1.listingPassagers();
    }
}
