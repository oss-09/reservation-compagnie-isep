package com.isep;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestionFichiers {

    public static List<Vol> importerVols(String cheminFichier) {
        List<Vol> vols = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            boolean premiereLigne = true;

            while ((ligne = reader.readLine()) != null) {
                // on saute l'en-tête
                if (premiereLigne) {
                    premiereLigne = false;
                    continue;
                }

                String[] colonnes = ligne.split("\\|");
                if (colonnes.length < 5) continue;

                String numeroVol    = colonnes[0].trim();
                String villeOrigine = colonnes[1].trim();
                String villeDesc    = colonnes[2].trim();
                String dateDepart   = colonnes[3].trim();
                String dateArrivee  = colonnes[4].trim();

                Aeroport origine      = new Aeroport(villeOrigine, villeOrigine, "");
                Aeroport destination  = new Aeroport(villeDesc, villeDesc, "");
                Vol vol = new Vol(numeroVol, origine, destination, dateDepart, dateArrivee);
                vols.add(vol);
            }

            System.out.println(vols.size() + " vol(s) importé(s) depuis " + cheminFichier);

        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }

        return vols;
    }

    public static void sauvegarderPassager(String cheminFichier, Passager passager, Reservation reservation) {
        // true = on ajoute à la fin du fichier sans écraser
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cheminFichier, true))) {

            String ligne = passager.getPasseport()
                    + "|" + passager.getNom()
                    + "|" + passager.getAdresse()
                    + "|" + passager.getContact()
                    + "|" + reservation.getNumeroReservation()
                    + "|" + reservation.getVol().getNumeroVol();

            writer.write(ligne);
            writer.newLine();

            System.out.println("Passager " + passager.getNom() + " sauvegardé dans " + cheminFichier);

        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture dans le fichier : " + e.getMessage());
        }
    }

    public static void afficherPassagersDepuisFichier(String cheminFichier) {
        try (BufferedReader reader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            boolean premiereLigne = true;

            System.out.println("Liste des passagers enregistrés :");

            while ((ligne = reader.readLine()) != null) {
                if (premiereLigne) {
                    premiereLigne = false;
                    continue;
                }
                System.out.println("  -> " + ligne);
            }

        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }

    public static void initialiserFichierPassagers(String cheminFichier) {
        File fichier = new File(cheminFichier);
        if (!fichier.exists()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichier))) {
                writer.write("passeport|nom|adresse|contact|numeroReservation|numeroVol");
                writer.newLine();
                System.out.println("Fichier " + cheminFichier + " créé.");
            } catch (IOException e) {
                System.err.println("Erreur lors de la création du fichier : " + e.getMessage());
            }
        }
    }

}
