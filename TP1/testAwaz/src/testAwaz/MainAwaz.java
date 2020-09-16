package testAwaz;

import awaz.Awaz;
import awaz.AwazImage;

/**
 * Cette classe est le point de d�part du Tp Awaz
 * @author martine
 * @version Janvier 2018
 */
public class MainAwaz {
    public static void main(String[] args) {
        // Cr�ation d'une m�lodie vide
        Awaz melodie = new Awaz() ;
        melodie.add("Do");
        melodie.add("Do");

        melodie.add("Do");
        melodie.add("Do");
        melodie.add("Do");
        melodie.add("Do");
        melodie.add("Do");
        melodie.add("Do");
        melodie.add("Do");
        melodie.enregistrer("Nom");
        String melodieABC = melodie.toABC();
        AwazImage partition = new AwazImage();
        partition.setMelodie(melodieABC);
        // A compl�ter ...  
        //  ...


    }
}
