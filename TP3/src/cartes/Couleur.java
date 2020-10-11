package cartes;

public enum Couleur
{
    BLUE("Bleu", "#0000ff"),
    RED("Rouge", "#ff0000"),
    YELLOW("Jaune", "#00ffff"),
    GREEN("Vert", "#00ff00");

    String fr, color;
    private Couleur(String fr, String color)
    {
        this.fr = fr;
        this.color = color;
    }

    public String getColor()
    {
        return this.color;
    }

    public String getFr()
    {
        return this.fr;
    }
}
