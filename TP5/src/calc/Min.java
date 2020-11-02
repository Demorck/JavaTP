package calc;

import java.util.ArrayList;

public class Min extends Naire
{
    public Min(ArrayList<Nombre> e)
    {
        super(e);
    }

    public Min(Nombre ... e)
    {
        super(e);
    }

    public int valeur()
    {
        int res = naire.get(0).valeur();
        for (Nombre nombre : naire)
            if (nombre.valeur() < res)
                res = nombre.valeur();
        
        return res;
    }

    public String getOperateur()
    {
        return "min";
    }
}
