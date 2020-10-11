package cartes;

public class Carte
{

    private int valeur ;
    private Couleur couleur ;

    public Carte(int valeur, Couleur couleur) {
        this.valeur = valeur;
        this.couleur = couleur;
    }

    public int getValeur() {
        return this.valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public Couleur getCouleur() {
        return this.couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public String toString() {
        return "Carte{" +
                "valeur=" + this.valeur +
                ", couleur=" + this.couleur +
                '}';
    }
}