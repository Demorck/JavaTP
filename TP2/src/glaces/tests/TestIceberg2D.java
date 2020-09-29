package glaces.tests;
import glaces.Iceberg2D;
import geometrie.*;

public class TestIceberg2D
{
    public static void main(String[] args)
    {
        testEstPlusGrosQueFaux();
        testEstPlusGrosQueVrai();

        testHauteur();
        testLargeur();
        testSurface();

        testCollisionFaux();
        testCollisionVrai();

        testCentre();

        testFondre();

        testCasserDroite();
        testCasserGauche();
        testCasserHaut();
        testCasserBas();
    }

    private static void testEstPlusGrosQueFaux()
    {
        Point p1, p2, p3, p4;
        Iceberg2D i1, i2;
        boolean b;

        p1 = new Point(1., 2.);
        p2 = new Point(3., 4.);
        i1 = new Iceberg2D(p1, p2);

        p3 = new Point(10., 20.);
        p4 = new Point(30., 40.);
        i2 = new Iceberg2D(p3, p4);
        b = i1.estPlusGrosQue(i2);

        assert(!b): "Bug quand le receveur est plus petit que le paramètre";
    }

    private static void testEstPlusGrosQueVrai()
    {
        Point p1, p2, p3, p4;
        Iceberg2D i1, i2;
        boolean b;

        p1 = new Point(1., 2.);
        p2 = new Point(3., 4.);
        i1 = new Iceberg2D(p1, p2);

        p3 = new Point(10., 20.);
        p4 = new Point(30., 40.);
        i2 = new Iceberg2D(p3, p4);
        b = i2.estPlusGrosQue(i1);

        assert(b): "Bug quand le receveur est plus gros que le paramètre";
    }

    private static void testHauteur()
    {
        Iceberg2D i1 = new Iceberg2D(new Point(5.,0.), new Point(700., 20.));
        Iceberg2D i2 = new Iceberg2D(new Point(5.,0.), new Point(700., 20000.));

        assert(i1.hauteur() == 20): "Bug sur la hauteur pour une petite hauteur";
        assert(i2.hauteur() == 20000): "Bug sur la hauteur pour une grande hauteur";
    }

    private static void testLargeur()
    {
        Iceberg2D i1 = new Iceberg2D(new Point(0.,5.), new Point(20., 20000.));
        Iceberg2D i2 = new Iceberg2D(new Point(0.,5.), new Point(70000., 1.));

        assert(i1.largeur() == 20): "Bug sur la largeur pour une petite largeur";
        assert(i2.largeur() == 70000): "Bug sur la largeur pour une grande largeur";
    }

    private static void testSurface()
    {
        Iceberg2D i1 = new Iceberg2D(new Point(0.,0.), new Point(10., 20.));
        Iceberg2D i2 = new Iceberg2D(new Point(0.,0.), new Point(10000., 20000.));

        assert(i1.surface() == 200): "Bug sur la surface pour une petite surface";
        assert(i2.surface() == 200000000): "Bug sur la surface pour une grande surface";
    }

    private static void testCollisionFaux()
    {
        Iceberg2D i1 = new Iceberg2D(new Point(0.,0.), new Point(10., 20.));
        Iceberg2D i2 = new Iceberg2D(new Point(30.,50.), new Point(10000., 20000.));

        assert(!i1.collision(i2)): "Bug quand il n'y a pas de collision";
    }

    private static void testCollisionVrai()
    {
        Iceberg2D i1 = new Iceberg2D(new Point(0.,0.), new Point(10., 20.));
        Iceberg2D i2 = new Iceberg2D(new Point(0.,0.), new Point(10000., 20000.));

        assert(i1.collision(i2)): "Bug quand il y a une collision (i1 inclus dans i2)";

        i1 = new Iceberg2D(new Point(0.,0.), new Point(10., 20.));
        i2 = new Iceberg2D(new Point(0.,20.), new Point(10000., 20000.));

        assert(i1.collision(i2)): "Bug quand il y a une collision (i1 et i2 se touchent)";

        i1 = new Iceberg2D(new Point(0.,0.), new Point(10., 20.));
        i2 = new Iceberg2D(new Point(0.,15.), new Point(10000., 20000.));

        assert(i1.collision(i2)): "Bug quand il y a une collision (normale)";
    }

    private static void testCentre()
    {
        Iceberg2D i1 = new Iceberg2D(new Point(0.,0.), new Point(10., 20.));
        Iceberg2D i2 = new Iceberg2D(new Point(10.,30.), new Point(10000., 20000.));

        assert(i1.centre().equals(new Point(5, 10))): "";
        assert(i2.centre().equals(new Point(5005, 10015))): "";
    }

    private static void testFondre()
    {
        Iceberg2D i1 = new Iceberg2D(new Point(0.,0.), new Point(10., 20.));

        i1.fondre(0.5);
        boolean b = i1.coinEnBasAGauche().equals(new Point(2.5, 5)) && i1.coinEnHautADroite().equals(new Point(7.5, 15));
        assert(b): "Bug sur fondre à 0.5";


        i1 = new Iceberg2D(new Point(0.,0.), new Point(10., 20.));

        i1.fondre(0.99);
        b = i1.coinEnBasAGauche().equals(new Point(4.95, 9.9)) && i1.coinEnHautADroite().equals(new Point(5.05, 10.1));
        assert(b): "Bug sur fondre à 0.99";
    }

    private static void testCasserDroite()
    {
        Iceberg2D i1 = new Iceberg2D(new Point(0.,0.), new Point(10., 20.));

        i1.casserDroite(0.5);
        boolean b =i1.coinEnHautADroite().equals(new Point(7.5, 20));
        assert(b): "Bug sur casserDroite à 0.5";


        i1 = new Iceberg2D(new Point(0.,0.), new Point(10., 20.));

        i1.casserDroite(0.99);
        b = i1.coinEnHautADroite().equals(new Point(5.05, 20));
        assert(b): "Bug sur casserDroite à 0.99";
    }

    private static void testCasserGauche()
    {
        Iceberg2D i1 = new Iceberg2D(new Point(0.,0.), new Point(10., 20.));

        i1.casserGauche(0.5);
        boolean b = i1.coinEnBasAGauche().equals(new Point(2.5, 0));
        assert(b): "Bug sur casserGauche à 0.5";


        i1 = new Iceberg2D(new Point(0.,0.), new Point(10., 20.));

        i1.casserGauche(0.99);
        b = i1.coinEnBasAGauche().equals(new Point(4.95, 0));
        assert(b): "Bug sur casserGauche à 0.99";
    }

    private static void testCasserHaut()
    {
        Iceberg2D i1 = new Iceberg2D(new Point(0.,0.), new Point(10., 20.));

        i1.casserHaut(0.5);
        boolean b =i1.coinEnHautADroite().equals(new Point(10, 15));
        assert(b): "Bug sur casserHaut à 0.5";


        i1 = new Iceberg2D(new Point(0.,0.), new Point(10., 20.));

        i1.casserHaut(0.99);
        b = i1.coinEnHautADroite().equals(new Point(10, 10.1));
        assert(b): "Bug sur casserHaut à 0.99";
    }

    private static void testCasserBas()
    {
        Iceberg2D i1 = new Iceberg2D(new Point(0.,0.), new Point(10., 20.));

        i1.casserBas(0.5);
        boolean b =i1.coinEnBasAGauche().equals(new Point(0, 5));
        assert(b): "Bug sur casserBas à 0.5";


        i1 = new Iceberg2D(new Point(0.,0.), new Point(10., 20.));

        i1.casserBas(0.99);
        b = i1.coinEnBasAGauche().equals(new Point(0, 9.9));
        assert(b): "Bug sur casserBas à 0.99";
    }
}
