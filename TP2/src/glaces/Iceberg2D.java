package glaces;
import geometrie.Point ;
import geometrie.Segment;

/**
 * Un iceberg rectangulaire
 * @author Martine Gautier, Université de Lorraine
 */
public class Iceberg2D {

    private Point enBasAGauche ;
    private Point enHautADroite ;

    /**
     * Construction
     * @param g le coin en bas à gauche
     * @param d le coin en haut à droite
     * uniquement en coordonnées positives
     * 
     * Si les points sont confondues, ont la même ordonnée ou abscisse, alors le point en haut à droite est déplacé de (1; 1).
     */
    public Iceberg2D(final Point g, final Point d) {
        if(g.distance(d) == 0 || g.getOrdonnee() == d.getOrdonnee() || g.getAbscisse() == d.getAbscisse())
        {
            d.deplacer(1, 1);
        }

        if (d.getAbscisse() > g.getAbscisse() && d.getOrdonnee() > g.getOrdonnee())
        {
            this.enBasAGauche = g;
            this.enHautADroite = d;
        }
        else if (d.getAbscisse() < g.getAbscisse() && d.getOrdonnee() < g.getOrdonnee())
        {
            this.enBasAGauche = d;
            this.enHautADroite = g;
        }
        else if (d.getAbscisse() < g.getAbscisse() && d.getOrdonnee() > g.getOrdonnee())
        {
            this.enBasAGauche = new Point(d.getAbscisse(), g.getOrdonnee());
            this.enHautADroite = new Point(g.getAbscisse(), d.getOrdonnee());
        }
        else
        {
            this.enBasAGauche = new Point(g.getAbscisse(), d.getOrdonnee());
            this.enHautADroite = new Point(d.getAbscisse(), g.getOrdonnee());
        }
    }

    /**
     * Construction par fusion de deux icebergs qui se touchent
     * @param i1 premier iceberg à fusionner
     * @param i2 deuxième iceberg à fusionner
     */
    public Iceberg2D(final Iceberg2D i1, final Iceberg2D i2) {
        if (!i1.collision(i2))
        {
            Point p1, p2;
            if (i1.coinEnBasAGauche().getOrdonnee() < i2.coinEnBasAGauche().getOrdonnee())
            {
                if (i1.coinEnBasAGauche().getAbscisse() < i2.coinEnBasAGauche().getAbscisse())
                {
                    p1 = new Point(i1.coinEnBasAGauche().getAbscisse(), i1.coinEnBasAGauche().getOrdonnee());
                }
                else
                {
                    p1 = new Point(i2.coinEnBasAGauche().getAbscisse(), i1.coinEnBasAGauche().getOrdonnee());
                }
            }
            else
            {
                if (i1.coinEnBasAGauche().getAbscisse() < i2.coinEnBasAGauche().getAbscisse())
                {
                    p1 = new Point(i1.coinEnBasAGauche().getAbscisse(), i2.coinEnBasAGauche().getOrdonnee());
                }
                else
                {
                    p1 = new Point(i2.coinEnBasAGauche().getAbscisse(), i2.coinEnBasAGauche().getOrdonnee());
                }
            }


            /**
             * Le cas là est obligatoire pour ce type de configuration:
             *      
             *      ---------
             *      |       |
             *      |       |
             *      ---------
             * ----------------------
             * |                    |
             * |                    |
             * |                    |
             * ----------------------
             */
            if (i1.coinEnHautADroite().getAbscisse() > i2.coinEnHautADroite().getAbscisse())
            {
                if (i1.coinEnHautADroite().getOrdonnee() > i2.coinEnHautADroite().getOrdonnee())
                {
                    p2 = new Point(i1.coinEnHautADroite().getAbscisse(), i1.coinEnHautADroite().getOrdonnee());
                }
                else
                {
                    p2 = new Point(i1.coinEnHautADroite().getAbscisse(), i2.coinEnHautADroite().getOrdonnee());
                }
            }
            else
            {
                if (i1.coinEnHautADroite().getOrdonnee() > i2.coinEnHautADroite().getOrdonnee())
                {
                    p2 = new Point(i2.coinEnHautADroite().getAbscisse(), i1.coinEnHautADroite().getOrdonnee());
                }
                else
                {
                    p2 = new Point(i2.coinEnHautADroite().getAbscisse(), i2.coinEnHautADroite().getOrdonnee());
                }
            }
            this.enBasAGauche = p1;
            this.enHautADroite = p2;
        }
        else
        {
            this.enBasAGauche = i1.enBasAGauche;
            this.enHautADroite = i1.enHautADroite;
        }
    }

    /**
     * Retourne le coin en bas à gauche
     * @return le coin en bas à gauche
     */
    public Point coinEnBasAGauche() {
        return this.enBasAGauche;
    }

    /**
     * Retourne le coin en haut à droite
     * @return le coin en haut à droite
     */
    public Point coinEnHautADroite() {
        return this.enHautADroite;
    }


    /**
     * Retourne la hauteur
     * @return hauteur
     */
    public double hauteur() {
        return this.enHautADroite.getOrdonnee() - this.enBasAGauche.getOrdonnee();
    }

    /**
     * Retourne la largeur
     * @return largeur
     */
    public double largeur() {
        return this.enHautADroite.getAbscisse() - this.enBasAGauche.getAbscisse();
    }

    /**
     * Retourne la surface totale
     * @return surface totale
     */
    public double surface() {
        return this.hauteur() * this.largeur();
    }

    /**
     * Retourne vrai si il y a une collision entre les deux icebergs
     * @param i iceberg potentiellement en collision
     * @return vrai si collision entre les deux icebergs
     */
    public boolean collision(final Iceberg2D i) {
        if (this.enHautADroite.getAbscisse() >= i.enBasAGauche.getAbscisse() && 
            this.enBasAGauche.getAbscisse() <= i.enHautADroite.getAbscisse() &&
            this.enHautADroite.getOrdonnee() >= i.enBasAGauche.getOrdonnee() &&
            this.enBasAGauche.getOrdonnee() <= i.enHautADroite.getOrdonnee())
        {
            return true;
        }
        return false;
    }

    /**
     * Retourne vrai si this est plus volumineux que i
     * @param i iceberg à comparer
     * @return vrai si this est plus volumineux que i
     */
    public boolean estPlusGrosQue(final Iceberg2D i) {
        return this.surface() > i.surface() ;
    }

    public String toString() {
        return "(" + this.enBasAGauche + ";" + this.enHautADroite + ")";
    }

    /**
     * Retourne le point au centre
     * @return le point au centre de l'iceberg
     */
    public Point centre() {
        return new Segment(this.enBasAGauche, this.enHautADroite).milieu();
    }

    /**
     * Réduction dans les quatre directions ; le centre ne bouge pas
     * @param fr dans ]0..1[ facteur de réduction
     */
    public void fondre(final double fr) {
        final double tmpLargeur  = this.largeur();
        final double tmpHauteur = this.hauteur();
        this.enHautADroite.deplacer(- fr * (tmpLargeur / 2), 0);
        this.enBasAGauche.deplacer(fr * (tmpLargeur / 2), 0);
        this.enHautADroite.deplacer(0, - fr * (tmpHauteur / 2));
        this.enBasAGauche.deplacer(0, fr * (tmpHauteur / 2));
    }

    /**
     * Casser une partie à droite
     * @param fr dans ]0..1[ facteur de réduction
     */
    public void casserDroite(final double fr) {
        this.enHautADroite.deplacer(- fr * (this.largeur() / 2), 0);
    }

    /**
     * Casser une partie à gauche
     * @param fr dans ]0..1[ facteur de réduction
     */
    public void casserGauche(final double fr) {
        this.enBasAGauche.deplacer(fr * (this.largeur() / 2), 0);
    }

    /**
     * Casser une partie en haut
     * @param fr dans ]0..1[ facteur de réduction
     */
    public void casserHaut(final double fr) {
        this.enHautADroite.deplacer(0, - fr * (this.hauteur() / 2));
    }

    /**
     * Casser une partie en bas
     * @param fr dans ]0..1[ : définit le pourcentage supprimé
     */
    public void casserBas(final double fr) {
        this.enBasAGauche.deplacer(0, fr * (this.hauteur() / 2));
    }

}