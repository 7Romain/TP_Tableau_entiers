package fr.oz;

import java.lang.ModuleLayer.Controller;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;

public class App {

    String nom;
    static int taille;
    static int[] tableau;
    static String reponse;
    static String resultat = "";

    static void remplir(int[] aRemplir) {
        for (int i = 0; i < taille; i++) {
            Random random = new Random();
            int ranInt = 1 + (random.nextInt(50));
            aRemplir[i] = ranInt;
        }

    }

    static void afficher(int[] aAfficher) {

        resultat = "";
        for (int i = 0; i < taille; i++) {
            resultat = resultat + (("tableau") + " [" + i + "] " + "=" + tableau[i] + " \n");
        }
        JOptionPane.showMessageDialog(null, resultat, " Tableau de " + taille + " entiers.  ",
                JOptionPane.INFORMATION_MESSAGE);
    }

    static int[] trier(int[] aTrier) {

        int temp;
        for (int i = aTrier.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++)
                if (aTrier[j] > aTrier[j + 1]) {
                    temp = aTrier[j + 1];
                    aTrier[j + 1] = aTrier[j];
                    aTrier[j] = temp;
                }
        }
        return aTrier;

    }

    static void trierEz(int[] aTrier) {
        Arrays.sort(aTrier);
        // Arrays.sort(aTrier, Collections.reverseOrder());
    }

    public static void main(String[] args) throws ExceptionTaille {
        System.out.println("Hello World!");
        while (taille == 0) {
            reponse = JOptionPane.showInputDialog(null, "Veuillez saisir le nombre d'éléments SVP, et pas zéro ! ");
            try {
                taille = Integer.parseInt(reponse);
                if (taille <= 0)
                    throw new NumberFormatException();

                System.out.println(reponse);
                System.out.println(taille);
            } catch (NumberFormatException ex) {
                System.out.println("The number is not an integer ");
                JOptionPane.showMessageDialog(null,
                        "Veuillez entrer un supérieur à zéro",
                        "Attention!", JOptionPane.INFORMATION_MESSAGE);

            }

        }
        tableau = new int[taille];
        System.out.println(tableau.length);
        remplir(tableau);
        System.out.println(tableau[2]);
        afficher(tableau);
        trierEz(tableau);

        afficher(tableau);

    }

}
