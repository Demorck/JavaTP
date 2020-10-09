package cartes;

import java.util.ArrayList;

public class PaquetDeCartes
{
    private ArrayList<Carte> deck;

    public PaquetDeCartes()
    {

    }

    public void addCards(Carte ... cartes)
    {
        for (Carte carte : cartes)
        {
            deck.add(carte);
        }
    }

    public int getDeckCount()
    {
        return deck.size();
    }
}
