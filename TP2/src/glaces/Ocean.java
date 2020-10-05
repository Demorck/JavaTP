package glaces;
import java.util.Arrays;
import java.util.Random;

import geometrie.Point;

/**
 * Un ocean rectangulaire contenant des Icebergs, poissons, etc.
 * @author Maximilien Antoine - Licence 2 maths & info.
 */
public class Ocean
{
    private int width;
    private int height;
    private int[][] tabOcean;
    private Iceberg2D[] icebergs;
    private ArcticImage window;
    private Pingouin pingouin;
    private Poisson[] poissons;
    private Boolean fishEaten;

    /**
     * Constructor avec une largeur, hauteur et deux icebergs
     * @param w largeur de l'océan
     * @param h hauteur de l'ocean
     * @param i1 premier iceberg
     * @param i2 second iceberg
     * @param pingHeight hauteur du pingouin
     */
    public Ocean(int w, int h, Iceberg2D i1, Iceberg2D i2, int pingHeight)
    {
        this.width = w;
        this.height = h;
        this.tabOcean = new int[this.width][this.height];
        this.icebergs = new Iceberg2D[2];
        this.poissons = new Poisson[5];
        this.icebergs[0] = i1;
        this.icebergs[1] = i2;
        this.window = new ArcticImage(this.width, this.height);
        this.fishEaten = false;

        this.pingouin = new Pingouin(pingHeight, new Point(this.width, 0));

        Random r = new Random();
        for (int i = 0; i < 5; i++)
        {
            this.poissons[i] = new Poisson(r.nextInt(20), r.nextInt(20), new Point(r.nextInt(this.width), r.nextInt(this.height)), r.nextBoolean());
        }
    }

    /**
     * Constructor avec largeur et hauteur prédéfinis pour l'océan mais avec un nombre d'icebergs aléatoire et pingouin aléatoire
     * @param w largeur de l'océan
     * @param h hauteur de l'ocean
     * @param randomIceberg nombre d'icebergs aléatoires
     */
    public Ocean(int w, int h, int randomIceberg)
    {
        Random r = new Random();

        this.width = w;
        this.height = h;
        this.tabOcean = new int[this.width][this.height];
        this.icebergs = new Iceberg2D[randomIceberg];
        this.poissons = new Poisson[5];
        this.fishEaten = false;

        for (int i = 0; i < randomIceberg; i++)
        {
            this.icebergs[i] = new Iceberg2D(new Point(r.nextInt(this.width), r.nextInt(this.height)), new Point(r.nextInt(this.width), r.nextInt(this.height)));
        }

        this.window = new ArcticImage(this.width, this.height);

        this.pingouin = new Pingouin(r.nextInt(this.width/10), new Point(this.width, 0));

        for (int i = 0; i < 5; i++)
        {
            this.poissons[i] = new Poisson(r.nextInt(20), r.nextInt(20), new Point(r.nextInt(this.width), r.nextInt(this.height)), r.nextBoolean());
        }
    }

    /**
     * Constructor avec largeur, hauteur, icebergs aléatoires, pingouin aléatoire
     */
    public Ocean()
    {
        Random r = new Random();
        int randomIceberg = r.nextInt(10);
        int randomPoisson = r.nextInt(30);

        this.width = r.nextInt(1000);
        this.height = r.nextInt(1000);

        this.tabOcean = new int[this.width][this.height];
        this.icebergs = new Iceberg2D[randomIceberg];
        this.poissons = new Poisson[randomPoisson];
        this.fishEaten = false;

        for (int i = 0; i < randomIceberg; i++)
        {
            this.icebergs[i] = new Iceberg2D(new Point(r.nextInt(this.width), r.nextInt(this.height)), new Point(r.nextInt(this.width), r.nextInt(this.height)));
        }

        this.window = new ArcticImage(this.width, this.height);

        this.pingouin = new Pingouin(this.width < this.height ? r.nextInt(this.width/10) : r.nextInt(this.height/10) , new Point(r.nextInt(this.width), r.nextInt(this.height)));

        for (int i = 0; i < randomPoisson; i++)
        {
            this.poissons[i] = new Poisson(r.nextInt(this.width/10), r.nextInt(this.height/10), new Point(r.nextInt(this.width), r.nextInt(this.height)), r.nextBoolean());
        }
    }

    /**
     * Ajoute un iceberg à l'océan. Ne l'ajoute pas si l'iceberg n'est pas compris dans l'océan
     * @param i l'iceberg en question
     */
    public void addIceberg(Iceberg2D i)
    {
        if (i.coinEnHautADroite().getAbscisse() <= this.width && i.coinEnHautADroite().getOrdonnee() <= this.height)
        {
            this.icebergs = Arrays.copyOf(this.icebergs, this.icebergs.length + 1);
            this.icebergs[this.icebergs.length - 1] = i;
        }   
    }

    /**
     * Retourne la largeur de l'océan
     * @return la largeur de l'océan
     */
    public int getWidth()
    {
        return this.width;
    }

    /**
     * Retourne la hauteur de l'océan
     * @return la hauteur de l'océan
     */
    public int getHeight()
    {
        return this.height;
    }

    /**
     * Retourne les icebergs
     * @return les icebergs
     */
    public Iceberg2D[] getIcebergs()
    {
        return this.icebergs;
    }

    public void fondre(double f)
    {
        for (Iceberg2D iceberg : icebergs)
        {
            iceberg.fondre(f);
        }
    }

    public int getCountIceberg()
    {
        return icebergs.length;
    }

    public Pingouin getPingouin()
    {
        return this.pingouin;
    }

    public Poisson[] getPoisson()
    {
        return this.poissons;
    }

    public Boolean isFishEaten()
    {
        return this.fishEaten;
    }

    public void resetFishEaten()
    {
        this.fishEaten = false;
    }

    /**
     * Affiche l'océan
     */
    public void render(int deplacement)
    {
        for (int i = 0; i < this.tabOcean.length; i++)
        {
            for (int j = 0; j < this.tabOcean[i].length; j++)
            {
                this.tabOcean[i][j] = 0;
            }
        }

        for (Poisson poisson : this.poissons)
        {
            double x = poisson.getPosition().getAbscisse();
            double y = poisson.getPosition().getOrdonnee();

            for (int i = 0; i < poisson.getWidth(); i++)
            {
                for (int j = 0; j < poisson.getHeight(); j++)
                {
                    this.tabOcean[(int)((x + j) % this.width)][(int)((y + i) % this.height)] = poisson.getMoveType() ? 4 : 5;
                }    
            }
        }

        for (Iceberg2D iceberg : this.icebergs)
        {
            double x = iceberg.coinEnBasAGauche().getAbscisse();
            double y = iceberg.coinEnBasAGauche().getOrdonnee();

            for (int i = 0; i < iceberg.hauteur(); i++)
            {
                for (int j = 0; j < iceberg.largeur(); j++)
                {
                    this.tabOcean[(int)(x + j)][(int)(y + i)] = 1;
                }
            }
        }

        for (int i = 0; i < this.pingouin.getHeight(); i++)
        {
            double x = this.pingouin.getPoint().getAbscisse() - 1;
            double y = this.pingouin.getPoint().getOrdonnee();

            for (int j = 0; j < this.pingouin.getHeight(); j++)
            {
                this.tabOcean[(int)(x - j)][(int)(y + i)] = deplacement < 30 ? 2 : 3;
            }   
        }

        this.window.setColors(this.tabOcean);
    }

    public void detectCollisions()
    {
        for (Iceberg2D iceberg : this.icebergs)
        {
            if (iceberg.coinEnHautADroite().getAbscisse() >= this.pingouin.getPoint().getAbscisse() - this.pingouin.getHeight() & 
            iceberg.coinEnBasAGauche().getAbscisse() <= this.pingouin.getPoint().getAbscisse() &&
            iceberg.coinEnHautADroite().getOrdonnee() >= this.pingouin.getPoint().getOrdonnee() &&
            iceberg.coinEnBasAGauche().getOrdonnee() <= this.pingouin.getPoint().getOrdonnee() + this.pingouin.getHeight()) {
                iceberg.fondre(0.99999999999);
            }
        }

        for (Poisson poisson : this.poissons)
        {
            if (poisson.getPosition().getAbscisse() + poisson.getWidth() >= this.pingouin.getPoint().getAbscisse() - this.pingouin.getHeight() &&
            poisson.getPosition().getAbscisse() <= this.pingouin.getPoint().getAbscisse() &&
            poisson.getPosition().getOrdonnee() + poisson.getHeight() >= this.pingouin.getPoint().getOrdonnee() &&
            poisson.getPosition().getOrdonnee() <= this.pingouin.getPoint().getOrdonnee() + this.pingouin.getHeight()) {
                poisson.setHeight(0);
                poisson.setWidth(0);
                poisson.setPosition(new Point(0, 0));
                this.pingouin.setHeight(this.pingouin.getHeight() + 5);
                this.fishEaten = true;
            }
        }
    }

    public ArcticImage getWindow()
    {
        return this.window;
    }
}
