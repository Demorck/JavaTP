package cartes;

public enum Couleur
{
    BLEU("Bleu"),
    ROUGE("Rouge"),
    JAUNE("Jaune"),
    VERT("Vert");

    String fr;
    private Couleur(String fr)
    {
        this.fr = fr;
    }

    public String getNom()
    {
        return this.fr;
    }

    public String toString()
    {
        return "Couleur={nom=\""+this.fr+"\"}";
    }

}
