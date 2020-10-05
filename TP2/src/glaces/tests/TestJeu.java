package glaces.tests;
import glaces.Jeu;

public class TestJeu
{
    public static void main(String[] args)
    {
        Jeu jeu = new Jeu();
        while(!jeu.wantToQuit())
        {
            jeu.play();
            jeu.addNbDeplacement();
        }
        System.out.println("bite");
    }
}
