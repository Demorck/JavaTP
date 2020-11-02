package calc.tests;
import calc.Max;
import calc.Nombre;

public class TestMax
{
    public static void testValeur()
    {
        assert 3 == new Max(new Nombre(3), new Nombre(2), new Nombre(-2)).valeur() : "Problème sur la valeur de Max.";  
    }

    public static void testOperateur()
    {
        assert "max" == new Max(new Nombre(1), new Nombre(1)).getOperateur() : "Problème sur le getOperateur de Max.";  
    }

}
