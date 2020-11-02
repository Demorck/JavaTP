package calc.tests;
import calc.Min;
import calc.Nombre;

public class TestMin
{
    public static void testValeur()
    {
        assert -2 == new Min(new Nombre(3), new Nombre(2),  new Nombre(-2)).valeur() : "Problème sur la valeur de Min.";  
    }

    public static void testOperateur()
    {
        assert "min" == new Min(new Nombre(1), new Nombre(1)).getOperateur() : "Problème sur le getOperateur de Min.";  
    }

}
