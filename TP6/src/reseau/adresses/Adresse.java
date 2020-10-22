package reseau.adresses;

/**
 * @author martine
 * @version 20 nov. 2014
 */

public class Adresse
{
    private Octet[] adresse;

    /**
     * Constructeur de copie (copie profonde)
     * @param a adresse à copier
     * @exception AssertionError si a est null
     */
    public Adresse(Adresse a)
    {
        if (a != null)
        {
            this.adresse = new Octet[a.getNbreOctets()];
            for(int i = 0; i < a.getNbreOctets(); i++)
                this.adresse[i] = a.getOctet(i);
        }
        else
            new AssertionError("Error in Adresse(Adresse a) in Adresse.java, a is null");
    }

    /**
     * Constructeur à partir du tableau d'octets
     * @param al octets
     * @exception AssertionError si al est null
     */
    public Adresse(Octet... al)
    {
        if (al != null)
        {
            this.adresse = new Octet[al.length];
            for(int i = 0; i < al.length; i++)
                this.adresse[i] = al[i];
        }
        else
            new AssertionError("Error in Adresse(Octet... al) in Adresse.java, al is null");
    }

    /**
     * Adresse avec tous les bits à 0
     * @param nbBits nombre de bits
     * @exception AssertionError si le nombre total de bits n'est pas un multiple de 8 supérieur ou égal à 8
     */
    public Adresse(int nbBits)
    {
        if (nbBits >= 8 && nbBits % 8 == 0)
        {
            this.adresse = new Octet[nbBits/8];
            for(int i = 0; i < nbBits / 8; i++)
                this.adresse[i] = new Octet();
        }
        else
            throw new AssertionError("Error in Adresse(int nbBits) in Adresse.java, nbBits < 8 or nbBits % 8 != 0");
    }

    /**
     * Adresse masque composée de nbBitsUn bits à 1 suivis de 0 pour compléter.
     * @param nbBits nombre de bits total
     * @param nbBitsUn nombre de bits à 1
     * @exception AssertionError si le nombre total de bits n'est pas un multiple de 8 supérieur ou égal à 8
     * @exception AssertionError si le nombre total de 1 est incorrect (négatif ou supérieur à nbBits)
     */
    public Adresse(int nbBits, int nbBitsUn)
    {
        if (nbBitsUn <= nbBits && nbBitsUn > 0)
        {
            if (nbBits >= 8 && nbBits % 8 == 0)
            {
                this.adresse = new Octet[nbBits/8];
                for(int i = 0; i < nbBits / 8; i++)
                {
                    this.adresse[i] = new Octet();
                    this.adresse[i].setUn(nbBitsUn > 8 ? 8 : nbBitsUn);
                    if (nbBitsUn > 8)
                        nbBitsUn -= 8;
                }
            }
            else
                throw new AssertionError("Error in Adresse(int nbBits, int nbBitsUn) in Adresse.java, nbBits < 8 or nbBits % 8 != 0");    
        }
        else
            throw new AssertionError("Error in Adresse(int nbBits, int nbBitsUn) in Adresse.java, nbBitsUn < 0 or nbBitsUn > nbBits");    
    }

    /**
     * Constructeur à partir d'une adresse écrite sous forme de notation décimale pointée (par ex : 245.156.0.0)
     * @param s notation décimale pointée d'une adresse (par ex : 245.156.0.0)
     * @exception AssertionError si le nombre d'octets est différent de 4, 6, 8 ou si un entier est trop grand
     */
    public Adresse(String s)
    {
        String[] splitted = s.split("\\.");
        if (splitted.length == 4 || splitted.length == 6 || splitted.length == 8)
        {
            this.adresse = new Octet[splitted.length];
            int i = 0;
            for (String o : splitted)
            {
                int octet = Integer.parseInt(o);
                this.adresse[i] = new Octet();
                if (octet >= 0 && octet <= 255)
                {
                    this.adresse[i].ajouter(octet);
                }
                else
                    throw new AssertionError("Error in Adresse(String s) in Adresse.java, bytes in s is too big or negative.");
                i++;
            }    
        }
        else
            throw new AssertionError("Error in Adresse(String s) in Adresse.java, s != 4, 6 or 8");
    }

    /**
     * Retourne le nombre de bits
     * @return le nombre de bits
     */
    public int size() {
        return this.adresse.length*8;
    }

    /**
     * Retourne le nombre d'octets
     * @return le nombre d'octets
     */
    public int getNbreOctets()
    {
        return this.adresse.length;
    }

    /**
     * Appliquer un masque
     * @param masque masque à appliquer
     * @exception AssertionError si le masque et le receveur ne sont pas de la même taille
     */
    public void masquer(Adresse masque) {
    }

    /**
     * Inverser les octets : complément à 1 de chaque octet (0 &rarr; 1, 1 &rarr; 0)
     */
    public void inverser()
    {
        for (Octet octet : adresse)
        {
            octet.inverser();    
        }
    }

    /**
     * Fixer les octets
     * @param alo octets
     * @exception AssertionError si alo est null
     */
    public void setOctets(Octet... alo)  {
    }

    /**
     * Fixer un des octets de l'adresse, k est le rang de l'octet, k &ge; 0
     * @param o octet
     * @param k rang de l'octet
     * @exception AssertionError si k n'est pas entre 0 et le nombre d'octets
     */
    public void setOctet(Octet o, int k)  {
    }

    /**
     * Consulter un des octets de l'adresse, k est le rang de l'octet, k &ge; 0
     * @param k rang de l'octet
     * @return l'octet de rang k de l'adresse
     * @exception AssertionError si k n'est pas entre 0 et le nombre d'octets
     */
    public Octet getOctet(int k) {
        return null ;
    }

    /**
     * Construit la chaîne de caractères où la valeur de chaque octet est séparé du suivant par un point.
     * Par exemple 192.45.43.100
     * @return la chaîne de caractères construite
     */
    public String toString() {
        String res = "";
        for (Octet octet : this.adresse)
            res+=(char)octet.getValue();
        return res;
    }

}
