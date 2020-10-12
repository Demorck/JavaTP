package cartes;

import java.util.Random;

public final class FabriqueCartes
{
    private static final FabriqueCartes instance = new FabriqueCartes();
    private PaquetDeCartes deck;

    private FabriqueCartes(){}

    public static FabriqueCartes getInstance()
    {
        return instance;
    }

    public PaquetDeCartes getPaquet32()
    {
        deck = new PaquetDeCartes();
        Random r = new Random();
        for (int i = 0; i < 32; i++)
        {
            deck.ajouter(new Carte(r.nextInt(32), Couleur.values()[r.nextInt(Couleur.values().length)]));
        }
        return deck;
    }

    public PaquetDeCartes get1Vert()
    {
        deck = new PaquetDeCartes();
        deck.ajouter(new Carte(1, Couleur.VERT));
        return deck;
    }

    public PaquetDeCartes getPaquetVide()
    {
        return new PaquetDeCartes();
    }
}
