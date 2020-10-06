package glaces;
import geometrie.*;
import java.util.Scanner;
import java.util.Random;

public class Jeu
{
    private Ocean ocean;
    private String userInput;
    private Scanner userScan;
    private int nbDeplacement;
    private Boolean quit;

    /**
     * Construit le jeu avec le type de jeu qu'on veut faire
     * @param userInput type de jeu
     */
    public Jeu(int userInput)
    {
        Iceberg2D i1 = new Iceberg2D(new Point(new Random().nextInt(300),new Random().nextInt(300)), new Point(new Random().nextInt(300),new Random().nextInt(300)));
        Iceberg2D i2 = new Iceberg2D(new Point(new Random().nextInt(300),new Random().nextInt(300)), new Point(new Random().nextInt(300),new Random().nextInt(300)));

        
        switch(userInput)
        {
            case 1:
                this.ocean = new Ocean(300, 300, i1, i2, 10);
                break;
            case 2:
                this.ocean = new Ocean(300, 300, 5);
                break;
            default:
                this.ocean = new Ocean();
                break;
        }
        
        this.userScan = new Scanner(System.in);
        this.nbDeplacement = 0;
        this.ocean.render(this.nbDeplacement);
        this.quit = false;
    }
    
    /**
     * "Boucle" principal du jeu
     */
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
        // Ajoute 5 poissons tous les 10 déplacements
        if (this.nbDeplacement % 10 == 0)
        {
            for (int i = 0; i < 5; i++)
            {
                this.ocean.addRandomFish();
            }
        }
        // Ajoute 2 icebergs tous les 20 déplacements
        if (this.nbDeplacement % 20 == 0)
        {
            this.ocean.addRandomIceberg();
            this.ocean.addRandomIceberg();
        }
        this.ocean.detectCollisions();
        if (this.ocean.isFishEaten())
            this.resetNbDeplacement();
        if (this.nbDeplacement > 30)
            this.ocean.getPingouin().setHeight(this.ocean.getPingouin().getHeight() - 5);
        this.ocean.resetFishEaten();
        this.isLose();
        this.ocean.fondre(0.05);
        this.ocean.render(this.nbDeplacement);
        this.printThings("nbFishEaten");
    }

    /**
     * Déplace le pingouin en fonction de zqsd
     * @param userInput entrée utilisateur
     */
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

    /**
     * Déplace les poissons
     */
    public void movePoisson()
    {
        for (Poisson poisson : this.ocean.getPoisson())
        {
            poisson.move(poisson.getMoveType() ? this.ocean.getHeight() : this.ocean.getWidth());
        }
    }

    /**
     * Désolé pour le nom de la fonction mais c'est le fonction qui permet d'afficher les trucs
     * @param string En fonction de ce que je veux, ça print quelque chose
     */
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
            case "nbFishEaten":
                System.out.println("Vous avez mangé " + this.ocean.getNbFishEaten() + (this.ocean.getNbFishEaten() > 1 ? " poissons" : " poisson"));
            default:
                break;
        }
    }

    /**
     * Demande à l'utilisateur d'entrer quelque chose
     * @return ce que tape l'utlisateur
     */
    private String askUserInput()
    {
        return this.userScan.nextLine();
    }

    /**
     * Ajoute 1 au nombre de déplacement
     */
    public void addNbDeplacement()
    {
        ++this.nbDeplacement;
    }

    /**
     * Reset le nombre de déplacement
     */
    public void resetNbDeplacement()
    {
        this.nbDeplacement = 0;
    }

    /**
     * Test si le pingouin meurt
     */
    public void isLose()
    {
        if (this.ocean.getPingouin().getHeight() < 5)
        {
            this.quit = true;
            System.out.println("Le pingouin n'existe plus :(");
        }
    }

    /**
     * Si la personne veut quitter, ferme la fenêtre. Dans les deux cas, retourne si l'utilisateur veut quitter
     * @return boolean s'il veut quitter
     */
    public Boolean wantToQuit()
    {
        if (this.quit)
            this.ocean.getWindow().fermer();
        return this.quit;
    }
}
