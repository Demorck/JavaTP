package glaces;
import geometrie.*;
import java.util.Scanner;

public class Jeu
{
    private Ocean ocean;
    private String userInput;
    private Scanner userScan;
    private int nbDeplacement;
    private Boolean quit;

    public Jeu()
    {
        Iceberg2D i1 = new Iceberg2D(new Point(0.,0.), new Point(10., 20.));
        Iceberg2D i2 = new Iceberg2D(new Point(20.,90.), new Point(25., 99.));

        this.ocean = new Ocean(300, 300, 5);
        this.userScan = new Scanner(System.in);
        this.nbDeplacement = 0;
        this.ocean.render(this.nbDeplacement);
        this.quit = false;
        
    }
    
    public void play()
    {
        printThings("menu");
        this.userInput = askUserInput();
        switch(userInput)
        {
            case "z":
            case "Z":
                if (this.ocean.getPingouin().getPoint().getOrdonnee() + this.ocean.getPingouin().getHeight() < this.ocean.getHeight())
                    movePingouin("z");
                else
                    printThings("pingouinLimite");
                break;
            case "q":
            case "Q":
                if (this.ocean.getPingouin().getPoint().getAbscisse() - this.ocean.getPingouin().getHeight() > 0)
                    movePingouin("q");
                else
                    printThings("pingouinLimite");
                break;
            case "s":
            case "S":
                if (this.ocean.getPingouin().getPoint().getOrdonnee() - this.ocean.getPingouin().getHeight() > 0)
                    movePingouin("s");
                else
                    printThings("pingouinLimite");
                break;
            case "d":
            case "D":
                if (this.ocean.getPingouin().getPoint().getAbscisse() + this.ocean.getPingouin().getHeight() < this.ocean.getWidth())
                    movePingouin("d");
                else
                    printThings("pingouinLimite");
                break;
            default:
                this.quit = true;
                break;
        }
        
        this.movePoisson();
        this.ocean.detectCollisions();
        if (this.ocean.isFishEaten())
            this.resetNbDeplacement();
        this.ocean.resetFishEaten();
        this.ocean.fondre(0.05);
        this.ocean.render(this.nbDeplacement);
    }

    public void movePingouin(String userInput)
    {
        switch(userInput)
        {
            case "z":
            case "Z":
                this.ocean.getPingouin().moveUp();
                break;
            case "q":
            case "Q":
                this.ocean.getPingouin().moveLeft();
                break;
            case "s":
            case "S":
                this.ocean.getPingouin().moveDown();
                break;
            case "d":
            case "D":
                this.ocean.getPingouin().moveRight();
                break;
        }
    }

    public void movePoisson()
    {
        for (Poisson poisson : this.ocean.getPoisson())
        {
            poisson.move(poisson.getMoveType() ? this.ocean.getHeight() : this.ocean.getWidth());
        }
    }

    private void printThings(String string)
    {
        switch(string)
        {
            case "menu": 
                System.out.println("Veuillez choisir un des choix suivants: ");
                System.out.println("z/Z - Aller en haut");
                System.out.println("q/Q - Aller à gauche");
                System.out.println("s/S - Aller en bas");
                System.out.println("d/D - Aller à droite");
                System.out.println("Tout autre choix ferme le jeu");
                break;
            case "pingouinLimite":
                System.out.println("Le pingouin ne peut pas sortir de l'océan");
                break;
            default:
                break;
        }
    }

    private String askUserInput()
    {
        return this.userScan.nextLine();
    }

    public void addNbDeplacement()
    {
        ++this.nbDeplacement;
    }

    public void resetNbDeplacement()
    {
        this.nbDeplacement = 0;
    }

    public Boolean wantToQuit()
    {
        if (this.quit)
            this.ocean.getWindow().fermer();
        return this.quit;
    }
}
