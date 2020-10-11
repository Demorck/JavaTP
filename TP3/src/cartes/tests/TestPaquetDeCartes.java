package cartes.tests;

import cartes.FabriqueCartes;
import cartes.PaquetDeCartes;

public class TestPaquetDeCartes
{
    public static void main(String[] args)
    {
        getNombreDeCartes();
    }

    private static void getNombreDeCartes()
    {
        assert FabriqueCartes.get1Vert().getNombreDeCartes() == 1 : "Bug singleton get1Vert";
        assert FabriqueCartes.getPaquet32().getNombreDeCartes() == 32 : "Bug singleton getPaquet32";
        assert FabriqueCartes.getPaquetVide().getNombreDeCartes() == 0 : "Bug singleton getPaquetVide";
    }
}
