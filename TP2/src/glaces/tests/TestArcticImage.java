package glaces.tests;
import javax.swing.text.html.HTML;

import glaces.ArcticImage;
import glaces.Iceberg2D;
import glaces.Ocean;
import geometrie.*;

public class TestArcticImage
{
    public static void main(String[] args)
    {
        Iceberg2D i1 = new Iceberg2D(new Point(0.,0.), new Point(10., 20.));
        Iceberg2D i2 = new Iceberg2D(new Point(20.,90.), new Point(25., 99.));

        Ocean ocean = new Ocean();
        ocean.render(0);
        
    }
}
