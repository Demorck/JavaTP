package calc.tests;
import calc.Moyenne;
import calc.Nombre;

public class TestMoyenne
{
    public static void testValeur()
    {
        assert 4 == new Moyenne(new Nombre(3), new Nombre(2), new Nombre(6)).valeur() : "Problème sur la valeur de Moyenne.";  
    }

    public static void testOperateur()
    {
        assert "moyenne" == new Moyenne(new Nombre(1), new Nombre(1)).getOperateur() : "Problème sur le getOperateur de Moyenne.";  
    }

}
