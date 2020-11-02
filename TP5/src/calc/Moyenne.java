package calc;

import java.util.ArrayList;

public class Moyenne extends Naire
{
    public Moyenne(ArrayList<Nombre> e)
    {
        super(e);
    }

    public Moyenne(Nombre ... e)
    {
        super(e);
    }

    public int valeur()
    {
        int res = 0;
        for (Nombre nombre : naire)
            res += nombre.valeur();
        
        res /= naire.size();
        return res;
    }

    public String getOperateur()
    {
        return "moyenne";
    }
}
