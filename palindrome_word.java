import java.util.*;
public class palindrome_word
{
   public static void main(String args[])
   {
      Scanner sc=new Scanner(System.in);
      System.out.print("Enter a word: ");
      String str=sc.next();
      String c_str=str.toUpperCase();
      int l=str.length();
      int flag=1;
      for(int i=0, j=l-1; i<=j; i++, j--)
         if(c_str.charAt(i)!=c_str.charAt(j))
            flag=0;
      if(flag==1)
         System.out.println(str+" is palindrome word.");
      else
         System.out.println(str+" is not palindrome word.");
   }
}
