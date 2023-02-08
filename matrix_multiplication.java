import java.util.*;
public class matrix_multiplication
{
   public static void main(String args[])
   {
      Scanner sc=new Scanner(System.in);
      int r1, c1, r2, c2;
      System.out.print("Enter the number of rows in Matrix A: ");
      r1=sc.nextInt();
      System.out.print("Enter the number of columns in Matrix A: ");
      c1=sc.nextInt();
      System.out.print("Enter the number of rows in Matrix B: ");
      r2=sc.nextInt();
      System.out.print("Enter the number of columns in Matrix B: ");
      c2=sc.nextInt();
      if(c1==r2)
      {
         int a[][]=new int[r1][c1];
         int b[][]=new int[r2][c2];
         System.out.println("Enter the elements to the Matrix A: ");
         for(int i=0;i<r1;i++)
            for(int j=0;j<c1;j++)
               a[i][j]=sc.nextInt();
         System.out.println("Enter the elements to the Matrix B: ");
         for(int i=0;i<r2;i++)
            for(int j=0;j<c2;j++)
               b[i][j]=sc.nextInt();
         int c[][]=new int[r1][c2];
         
         for(int i=0;i<r1;i++)
			   for(int j=0;j<c2;j++){
				   c[i][j]=0;
				   for(int k=0;k<c1;k++)
				   	c[i][j]+=a[i][k]*b[k][j];
				}
			
			System.out.println("Product Matrix: ");
			for(int i=0;i<r1;i++)
			{
			   for(int j=0;j<c2;j++)
			      System.out.print(c[i][j]+"\t");
			   System.out.println();
			}
      }
      else
         System.out.println("Matrix multiplication not possible.");
   }
}
