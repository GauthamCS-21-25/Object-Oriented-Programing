package SBI;

import java.util.*;
import java.io.*;
public class ATM {
    String acc_No;
    File file;
    public static void main (String args[])throws IOException {
        Scanner sc=new Scanner(System.in);
        char ctn; int ch;
        ATM obj=new ATM();
        obj.input();
        do {
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Display");
            System.out.print("Enter your choice: ");
            ch=sc.nextInt();
            switch(ch) {
                case 1:
                    obj.withdraw();
                    break;
                case 2:
                    obj.deposit();
                    break;
                case 3:
                    obj.display();
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            System.out.print("Do you wish to continue? (y/n): ");
            ctn=sc.next().charAt(0);
            System.out.println();
        } while((ctn=='Y')||(ctn=='y'));
    }
    void input() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your account number: ");
        acc_No=sc.next();
        file=new File(acc_No+".txt");
        try { 
            if(!file.exists() && !file.isDirectory()) {
                System.out.println("Opening a new account...");
                BufferedWriter writer=new BufferedWriter(new FileWriter(file));
                writer.write("0");
                writer.close();
                display();
                System.out.println();
            }
        }
        catch(IOException e) {
            System.out.println("Failed opening account.");
        }
        
    }
    void withdraw() {
        Scanner sc=new Scanner(System.in);
        try {
            System.out.print("Enter the amount to be withdrawn: ");
            int amt=sc.nextInt();
            BufferedReader reader=new BufferedReader(new FileReader(file));
            int balance=Integer.parseInt(reader.readLine());
            reader.close();
            try {
                if(amt>balance)
                    throw new ArithmeticException("Insufficient balance");
                else
                    balance-=amt;
            }
            catch(ArithmeticException e){
                System.out.println(e);
            }
            BufferedWriter writer=new BufferedWriter(new FileWriter(file));
            writer.write(Integer.toString(balance));
            writer.close();
        }
        catch(IOException e) {
            System.out.println("Failed fetching account.");
        }
        finally {
            display();
        }
    }
    void deposit() {
        Scanner sc=new Scanner(System.in);
        try {
            System.out.print("Enter the amount to be deposited: ");
            int amt=sc.nextInt();
            BufferedReader reader=new BufferedReader(new FileReader(file));
            int balance=Integer.parseInt(reader.readLine());
            reader.close();
            BufferedWriter writer=new BufferedWriter(new FileWriter(file));
            writer.write(Integer.toString(balance+amt));
            writer.close();
        }
        catch(IOException e){
            System.out.println("Failed fetching account.");
        }
        finally {
            display();
        }
    }
    void display() {
        try {
            BufferedReader reader=new BufferedReader(new FileReader(file));
            int balance=Integer.parseInt(reader.readLine());
            reader.close();
            System.out.println("Your balance is: "+balance);
        }
        catch(IOException e){
            System.out.println("Failed fetching account.");
        }
    }
}
