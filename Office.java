import java.util.*;
class Employee{
    String Name, Address;
    int Age;
    long PhoneNumber;
    double Salary;
    Employee(String n, String addr, int a, long phno, double sal){
        Name=n;
        Address=addr;
        Age=a;
        PhoneNumber=phno;
        Salary=sal;
    }
    void printSalary(){
        System.out.println("Salaray: "+Salary);
    }
    void incrementSalary(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the amount to be incremented: ");
        double inc=sc.nextDouble();
        Salary+=inc;
        System.out.println("New Salary: "+Salary);
    }
}



class Manager extends Employee{
    String Branch;
    Manager(String n, String addr, int a, long phno, double sal, String brc){
        super(n, addr, a, phno, sal);
        Branch=brc;
    }
    void printData(){
        System.out.println("Name of the employee: "+super.Name);
        System.out.println("Address: "+super.Address);
        System.out.println("Age: "+super.Age);
        System.out.println("Phone number: "+super.PhoneNumber);
        System.out.println("Branch: "+Branch);
    }
}



class Officer extends Employee{
    String Department;
    Officer(String n, String addr, int a, long phno, double sal, String dept){
        super(n, addr, a, phno, sal);
        Department=dept;
    }
    void printData(){
        System.out.println("Name of the employee: "+super.Name);
        System.out.println("Address: "+super.Address);
        System.out.println("Age: "+super.Age);
        System.out.println("Phone number: "+super.PhoneNumber);
        System.out.println("Department: "+Department);
    }
}


public class Office{
   public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        
        System.out.println("1. Manager Details");
        System.out.println("2. Officer Details");
        System.out.print("Enter your choice: ");
        int choice=sc.nextInt();
        
        if (choice==1){
           System.out.print("Enter the name of the manager: ");
           String m_na=sc.next();
           System.out.print("Enter his/her address: ");
           String m_ad=sc.next();
           System.out.print("Enter his/her age: ");
           int m_ag=sc.nextInt();
           System.out.print("Enter his/her phone number: ");
           long m_ph=sc.nextLong();
           System.out.print("Enter his/her salary: ");
           double m_sa=sc.nextDouble();
           System.out.print("Enter his/her branch: ");
           String m_br=sc.next();
           Manager m_obj=new Manager(m_na, m_ad, m_ag, m_ph, m_sa, m_br);
           char m_ct;
           do{
               System.out.println();
               System.out.println("1. Display the details");
               System.out.println("2. Increment Salaray");
               System.out.print("Enter your choice: ");
               int m_ch=sc.nextInt();
               System.out.println();
               switch(m_ch){
                   case 1:
                       m_obj.printData();
                       m_obj.printSalary();
                       break;
                   case 2:
                       m_obj.incrementSalary();
                       break;
                   default:
                       System.out.println("Invalid choice");
                       break;
               }
               System.out.println();
               System.out.print("Do you wish to continue? (y/n): ");
               m_ct=sc.next().charAt(0);
           } while(m_ct=='Y' || m_ct=='y');
        }       
        
        else if(choice==2){
           System.out.print("Enter the name of the officer: ");
           String o_na=sc.next();
           System.out.print("Enter his/her address: ");
           String o_ad=sc.next();
           System.out.print("Enter his/her age: ");
           int o_ag=sc.nextInt();
           System.out.print("Enter his/her phone number: ");
           long o_ph=sc.nextLong();
           System.out.print("Enter his/her salary: ");
           double o_sa=sc.nextDouble();
           System.out.print("Enter his/her department: ");
           String o_de=sc.next();
           Officer o_obj=new Officer(o_na, o_ad, o_ag, o_ph, o_sa, o_de);
          
           char o_ct;
           do{
               System.out.println();
               System.out.println("1. Display the details");
               System.out.println("2. Increment Salaray");
               System.out.print("Enter your choice: ");
               int o_ch=sc.nextInt();
               System.out.println();
               switch(o_ch){
                   case 1:
                       o_obj.printData();
                       o_obj.printSalary();
                       break;
                   case 2:
                       o_obj.incrementSalary();
                       break;
                   default:
                       System.out.println("Invalid choice");
                       break;
               }
               System.out.println();
               System.out.print("Do you wish to continue? (y/n): ");
               o_ct=sc.next().charAt(0);
           } while(o_ct=='Y' || o_ct=='y');
        }
        
        else
            System.out.println("Invalid choice.");
    }
}
