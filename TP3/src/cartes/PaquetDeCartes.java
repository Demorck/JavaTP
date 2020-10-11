package cartes;

import java.util.ArrayList;
import java.util.Collections;

public class PaquetDeCartes
{
    private ArrayList<Carte> deck;

    public PaquetDeCartes()
    {
        this.deck = new ArrayList<Carte>();
    }

    /**
     * Ajoute un toutes les cartes en paramètres à deck
     * @param cartes cartes en paramètres
     */
    public void ajouter(Carte... cartes)
    {
        for (Carte carte : cartes)
        {
            this.deck.add(carte);
        }
    }

    /**
     * Ajoute un paquet de carte à deck
     * @param pdc paquet de carte à ajouter
     */
    public void ajouter(PaquetDeCartes pdc)
    {
        this.deck.addAll(pdc.getDeck());
    }

    public ArrayList<Carte> getDeck()
    {
        return this.deck;
    }

    public int getNombreDeCartes()
    {
        return this.deck.size();
    }

    /**
     * Retourne vrai si vide, faux sinon
     * @return vrai si vide, faux sinon
     */
    public boolean estVide()
    {
        return this.deck.isEmpty();
    }

    /**
     * Mélange le paquet
     */
    public void melanger()
    {
        Collections.shuffle(this.deck);
    }

    /**
     * Retourne le paquet
     */
    public void retourner()
    {
        Collections.reverse(this.deck);
    }

    /**
     * Renvoie la somme de toutes les valeurs
     * @return la somme de toutes les valeurs
     */
    public int getValeur()
    {
        int s = 0;
        for (Carte carte : this.deck)
        {
            s += carte.getValeur();
        }
        return s;
    }

    /**
     * Retourne le sommet (sans l'enlever)
     * @return Retourne le sommet (sans l'enlever)
     */
    public Carte getSommet()
    {
        return this.estVide() ? null : this.deck.get(this.deck.size() - 1); // Si c'est vide, on return null
    }

    /**
     * Retourne le sommet (en l'enlevant)
     * @return Retourne le sommet (en l'enlevant)
     */
    public Carte piocher()
    {
        Carte tmpCarte = this.getSommet();
        this.deck.remove(this.deck.size() - 1);
        return tmpCarte;
    }

    public String toString()
    {
        String s = "PaquetDeCarte={";
        for (Carte carte : this.deck)
        {
            s += carte.toString();    
        }
        s += "}";
        return s;
    }
}
