package calc.tests;
import calc.Somme;
import calc.Nombre;

public class TestSomme
{
    public static void testValeur()
    {
        assert 5 == new Somme(new Nombre(3), new Nombre(2)).valeur() : "Problème sur la valeur de Somme."; 
    }

    public static void testOperateur()
    {
        assert "+" == new Somme(new Nombre(1), new Nombre(1)).getOperateur() : "Problème sur le getOperateur de Somme."; 
    }

}
