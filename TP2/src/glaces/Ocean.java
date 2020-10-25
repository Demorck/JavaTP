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
    private ArcticImage window;

    private int[][] tabOcean;
    private Iceberg2D[] icebergs;
    private Poisson[] poissons;
    private Pingouin pingouin;

    private Boolean fishEaten;
    private int nbFishEaten; // Je pourrais faire une fonction qui calcul par rapport aux tableau poissons

    /**
     * Constructor avec une largeur, hauteur et deux icebergs et hauteur du pingouin
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
        this.nbFishEaten = 0;

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
        this.nbFishEaten = 0;

        for (int i = 0; i < randomIceberg; i++)
        {
            this.icebergs[i] = new Iceberg2D(new Point(r.nextInt(this.width), r.nextInt(this.height)), new Point(r.nextInt(this.width), r.nextInt(this.height)));
        }

        this.window = new ArcticImage(this.width, this.height);

        this.pingouin = new Pingouin(r.nextInt(this.width/10) + 5, new Point(this.width, 0));

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
        this.nbFishEaten = 0;

        for (int i = 0; i < randomIceberg; i++)
        {
            this.icebergs[i] = new Iceberg2D(new Point(r.nextInt(this.width), r.nextInt(this.height)), new Point(r.nextInt(this.width), r.nextInt(this.height)));
        }

        this.window = new ArcticImage(this.width, this.height);

        this.pingouin = new Pingouin(this.width < this.height ? r.nextInt(this.width/10) + 5 : r.nextInt(this.height/10) + 5 , new Point(r.nextInt(this.width), r.nextInt(this.height))); // Opérateur ternaire permettant de prendre 1/10 au max par rapport au min(width, height). Les conditions dans les constructeurs ne sont pas ouf mais bon

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
     * Ajoute un iceberg aléatoire à une position aléatoire de taille aléatoire dans l'océan
     */
    public void addRandomIceberg()
    {
        this.icebergs = Arrays.copyOf(this.icebergs, this.icebergs.length + 1);
        this.icebergs[this.icebergs.length - 1] = new Iceberg2D(new Point(new Random().nextInt(this.width), new Random().nextInt(this.height)), new Point(new Random().nextInt(this.width), new Random().nextInt(this.height)));
    }

    /**
     * Ajoute un poisson aléatoire
     */
    public void addRandomFish()
    {
        this.poissons = Arrays.copyOf(this.poissons, this.poissons.length + 1);
        this.poissons[this.poissons.length - 1] = new Poisson(new Random().nextInt(this.width/10), new Random().nextInt(this.height/10), new Point(new Random().nextInt(this.width), new Random().nextInt(this.height)), new Random().nextBoolean());
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

    /**
     * Fond tous les icebergs
     * @param f facteur de réduction
     */
    public void fondre(double f)
    {
        for (Iceberg2D iceberg : icebergs)
        {
            iceberg.fondre(f);
        }
    }

    /**
     * Retourne le nombre d'icebergs dans l'océan
     * @return le nombre d'icebergs
     */
    public int getCountIceberg()
    {
        return icebergs.length;
    }

    /**
     * Retourne le pingouin 
     * @return le pingouin
     */
    public Pingouin getPingouin()
    {
        return this.pingouin;
    }

    /**
     * Retourne les poissons
     * @return les poissons
     */
    public Poisson[] getPoisson()
    {
        return this.poissons;
    }

    /**
     * Retourne si un poisson a été mangé
     * @return si un poisson a été mangé
     */
    public Boolean isFishEaten()
    {
        return this.fishEaten;
    }

    /**
     * Reset le boolean de si un poisson a été mangé
     */
    public void resetFishEaten()
    {
        this.fishEaten = false;
    }

    /**
     * Retourne le nombre de poissons mangés
     * @return le nombre de poissons mangés
     */
    public int getNbFishEaten()
    {
        return this.nbFishEaten;
    }

    /**
     * Affiche l'océan
     */
    public void render(int deplacement)
    {
        /**
         * Affiche tout l'océan (en tout bleu)
         */
        for (int i = 0; i < this.tabOcean.length; i++)
        {
            for (int j = 0; j < this.tabOcean[i].length; j++)
            {
                this.tabOcean[i][j] = 0;
            }
        }
        
        /**
         * Affiche les poissons
         */
        for (Poisson poisson : this.poissons)
        {
            double x = poisson.getPosition().getAbscisse();
            double y = poisson.getPosition().getOrdonnee();

            for (int i = 0; i < poisson.getWidth(); i++)
            {
                for (int j = 0; j < poisson.getHeight(); j++)
                {
                    this.tabOcean[(int)((x + j) % this.width)][(int)((y + i) % this.height)] = poisson.getMoveType() ? 4 : 5; // Le modulo permet qu'ils puissent revenir sur l'autre bord de l'écran. L'opérateur ternaire permet de mettre une couleur en fonction du type de déplacement.
                }    
            }
        }

        /**
         * Affiche les icebergs (après les poissons pour qu'ils soient au dessus)
         */
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

        /**
         * Affiche le pingouin
         */
        for (int i = 0; i < this.pingouin.getHeight(); i++)
        {
            double x = this.pingouin.getPoint().getAbscisse() - 1;
            double y = this.pingouin.getPoint().getOrdonnee();

            for (int j = 0; j < this.pingouin.getHeight(); j++)
            {
                this.tabOcean[(int)(x - j < 0 ? j : x - j)][(int)(y + i >= this.height ? this.height-i : y + i)] = deplacement < 30 ? 2 : 3; //Les deux premiers opérateurs ternaires permettent que le pingouin ne sort pas de l'océan et le dernier permet de changer la couleur
            }   
        }

        this.window.setColors(this.tabOcean);
    }

    /**
     * Détecte les collisions avec le pingouin avec les icebergs et les poissons.
     * Les icebergs sont beaucoup fondus et les poissons sont dépop mais toujours dans le tableau (si on a besoin d'avoir un counter pour les poissons, y aura juste à appeler getPoisson().length)
     */
    public void detectCollisions()
    {
        int pingouinHeight = this.pingouin.getHeight();
        Point pingouinPosition = this.pingouin.getPoint();

        for (Iceberg2D iceberg : this.icebergs)
        {
            if (iceberg.coinEnHautADroite().getAbscisse() >= pingouinPosition.getAbscisse() - pingouinHeight & 
            iceberg.coinEnBasAGauche().getAbscisse() <= pingouinPosition.getAbscisse() &&
            iceberg.coinEnHautADroite().getOrdonnee() >= pingouinPosition.getOrdonnee() &&
            iceberg.coinEnBasAGauche().getOrdonnee() <= pingouinPosition.getOrdonnee() + pingouinHeight) {
                iceberg.fondre(0.9999);
                iceberg.fondre(0.9999);
            }
        }

        for (Poisson poisson : this.poissons)
        {
            if (poisson.getPosition().getAbscisse() + poisson.getWidth() >= pingouinPosition.getAbscisse() - pingouinHeight &&
            poisson.getPosition().getAbscisse() <= pingouinPosition.getAbscisse() &&
            poisson.getPosition().getOrdonnee() + poisson.getHeight() >= pingouinPosition.getOrdonnee() &&
            poisson.getPosition().getOrdonnee() <= pingouinPosition.getOrdonnee() + pingouinHeight) {
                poisson.setHeight(0);
                poisson.setWidth(0);
                poisson.setPosition(new Point(0, 0));
                this.pingouin.setHeight(pingouinHeight + 5);
                this.fishEaten = true;
                ++this.nbFishEaten;
            }
        }
    }

    /**
     * Retourne le tableau à deux dimensions de l'océan
     * @return le tableau à deux dimensions de l'océan
     */
    public ArcticImage getWindow()
    {
        return this.window;
    }
}
