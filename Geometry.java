import java.util.Scanner;

abstract class Shape{
   
    abstract void numberOfSides();
    abstract double getArea();
   
}

class Rectangle extends Shape{
   int a, b;
   void setDimensions(int x, int y){
      a = x;
      b = y;
   }
   void numberOfSides(){
      System.out.println("A rectangle has 4 sides.");
   }
   double getArea(){
      System.out.println("Inside area of Rectangle");
      return (a*b);
   }
}


class Triangle extends Shape{
   int a, b, c;
   void setDimensions(int x, int y, int z){
      a = x;
      b = y;
      c = z;
   }
   void numberOfSides(){
      System.out.println("A triangle has 3 sides.");
   }
   double getArea(){
      System.out.println("Inside area of Triangle");
      double s = (a+b+c)/2;
      return (Math.sqrt(s*(s-a)*(s-b)*(s-c)));
   }
}


class Hexagon extends Shape{
   int a;
   void setDimensions(int x){
      a = x;
   }
   void numberOfSides(){
      System.out.println("A hexagon has 6 sides.");
   }
   double getArea(){
      System.out.println("Inside area of Hexagon");
      return (((3*(Math.sqrt(3)))/2)*(Math.pow(a,2)));
   }
}


public class Geometry{
   public static void main(String args[]){
      Scanner sc=new Scanner(System.in);
      double ar;
      
      Rectangle r=new Rectangle();
      System.out.print("Enter the length and breadth of the rectangle: ");
      int l=sc.nextInt();
      int b=sc.nextInt();
      r.setDimensions(l, b);
      r.numberOfSides();
      ar = r.getArea();
      System.out.println(ar);
      
      Triangle t=new Triangle();
      System.out.print("Enter the three sides of the triangle: ");
      int i=sc.nextInt();
      int j=sc.nextInt();
      int k=sc.nextInt();
      t.setDimensions(i, j, k);
      t.numberOfSides();
      ar = t.getArea();
      System.out.println(ar);
      
      Hexagon h=new Hexagon();
      System.out.print("Enter the side of the hexagon: ");
      int s=sc.nextInt();
      h.setDimensions(s);
      h.numberOfSides();
      ar = h.getArea();
      System.out.println(ar);
   }
}
