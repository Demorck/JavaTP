package reseau.tests;

import reseau.adresses.Adresse;

public class TestAdresse {
    public static void main(String[] args)
    {
        testGetNbreOctetsAdresse();
        testSize();
        testToString();
        testMasque();
        testInverser();
    }

    private static void testGetNbreOctetsAdresse()
    {
        assert new Adresse(24).getNbreOctets() == 3: "Nombre d'octets incorrect";  
    }

    private static void testSize()
    {
        assert new Adresse(24).size() == 24: "Méthode size() ne fonctionne pas";
    }

    private static void testToString()
    {
        assert new Adresse("69.117.108.101.114.32").toString() == "Euler ": "Méthode toString() ne fonctionne pas.";
    }

    private static void testMasque()
    {
        Adresse a = new Adresse("192.168.1.50");
        Adresse masque = new Adresse("255.255.255.0");
        a.masquer(masque);
        assert a.isEqual(new Adresse("192.168.1.0")): "Méthode masquer(masque) ne fonctionne pas";
    }

    private static void testInverser()
    {
        Adresse a = new Adresse("255.255.0.0");
        a.inverser();
        assert a.isEqual(new Adresse("0.0.255.255")): "Méthode inverser() ne fonctionne pas";
    }
}
