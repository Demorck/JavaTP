package cartes.tests;

import cartes.FabriqueCartes;
import cartes.PaquetDeCartes;
import cartes.Couleur;
import cartes.Carte;

public class TestPaquetDeCartes
{
    public static void main(String[] args)
    {
        getNombreDeCartes();
    }

    private static void getNombreDeCartes()
    {
        PaquetDeCartes pdc = new PaquetDeCartes();
        Carte c = new Carte(1, Couleur.VERT);
        pdc.ajouter(c);
        assert FabriqueCartes.getInstance().get1Vert().isEqual(pdc) : "Bug singleton get1Vert";
        assert FabriqueCartes.getInstance().getPaquet32().getNombreDeCartes() == 32 : "Bug singleton getPaquet32";
        assert FabriqueCartes.getInstance().getPaquetVide().getNombreDeCartes() == 0 : "Bug singleton getPaquetVide";
    }
}
