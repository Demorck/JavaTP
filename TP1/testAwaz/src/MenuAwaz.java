import java.util.Scanner;
import java.util.regex.*;

import awaz.Awaz;
import awaz.AwazImage;

/**
 * Je pourrais étoffer un peu plus le programme comme rajouter des try & catch, des messages de succès, etc.
 * Le seul problème est sur certains print à cause du Scanner avec les nextLine(). C'est assez bizarre comme truc.
 * 
 * @author Maximilien Antoine
 * @version 15/09/2020 
 */
public class MenuAwaz
{

    private static Awaz melodie;
    private static AwazImage partition;
    static Scanner userInput;
    public static void main(String[] args)
    {
        userInput = new Scanner(System.in);
        int userChoice = 0;
        String melodieABC = "";
        boolean wantToQuit = false;

        melodie = new Awaz();

        displayMenu();
        while (!wantToQuit)
        {   
            System.out.println("\nSi vous voulez ré-afficher le menu: 11");
            userChoice = menuChoice();
            switch (userChoice) 
            {
                case 1:
                    addNote();
                    break;
                case 2:
                    melodie.nouveau();
                    break;
                case 3:
                    addTitre();
                    break;
                case 4:
                    System.out.println("Le titre de la mélodie est: " + melodie.getTitre());
                    break;
                case 5:
                    transposerMelodie();
                    break;
                case 6:
                    System.out.println(melodie.toString());
                    break;
                case 7:
                    saveMelodie();
                    break;
                case 8:
                    melodieABC = melodie.toABC();
                    System.out.println("Mélodie convertie avec succès"); // Je pourrais faire un try & catch.
                    break;
                case 9:
                    if (melodieABC == "")
                    {
                        System.out.println("Erreur. Aucune mélodie enregistrée en ABC.");
                    }
                    else
                    {
                        partition = new AwazImage();
                        partition.setMelodie(melodieABC);
                    }
                    break;
                case 10:
                    wantToQuit = true;
                    break;
                case 11:
                    displayMenu();
                    break;
                default:
                    break;
            }
            
        }
        
    }


    private static int menuChoice()
    {
        // Scanner userInput = new Scanner(System.in);
        boolean wantToCatch = false;
        int userChoice = 0;
        do
        {
            System.out.println("Entrez un nombre compris entre 1 et 11 : ");
            if(userInput.hasNextLine())
            {
                userChoice = userInput.nextInt();
                wantToCatch = true;
            }
            else 
            {
                userInput.nextLine();
                System.out.println("Erreur. Veuillez rentrer un nombre entier.");
            }
        } while (!wantToCatch || userChoice < 1 || userChoice > 11 );
        return userChoice;
    }

    private static void displayMenu()
    {
        System.out.println("Veuillez choisir un des choix suivants: ");
        System.out.println("1 - Ajouter une note");
        System.out.println("2 - Supprimer la mélodie");
        System.out.println("3 - Ajouter un titre");
        System.out.println("4 - Afficher le titre de la chanson");
        System.out.println("5 - Transposer la mélodie d'un certain nombre de ton");
        System.out.println("6 - Afficher la mélodie");
        System.out.println("7 - Sauvegarder la mélodie");
        System.out.println("8 - Mettre la mélodie en format ABC");
        System.out.println("9 - Jouer la mélodie");
        System.out.println("10 - Quitter (toute modification non sauvegardée sera supprimée)");
    }

    private static void addNote()
    {
        String userChoice = "";
        boolean wantToCatch = false;

        Pattern pattern;
        Matcher matcher;
        String[] arrayMatcher;
        pattern = Pattern.compile("[Do,Do#,Ré,Ré#,Mi,Fa,Fa#,Sol,Sol#,La,La#,Si]");

        do
        {
            if(userInput.hasNextLine())
            {
                System.out.println("Entrez une note de musique (si vous voulez en mettre plusieurs, séparez les par une virgule) Toute note incorrecte sera remplacée par un Do. : ");
                userChoice = userInput.nextLine();
                wantToCatch = true;
            }
            else 
            {
                userInput.nextLine();    
                System.out.println("Erreur. Veuillez rentrer une note.");
            }
            matcher = pattern.matcher(userChoice);
            arrayMatcher = userChoice.split(",", -1);

        } while (!wantToCatch || !matcher.find());

        if (arrayMatcher.length > 1) 
        {
            for (String eachNote : arrayMatcher)
            {
                melodie.add(eachNote);
            }
        }
        else
        {
            melodie.add(userChoice);
        }
    }

    private static void addTitre()
    {
        System.out.print("Rentrez un titre pour votre mélodie: ");
        String userTitre;
        userInput.nextLine();
        userTitre  = userInput.nextLine();
        melodie.setTitre(userTitre);
        System.out.println(melodie.getTitre());
    }

    private static void transposerMelodie()
    {
        int nbTons = 0;
        boolean wantToCatch = false;
        do
        {     
            if(userInput.hasNextInt())
            {
                System.out.print("Entrez un nombre entier : ");
                nbTons = userInput.nextInt();
                wantToCatch = true;
            }
            else 
            {
                userInput.nextLine();
                System.out.println("Erreur. Veuillez rentrer un nombre entier.");
            }
        } while (!wantToCatch || nbTons < 0 );
        melodie.transposer(nbTons);
    }

    private static void saveMelodie()
    {
        String fileName = "melodie";
        System.out.print("Rentrez un nom de fichier valide: ");
        userInput.nextLine();
        fileName = userInput.nextLine();
        melodie.enregistrer(fileName);
    }

}