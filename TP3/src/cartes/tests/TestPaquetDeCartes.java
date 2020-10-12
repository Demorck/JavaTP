package cartes.tests;

import cartes.FabriqueCartes;

public class TestPaquetDeCartes
{
    public static void main(String[] args)
    {
        getNombreDeCartes();
    }

    private static void getNombreDeCartes()
    {
        assert FabriqueCartes.getInstance().get1Vert().getNombreDeCartes() == 1 : "Bug singleton get1Vert";
        assert FabriqueCartes.getInstance().getPaquet32().getNombreDeCartes() == 32 : "Bug singleton getPaquet32";
        assert FabriqueCartes.getInstance().getPaquetVide().getNombreDeCartes() == 0 : "Bug singleton getPaquetVide";
    }
}
