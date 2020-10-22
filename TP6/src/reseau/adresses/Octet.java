package reseau.adresses;
import java.lang.Object;

public class Octet
{
    protected boolean[] bits;
    
    public Octet() {
        this(0);
    }
    
    public Octet(final int entier) {
        this.setValue(entier);
    }
    
    public Octet(final Octet o) {
        this.bits = new boolean[8];
        for (int k = 7; k >= 0; --k) {
            this.bits[k] = o.bits[k];
        }
    }
    
    private void setValue(int entier) {
        // assert entier <= 255 && entier >= 0 : invokedynamic(makeConcatWithConstants:(I)Ljava/lang/String;, entier);
        this.bits = new boolean[8];
        for (int k = 7; k >= 0; --k) {
            this.bits[k] = (entier % 2 == 1);
            entier /= 2;
        }
    }
    
    public void setUn(final int nbUn) {
        assert nbUn >= 0 && nbUn <= 8 : "Nombre de bits incorrect";
        for (int k = 0; k < nbUn; ++k) {
            this.bits[k] = true;
        }
    }
    
    public void setUn() {
        this.setUn(8);
    }
    
    public boolean estUneLettre() {
        final int val = this.getValue();
        return (val >= 97 && val <= 122) || (val >= 65 && val <= 90);
    }
    
    public boolean estUnPoint() {
        final int val = this.getValue();
        return val == 46;
    }
    
    public boolean plusPetitQue(final int i) {
        return this.getValue() < i;
    }
    
    public int getValue() {
        int res = 0;
        int puiss2 = 1;
        for (int k = 7; k >= 0; --k) {
            if (this.bits[k]) {
                res += puiss2;
            }
            puiss2 *= 2;
        }
        return res;
    }
    
    public void inverser() {
        for (int k = 7; k >= 0; --k) {
            this.bits[k] = !this.bits[k];
        }
    }
    
    public void masquer(final Octet masque) {
        assert masque != null : "Masque ind\u00e9fini";
        for (int k = 7; k >= 0; --k) {
            this.bits[k] = (this.bits[k] && masque.bits[k]);
        }
    }
    
    public void ajouter(final int i) {
        this.setValue(this.getValue() + i);
    }
    
    // @Override
    // public String toString() {
    //     return invokedynamic(makeConcatWithConstants:(I)Ljava/lang/String;, this.getValue());
    // }
    
    // public static void main(final String[] args) {
    //     Octet o = new Octet(126);
    //     Octet m = new Octet();
    //     o.masquer(m);
    //     assert o.toString().equals("0");
    //     assert m.toString().equals("0");
    //     o = new Octet(126);
    //     m = new Octet(1);
    //     o.masquer(m);
    //     assert o.toString().equals("0");
    //     assert m.toString().equals("1");
    //     m = new Octet(127);
    //     o.masquer(m);
    //     assert o.toString().equals("0");
    //     assert m.toString().equals("127");
    //     o = new Octet(126);
    //     m = new Octet(116);
    //     o.masquer(m);
    //     assert o.toString().equals("116");
    //     assert m.toString().equals("116");
    //     o = new Octet(10);
    //     m = new Octet(100);
    //     o.masquer(m);
    //     assert o.toString().equals("0");
    //     assert m.toString().equals("100");
    //     o = new Octet(100);
    //     m = new Octet(100);
    //     o.masquer(m);
    //     assert o.toString().equals("100");
    //     assert m.toString().equals("100");
    //     o = new Octet(127);
    //     o.inverser();
    //     assert o.toString().equals("128");
    //     o = new Octet(12);
    //     o.inverser();
    //     assert o.toString().equals("243");
    //     o = new Octet(1);
    //     o.inverser();
    //     assert o.toString().equals("254");
    //     final short val = 33;
    //     o = new Octet(val);
    //     assert o.toString().equals("33");
    //     o = new Octet(98);
    //     assert o.estUneLettre();
    //     o.ajouter(-32);
    //     assert (char)o.getValue() == 'B';
    //     o = new Octet(122);
    //     assert o.estUneLettre();
    //     o.ajouter(-32);
    //     assert (char)o.getValue() == 'Z';
    // }
}