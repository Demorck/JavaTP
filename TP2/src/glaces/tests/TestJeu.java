package glaces.tests;
import glaces.Jeu;
import java.util.Scanner;

public class TestJeu
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in); // Jamais close un Scanner(System.in) 
        int userInput = 0;

        boolean wantToCatch = false;
        do
        {
            System.out.println("Entrez un nombre compris entre 1 et 3 : ");
            System.out.println("1 - Jeu avec paramètres prédéfinis (2 icebergs)");
            System.out.println("2 - Jeu avec taille prédéfinis et nombre d'icebergs aléatoires");
            System.out.println("3 - Totalement aléatoire");
            if(scan.hasNextLine())
            {
                userInput = scan.nextInt();
                wantToCatch = true;
            }
            else 
            {
                scan.nextLine();
                System.out.println("Erreur. Veuillez rentrer un nombre entier entre 1 et 3.");
            }
        } while (!wantToCatch || userInput < 1 || userInput > 11 );

        Jeu jeu = new Jeu(userInput);
        while(!jeu.wantToQuit())
        {
            jeu.play();
            jeu.addNbDeplacement();
        }
    }
    
}
