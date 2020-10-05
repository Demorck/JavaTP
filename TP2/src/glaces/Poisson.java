package glaces;

import geometrie.*;

public class Poisson
{
    private int height;
    private int width;
    private Point position;
    private Boolean moveType; // 0 = x; 1 = y
    private int nbDeplacement;

    public Poisson(int height, int width, Point point, Boolean moveType)
    {
        this.height = height;
        this.width = width;
        this.position = point;
        this.moveType = moveType;
        this.nbDeplacement = 0;
    }

    public int getHeight()
    {
        return this.height;
    }

    public int getWidth()
    {
        return this.width;
    }

    public Point getPosition()
    {
        return this.position;
    }

    public Boolean getMoveType()
    {
        return this.moveType;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public void setWidth(int width)
    {
        this.width = width; 
    }

    public void setPosition(Point position)
    {
        this.position = position;
    }

    public void setMoveType(Boolean moveType)
    {
        this.moveType = moveType;
    }

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
