package calc;

import java.util.ArrayList;

public class Max extends Naire
{
    public Max(ArrayList<Nombre> e)
    {
        super(e);
    }

    public Max(Nombre ... e)
    {
        super(e);
    }

    public int valeur()
    {
        int res = naire.get(0).valeur();
        for (Nombre nombre : naire)
            if (nombre.valeur() > res)
                res = nombre.valeur();
        
        return res;
    }

    public String getOperateur()
    {
        return "max";
    }
}
