package glaces;
import geometrie.*;


public class Pingouin
{
    private int height;
    private Point bottomRight;

    /**
     * Construit un pingouin
     * @param height taille du pingouin (j'aurai dû l'appeler size)
     * @param position position du pingouin
     */
    public Pingouin(int height, Point position)
    {
        this.height = height;
        this.bottomRight = position;
    }

    /**
     * Retourne la taille du pinguin
     * @return la taille du pinguin
     */
    public int getHeight()
    {
        return this.height;
    }

    /**
     * Retourne la position du pingouin
     * @return la position du pingouin
     */
    public Point getPoint()
    {
        return this.bottomRight;
    }

    /**
     * Change la taille du pingouin 
     * @param height taille
     */
    public void setHeight(int height)
    {
        this.height = height;
    }

    /**
     * Change la position du pingouin
     * @param point position
     */
    public void setPoint(Point point)
    {
        this.bottomRight = point;
    }

    /**
     * Déplace le pingouin en haut par rapport à sa taille
     */
    public void moveUp()
    {
        this.bottomRight = new Point(this.bottomRight.getAbscisse(), this.bottomRight.getOrdonnee() + this.getHeight());
    }

    /**
     * Déplace le pingouin en bas par rapport à sa taille
     */
    public void moveDown()
    {
        this.bottomRight = new Point(this.bottomRight.getAbscisse(), this.bottomRight.getOrdonnee() - this.getHeight());
    }

    /**
     * Déplace le pingouin à gauche par rapport à sa taille
     */
    public void moveLeft()
    {
        this.bottomRight = new Point(this.bottomRight.getAbscisse() - this.getHeight(), this.bottomRight.getOrdonnee());
    }

    /**
     * Déplace le pingouin à droite par rapport à sa taille
     */
    public void moveRight()
    {
        this.bottomRight = new Point(this.bottomRight.getAbscisse() + this.getHeight(), this.bottomRight.getOrdonnee());
    }
}
