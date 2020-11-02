package reseau;

import java.util.ArrayList;

import reseau.adresses.Adresse;
import reseau.adresses.Octet;

/**
 * @author martine
 * @version 4 déc. 2014
 */
public class Message
{

    private ArrayList<Octet> message;

    /**
     * Constructeur d'un message vide
     */
    public Message()
    {
        this.message = new ArrayList<Octet>();
    }

    /**
     * Constructeur de copie (copie profonde)
     * @param mess nombre d'éléments à copier
     * @exception AssertionError si mess est null
     */
    public Message(Message mess)
    {
        assert mess != null: new AssertionError("Error in Adresse(Adresse a) in Adresse.java, a is null");
        this.message = new ArrayList<Octet>();
        for (int i = 0; i < mess.size(); i++)
            this.message.add(mess.getOctet(i));       
    }

    /**
     * Constructeur d'un message à partir des petits entiers (1 petit entier est codé sur un seul octet)
     * @param v des petits entiers qui constituent le message
     */
    public Message(short... v)
    {
        this.message = new ArrayList<Octet>();
        for (short s : v)
            this.ajouter(s);
    }

    /**
     * Constructeur d'un message à partir des entiers (1 entier est codé sur 2 octets)
     * @param v des entiers qui constituent le message
     */
    public Message(int... v)
    {
        this.message = new ArrayList<Octet>();
        for (int s : v)
        {
            if (s > 255)
                this.ajouter(s-255);
            else
                this.ajouter(new Octet());
            this.ajouter(s);
        }
    }
    
    /**
     * Constructeur d'un message à partir de la chaîne de caractères
     * @param mot chaîne de caractères qui constitue le message
     */
    public Message(String mot)
    {
        this.message = new ArrayList<Octet>();
        for (int i = 0; i < mot.length(); i++)
        {
            char c = mot.charAt(i);
            if (c <= 'ÿ')
            {
                short s = Short.parseShort(Character.toString(c));
                this.ajouter(s);
            }
            else
            {
                int j = Integer.parseInt(Character.toString(c));
                this.ajouter(j);
            }    
        }
    }
    
    /**
     * Constructeur d'un message à partir de l'adresse
     * @param adr adresse à placer dans le message
     */
    public Message(Adresse adr)
    {
        this.message = new ArrayList<Octet>();
        for (int i = 0; i < adr.getNbreOctets(); i++)
            this.ajouter(adr.getOctet(i));
    }
        
    /**
     * Retourne le nombre d'octets
     * @return le nombre d'octets
     */
    public int size() {
        return this.message.size();
    }

    /**
     * Retourne l'octet d'indice i dans le Message
     * @param index de l'octet à retourner
     * @return octet d'indice i
     */
    public Octet getOctet(int index) {
        return this.message.get(index);
    }

    /**
     * Ajouter un petit entier à la fin, entier &ge; 0
     * @param x entier à ajouter
     */
    public void ajouter(short x)
    {
        this.message.add(new Octet((int)x));
    }

    /**
     * Ajouter un entier à la fin, entier &ge; 0
     * @param x entier à ajouter
     */
    public void ajouter(int x)
    {
        this.message.add(new Octet(x));
    }

    /**
     * Ajouter un octet à la fin
     * @param o octet à ajouter
     * @exception AssertionError si o est null
     */
    public void ajouter(Octet o)
    {
        assert o != null : new AssertionError("Error in ajouter(Octet o) in Message.java, o is null"); 
        this.message.add(o);
    }
    
    /**
     * Concaténer un autre message
     * @param mess message à ajouter à la fin
     * @exception AssertionError si mess est null
     */
    public void ajouter(Message mess)
    {
        assert mess != null: new AssertionError("Error in ajouter(Message mess) in Message.java, mess is null");
        for (int i = 0; i < mess.size(); i++)
            this.message.add(mess.getOctet(i));
    }
    
    /**
     * Ajouter les octets d'une adresse à la fin
     * @param adr adresse à ajouter
     * @exception AssertionError si adr est null
     */
    public void ajouter(Adresse adr)
    {
        assert adr != null: new AssertionError("Error in ajouter(Adresse adr) in Message.java, adr is null");
        for (int i = 0; i < adr.size(); i++)
            this.message.add(adr.getOctet(i));
    }
    
    @Override
    public String toString()
    {
        String res = "";
        for (Octet octet : this.message)
            res += (char)octet.getValue();
        return res;
    }

    /**
     * Extraire les 2 octets situés en index et index+1 pour en faire un entier
     * octets forts puis faibles (big endian)
     * @param index index du premier octet
     * @exception AssertionError si index ou index+1 n'est pas dans le domaine du tableau
     * @return un entier
     */
    public int extraireEntier(int index)
    {
        assert index >= this.size() || index + 1 <= 0: new AssertionError("Error in extraireEntier(int index) in Message.java, out of range");
        return this.getOctet(index).getValue() + this.getOctet(index+1).getValue();
    }

    /**
     * Extraire les nbOctets premiers octets pour en faire une adresse
     * @param nbOctets nombre d'octets à extraire
     * @exception AssertionError si nbOctets &gt; longueur du message
     * @return une adresse
     */
    public Adresse extraireAdresse(int nbOctets)
    {
        assert nbOctets > this.size() : new AssertionError("Error in extraireEntier(int nbOctets) in Message.java, out of range");
        Octet[] res = new Octet[nbOctets];
        for (int i = 0; i < nbOctets; i++)
            res[i] = this.getOctet(i);
        Adresse adr = new Adresse(res);
        return adr;
    }

    /**
     * Transformer le message en une suite de lettres, si possible 
     * @return null si l'un des octets n'est pas une lettre (maj ou min)
     */
    public String extraireChaine()
    {
        String res = "";
        for (Octet octet : this.message)
        {
            if (!octet.estUneLettre())
                return null;
            res += (char)octet.getValue();
        }
        return res;
    }

    /**
     * Augmenter de i chaque octet dont la valeur est comprise entre les valeurs bi et bs
     * @param i valeur à ajouter
     * @param bi borne inférieure, inclue
     * @param bs borne supérieure, inclue
     */
    public void augmenter(int i, int bi, int bs)
    {
        for (Octet octet : this.message)
        {
            if (octet.getValue() >= bi && octet.getValue() <= bs)
                octet.ajouter(i);
        }
    }

    /**
     * On enlève les i premiers éléments
     * @param i nombre d'éléments à enlever
     * @exception AssertionError si i n'est pas dans le domaine du tableau
     */
    public void supprimer(int i)
    {
        assert i <= this.size() && i >= 0: new AssertionError("Error in  supprimer(int i) in Message.java, out of range");
        for (int j = 0; j < i; j++)
            this.message.remove(j);
    }

    /**
     * On enlève les éléments entre debut et fin inclus
     * @param debut borne inférieure
     * @param fin borne supérieure
     * @exception AssertionError si on n'a pas 0 &le; debut &le; fin &lt; size()
     */
    public void supprimer(int debut, int fin)
    {
        assert fin <= this.size() && debut >= 0: new AssertionError("Error in  supprimer(int debut, int fin) in Message.java, out of range");
        for (int j = 0; j < this.size(); j++)
        {
            if (j >= debut && j <= fin)
                this.message.remove(j);
        }
    }

}
