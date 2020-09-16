package projetAwaz;

import awaz.Awaz;
import awaz.AwazImage;

import java.util.Scanner;

/**
 * Cette classe est le point de départ du Tp Awaz
 * @author martine
 * @version Janvier 2018
 */
public class MainAwaz {
    public static void main(String[] args) {
        // Création d'une mélodie vide
        Awaz melodie = new Awaz() ;
        melodie.add("Mi");
        melodie.add("Ré#");
        melodie.add("Mi");
        melodie.add("Ré#");
        melodie.add("Mi");
        melodie.add("Si");
        melodie.add("Ré");
        melodie.add("Do");
        melodie.add("la");

        String melodieABC = melodie.toABC();
        AwazImage partition = new AwazImage();
        partition.setMelodie(melodieABC);
    }
}

        /*String melodieString = melodie.toString();
        int nbNotes = melodie.nbNotes();
        melodie.transposer(2);
        String melodieTrans = melodie.toString();
        System.out.println(nbNotes);
        for (int i =0; i < nbNotes; i++)
        {
            System.out.print(melodie.ieme(i) + " ");
        }*/
        /*Scanner userInput = new Scanner(System.in);
        melodie.enregistrer(userInput.nextLine());*/