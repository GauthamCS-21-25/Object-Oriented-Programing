import java.util.*;
public class char_frequency
{
   public static void main(String args[])
   {
      Scanner sc=new Scanner(System.in);
      System.out.print("Enter a word: ");
      String str=sc.nextLine();
      int l=str.length();
      System.out.print("Enter the character to be searched: ");
      char ch=sc.next().charAt(0);
      int f=0;
      for(int i=0; i<l; i++)
         if(str.charAt(i)==ch)
            f++;
      System.out.println("Frequency of '"+ch+"' is "+f);
   }
}
