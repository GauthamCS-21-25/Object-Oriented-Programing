import java.util.*;
public class token{
   public static void main(String args[]){
      int num, sum=0; String odd="";
      Scanner sc=new Scanner(System.in);
      System.out.println("Namdid Nishad C");
      System.out.println("Enter the integers: ");
      String str=sc.nextLine();
      StringTokenizer st=new StringTokenizer(str);
      while(st.hasMoreTokens()){
         num=Integer.valueOf(st.nextToken());
         if(num%2==0)
            sum+=num;
         else
            odd=num+" ";
      }
      System.out.println("Odd numbers are: "+odd);
      System.out.println("Sum of even numbers is: "+sum);
   }
}
