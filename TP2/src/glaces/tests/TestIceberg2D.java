package glaces.tests;
import glaces.Iceberg2D;
import geometrie.*;

public class TestIceberg2D
{
    public static void main(String[] args)
    {
        Iceberg2D i1 = new Iceberg2D(new Point(2, 2), new Point(6, 6));
        Iceberg2D i2 = new Iceberg2D(new Point(7, 0), new Point(9, 10));
        System.out.println("Hauteur: " + i1.hauteur() + 
                            "\nLargeur: " + i1.largeur() + 
                            "\nSurface: " + i1.surface() + 
                            "\nCollision avec i2 : " + i1.collision(i2) + 
                            "\nCentre : " + i1.centre() +
                            "\nCoordonnées : " + i1.toString());
        i1.fondre(0.5);
        System.out.println("Coordonnées après fonte 0.5: " + i1.toString() + 
                           "\nCentre après fonte: " + i1.centre() +
                           "\nSurface après fonte: " + i1.surface());

    }
}
