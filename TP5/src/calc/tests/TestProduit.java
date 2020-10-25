package calc.tests;
import calc.Produit;
import calc.Nombre;

public class TestProduit
{
    public static void testValeur()
    {
        assert 6 == new Produit(new Nombre(3), new Nombre(2)).valeur() : "Problème sur la valeur de Produit.";  
    }

    public static void testOperateur()
    {
        assert "*" == new Produit(new Nombre(1), new Nombre(1)).getOperateur() : "Problème sur le getOperateur de Produit.";  
    }

}
