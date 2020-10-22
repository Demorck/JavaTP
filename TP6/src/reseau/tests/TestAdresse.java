package reseau.tests;

import reseau.adresses.Adresse;

public class TestAdresse {
    public static void main(String[] args)
    {
        // testGetNbreOctetsAdresse();
        testToString();
    }

    private static void testGetNbreOctetsAdresse() {
        Adresse a ;
        int res ;

        // adresse créée vide
        a = new Adresse(24) ;
        res = a.getNbreOctets() ;
        assert(res==3):"Nombre d'octets incorrect" ;
        
    }

    private static void testToString() {
        System.out.println(new Adresse("192.32.43.100").toString());
        
    }
}
