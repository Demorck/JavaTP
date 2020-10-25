package calc;

public abstract class Fonction implements Expression
{
    protected Expression gauche;
    protected Expression droit;

    public Fonction(Expression g, Expression d)
    {
        this.gauche = g;
        this.droit = d;
    }

    public String toString()
    {
        return getOperateur() + "(" + gauche + "," + droit + ")";
    }

    public abstract String getOperateur();
}
