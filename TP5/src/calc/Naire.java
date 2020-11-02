package calc;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Naire implements Expression
{
    protected ArrayList<Nombre> naire;

    public Naire(ArrayList<Nombre> n)
    {
        this.naire = n;
    }

    public Naire(Nombre ... n)
    {
        this.naire = new ArrayList<Nombre>(Arrays.asList(n));
    }

    public String toString()
    {
        StringBuilder res = new StringBuilder();
        res.append(this.getOperateur() + "(");
        for (int i = 0; i < naire.size(); i++)
        {
            if (i + 1 == naire.size())
                res.append(naire.get(i).toString());
            else
            res.append(naire.get(i).toString() + ",");
        }
        res.append(")");
        return res.toString();
    }

    public abstract String getOperateur();
}
