import java.util.*;
public class prime
{
   public static void main(String args[])
   {
      Scanner sc=new Scanner(System.in);
      System.out.print("Enter a number: ");
      int n=sc.nextInt();
      int fact=0;
      if(n<0)
         System.out.println(n+" is not a real number.");
      else if(n==1)
         System.out.println("1 is neither a prime number nor a composite number.");
      else
      {
         for(int i=2; i<n; i++)
            if(n%i==0)
               fact++;
         if(fact==0)
            System.out.println(n+" is a prime number.");
         else
            System.out.println(n+" is not a prime number.");
      }
   }
}
