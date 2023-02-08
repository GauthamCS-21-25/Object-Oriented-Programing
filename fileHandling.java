import java.io.*;
public class fileHandling{
   public static void main(String args[]){
      try{
         FileInputStream in=new FileInputStream("file.txt");
         FileOutputStream out=new FileOutputStream("newfile.txt");
         int i=0; char ch; String str;
         while((i=in.read())!=-1){
            ch=(char)i;
            if(ch>='a'&&ch<='z')
               ch-=32;
            else if(ch>='A'&&ch<='Z')
               ch+=32;
            else if(ch==' ')
               ch='_';
            str=String.valueOf(ch);
            byte b[]=str.getBytes();
            out.write(b);
         }
         System.out.println("Done");
         in.close();
         out.close();
      }
      catch(Exception e){
         System.out.println("An error occured");
      }
   }
}
