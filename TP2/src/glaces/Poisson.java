package glaces;

import geometrie.*;

public class Poisson
{
    private int height;
    private int width;
    private Point position;
    private Boolean moveType; // 0 = x; 1 = y
    private int nbDeplacement;

    /**
     * Construit un poisson avec une hauteur, largeur, une position et son sens de mouvement
     * @param height hauteur
     * @param width largeur
     * @param point Position (x, y)
     * @param moveType Sens de mouvement (0 = x, 1 = y)
     */
    public Poisson(int height, int width, Point point, Boolean moveType)
    {
        this.height = height;
        this.width = width;
        this.position = point;
        this.moveType = moveType;
        this.nbDeplacement = 0;
    }

    /**
     * Retourne la hauteur
     * @return la hauteur
     */
    public int getHeight()
    {
        return this.height;
    }

    /**
     * Retourne la largeur
     * @return la largeur
     */
    public int getWidth()
    {
        return this.width;
    }

    /**
     * Retourne la position
     * @return la position
     */
    public Point getPosition()
    {
        return this.position;
    }

    /**
     * Retourne le type de mouvement
     * @return le type de mouvement
     */
    public Boolean getMoveType()
    {
        return this.moveType;
    }

    /**
     * Change la hauteur
     * @param height hauteur
     */
    public void setHeight(int height)
    {
        this.height = height;
    }

    /**
     * Change la largeur
     * @param width largeur
     */
    public void setWidth(int width)
    {
        this.width = width; 
    }

    /**
     * Change la position
     * @param position position
     */
    public void setPosition(Point position)
    {
        this.position = position;
    }

    /**
     * Change la type de mouvement
     * @param moveType type de mouvement
     */
    public void setMoveType(Boolean moveType)
    {
        this.moveType = moveType;
    }

    /**
     * Fait bouger le poisson et le fait disparaître au bout de 40 déplacements. 
     * @param max width/height de l'océan pour qu'il repasse de l'autre côté de l'écran
     */
    public void move(int max)
    {
        if (!this.moveType)
            this.position = new Point((this.position.getAbscisse() + this.width) % max, this.position.getOrdonnee());
        else
            this.position = new Point(this.position.getAbscisse(), (this.position.getOrdonnee() + this.height) % max);
        
        if (this.nbDeplacement > 40)
        {
            this.height = 0;
            this.width = 0;
            this.position = new Point(0, 0);
        }
        else
        {
            this.nbDeplacement++;
        }
    }
}
