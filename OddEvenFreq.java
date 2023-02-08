import java.util.*;
public class OddEvenFreq{
   public static void main(String args[]){
      Scanner sc=new Scanner(System.in);
      System.out.print("Enter the number of elements in the array: ");
      int n=sc.nextInt();
      int arr[]=new int[n];
      int o_freq=0, e_freq=0;
      System.out.println("Enter the elements to the array: ");
      for(int i=0;i<n;i++)
      {
         arr[i]=sc.nextInt();
         if(arr[i]%2 != 0)
            o_freq++;
         else
            e_freq++;
      }
      System.out.print("The array is: ");
      for(int i=0; i<n; i++)
         System.out.print(arr[i]+ " ");
      System.out.println();
      System.out.println("The frequency of odd numbers in the array is: "+o_freq);
      System.out.println("The frequency of even numbers in the array is: "+e_freq);
   }
}
