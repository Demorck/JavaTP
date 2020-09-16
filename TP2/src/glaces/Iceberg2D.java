package glaces;
import geometrie.Point ;

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
     */
    public Iceberg2D(Point g, Point d) {
        this.enBasAGauche = g;
        this.enHautADroite = d;
    }

    /**
     * Construction par fusion de deux icebergs qui se touchent
     * @param i1 premier iceberg à fusionner
     * @param i2 deuxième iceberg à fusionner
     */
    public Iceberg2D(Iceberg2D i1, Iceberg2D i2) {
        if (!i1.collision(i2))
        {
            // TODO Exceptions à mettre
        }
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

        if (i1.coinEnHautADroite().getAbscisse() > i2.coinEnHautADroite().getAbscisse())
        {
            if (i1.coinEnHautADroite().getOrdonnee() > i2.coinEnHautADroite().getAbscisse())
            {
                p2 = new Point(i1.coinEnHautADroite().getAbscisse(), i1.coinEnHautADroite().getOrdonnee());
            }
            else
            {
                p2 = new Point(i2.coinEnHautADroite().getAbscisse(), i1.coinEnHautADroite().getOrdonnee());
            }
        }
        else
        {
            if (i1.coinEnHautADroite().getOrdonnee() > i2.coinEnHautADroite().getAbscisse())
            {
                p2 = new Point(i1.coinEnHautADroite().getAbscisse(), i2.coinEnHautADroite().getOrdonnee());
            }
            else
            {
                p2 = new Point(i2.coinEnHautADroite().getAbscisse(), i2.coinEnHautADroite().getOrdonnee());
            }
        }
        this.enBasAGauche = p1;
        this.enHautADroite = p2;
    }

    /**
     * Retourne le coin en bas à gauche
     * @return le coin en bas à gauche
     */
    public Point coinEnBasAGauche() {
        return this.enBasAGauche ;
    }

    /**
     * Retourne le coin en haut à droite
     * @return le coin en haut à droite
     */
    public Point coinEnHautADroite() {
        return this.enHautADroite ;
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
    public boolean collision(Iceberg2D i) {
        if (this.enBasAGauche.getAbscisse() < i.enBasAGauche.getAbscisse() && this.enHautADroite.getAbscisse() > i.enBasAGauche.getAbscisse())
        {
            
        }
    }

    /**
     * Retourne vrai si this est plus volumineux que i
     * @param i iceberg à comparer
     * @return vrai si this est plus volumineux que i
     */
    public boolean estPlusGrosQue(Iceberg2D i) {
        return this.surface() > i.surface() ;
    }

    public String toString() {
        return null ;
    }

    /**
     * Retourne le point au centre
     * @return le point au centre de l'iceberg
     */
    public Point centre() {
        return null ;
    }

    /**
     * Réduction dans les quatre directions ; le centre ne bouge pas
     * @param fr dans ]0..1[ facteur de réduction
     */
    public void fondre(double fr) {
        // A compléter
    }

    /**
     * Casser une partie à droite
     * @param fr dans ]0..1[ facteur de réduction
     */
    public void casserDroite(double fr) {
        // A compléter
    }

    /**
     * Casser une partie à gauche
     * @param fr dans ]0..1[ facteur de réduction
     */
    public void casserGauche(double fr) {
        // A compléter
    }

    /**
     * Casser une partie en haut
     * @param fr dans ]0..1[ facteur de réduction
     */
    public void casserHaut(double fr) {
        // A compléter
    }

    /**
     * Casser une partie en bas
     * @param fr dans ]0..1[ : définit le pourcentage supprimé
     */
    public void casserBas(double fr) {
        // A compléter
    }

}