package cartes;

public enum Couleur
{
    BLUE("Bleu"),
    RED("Rouge"),
    YELLOW("Jaune"),
    GREEN("Vert");

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
