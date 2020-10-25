package calc.tests;
import calc.Difference;
import calc.Nombre;

public class TestDifference
{
    public static void testValeur()
    {
        assert 1 == new Difference(new Nombre(3), new Nombre(2)).valeur() : "Problème sur la valeur de Difference.";  
    }

    public static void testOperateur()
    {
        assert "-" == new Difference(new Nombre(1), new Nombre(1)).getOperateur() : "Problème sur le getOperateur de Difference.";  
    }

}
