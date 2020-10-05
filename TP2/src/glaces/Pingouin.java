package glaces;
import geometrie.*;


public class Pingouin
{
    private int height;
    private Point bottomRight;

    public Pingouin(int height, Point position)
    {
        this.height = height;
        this.bottomRight = position;
    }

    public Pingouin(int height, int x, int y)
    {
        this.height = height;
        this.bottomRight = new Point(x, y);
    }

    public int getHeight()
    {
        return this.height;
    }

    public Point getPoint()
    {
        return this.bottomRight;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public void setPoint(Point point)
    {
        this.bottomRight = point;
    }

    public void moveUp()
    {
        this.bottomRight = new Point(this.bottomRight.getAbscisse(), this.bottomRight.getOrdonnee() + this.getHeight());
    }

    public void moveDown()
    {
        this.bottomRight = new Point(this.bottomRight.getAbscisse(), this.bottomRight.getOrdonnee() - this.getHeight());
    }

    public void moveLeft()
    {
        this.bottomRight = new Point(this.bottomRight.getAbscisse() - this.getHeight(), this.bottomRight.getOrdonnee());
    }

    public void moveRight()
    {
        this.bottomRight = new Point(this.bottomRight.getAbscisse() + this.getHeight(), this.bottomRight.getOrdonnee());
    }
}
