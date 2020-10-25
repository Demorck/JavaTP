package calc;

public class Nombre implements Expression
{
   private int value;
   
   public Nombre(int v)
   {
       this.value = v;
   }

   public int valeur()
   {
       return this.value;
   }

   public String toString()
   {
       return ""+this.value;
   }
}
