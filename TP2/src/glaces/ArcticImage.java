package glaces;

import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JFrame;

public class ArcticImage extends JFrame
{
    protected static int OCEAN;
    protected static int GLACE;
    protected static int PINGU2;
    protected static int PINGU3;
    protected static int POISS1;
    protected static int POISS2;
    protected static int POISS3;
    protected static int POISS4;
    protected static int NEANT;
    private JLabel jlabel;
    private int[] tabCouleurs;
    
    public ArcticImage(final int largeur, final int hauteur) {
        super("ArcticGame");
        this.tabCouleurs = new int[] { ArcticImage.OCEAN, ArcticImage.GLACE, ArcticImage.PINGU2, ArcticImage.PINGU3, ArcticImage.POISS1, ArcticImage.POISS2, ArcticImage.POISS3, ArcticImage.POISS4 };
        (this.jlabel = new JLabel()).setPreferredSize(new Dimension(largeur, hauteur));
        this.add(this.jlabel, "Center");
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
    }
    
    public void setColors(final int[][] tab) {
        final int largeur = tab.length;
        final int hauteur = tab[0].length;
        final BufferedImage image = new BufferedImage(largeur, hauteur, 1);
        for (int x = 0; x < largeur; ++x) {
            for (int y = 0; y < hauteur; ++y) {
                final int valeur = tab[x][hauteur - 1 - y];
                int couleur;
                if (valeur < 0 || valeur > this.tabCouleurs.length) {
                    couleur = ArcticImage.NEANT;
                }
                else {
                    couleur = this.tabCouleurs[valeur];
                }
                image.setRGB(x, y, couleur);
            }
        }
        this.jlabel.setIcon(new ImageIcon(image));
    }
    
    public void fermer() {
        this.dispose();
    }
    
    static {
        ArcticImage.OCEAN = 1007296;
        ArcticImage.GLACE = 16777215;
        ArcticImage.PINGU2 = 13731860;
        ArcticImage.PINGU3 = 13720084;
        ArcticImage.POISS1 = 8638980;
        ArcticImage.POISS2 = 11067215;
        ArcticImage.POISS3 = 6858755;
        ArcticImage.POISS4 = 14100210;
        ArcticImage.NEANT = 0;
    }
}