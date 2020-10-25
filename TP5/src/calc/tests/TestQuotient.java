package calc.tests;
import calc.Quotient;
import calc.Nombre;

public class TestQuotient
{
    public static void testValeur()
    {
        assert 3 == new Quotient(new Nombre(3), new Nombre(1)).valeur() : "Problème sur la valeur de Quotient.";  
    }

    public static void testOperateur()
    {
        assert "/" == new Quotient(new Nombre(1), new Nombre(1)).getOperateur() : "Problème sur le getOperateur de Quotient.";  
    }

}
