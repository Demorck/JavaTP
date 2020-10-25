package calc.tests;
import calc.Nombre;

public class TestNombre
{
    public static void testNombre()
    {
        assert 2 == new Nombre(2).valeur() : "Problème sur le testNombre";
    }
}
