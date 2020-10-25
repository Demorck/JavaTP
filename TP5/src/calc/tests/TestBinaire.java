package calc.tests;
import calc.*;

public class TestBinaire
{
    public static void main(String[] args)
    {
        TestNombre.testNombre();

        TestSomme.testValeur();
        TestSomme.testOperateur();

        TestDifference.testValeur();
        TestDifference.testOperateur();

        TestProduit.testValeur();
        TestProduit.testOperateur();

        TestQuotient.testValeur();
        TestQuotient.testOperateur();

    }

    private static void testToString()
    {

    }
}
