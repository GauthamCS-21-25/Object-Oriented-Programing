import java.io.*;

class multiThread{
   public static void main(String args[]){
      Even t1=new Even();
      Odd t2=new Odd();
      t1.start();
      t2.start();
   }
}

class Even extends Thread{
   public void run(){
      for(int i=0; i<10; i+=2){
         System.out.println(i);
          try{
            Thread.sleep(1200);
          }
          catch(InterruptedException e){
            System.out.println(e);
          }    
      }
   }
}

class Odd extends Thread{
   public void run(){
      for(int i=1; i<10; i+=2){
         System.out.println(i);
          try{
            Thread.sleep(1200);
          }
          catch(InterruptedException e){
            System.out.println(e);
          }    
      }
   }
}