import java.sql.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class DataBase extends JFrame implements ActionListener {
    JButton search;
    JTextField movie, director, collection, year;
    JLabel dir, yr, col, proof;
    void gui() {
        search = new JButton("Search");
        dir = new JLabel("Director name");
        yr = new JLabel("Year");
        col = new JLabel("Collection");
        movie = new JTextField(10);
        director = new JTextField(10);
        year = new JTextField(10);
        proof = new JLabel("Jonathan Mathew     Roll No. TW3");
        collection = new JTextField(10);
        year.setEditable(false);
        director.setEditable(false);
        collection.setEditable(false);

        add(search);
        add(director);
        add(year);
        add(movie);
        add(collection);
        add(proof);
        add(dir);
        add(yr);
        add(col);

        setLayout(null);
        movie.setBounds(10, 20, 125, 40);
        search.setBounds(20, 70, 90, 20);
        dir.setBounds(150, 30, 120, 10);
        director.setBounds(260, 15, 150, 40);
        yr.setBounds(150, 75, 120, 10);
        year.setBounds(260, 60, 150, 40);
        col.setBounds(150, 105, 125, 40);
        collection.setBounds(260, 110, 150, 40);
        proof.setBounds(150, 150, 250, 40);
        setSize(700, 500);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        search.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        try {
            int flag = 0;
            String mname = movie.getText();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root", "2@Gautham");

            Statement stm = con.createStatement();
            String qry = "select * from movie_details";
            ResultSet rs = stm.executeQuery(qry);
            if (source == search) {
                while (rs.next()) {
                    if (mname.equals(rs.getString(1))) {
                        director.setText(rs.getString(2));
                        year.setText(Integer.toString(rs.getInt(3)));
                        collection.setText(rs.getString(4));
                        flag = 1;
                    }
                }
                if (flag == 0) {
                    director.setText("Not found");
                    year.setText("Not found");
                    collection.setText("Not found");
                }
            }

        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    void displayDescending() throws SQLException, ClassNotFoundException {
        String driverClassName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/movies";
        String username = "root";
        String password = "2@Gautham";
        String query = "select * from movie_details ORDER BY year desc";

        Class.forName(driverClassName);

        Connection con = DriverManager.getConnection(url, username, password);

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            System.out.println("\n--> Movie Name = "+rs.getString(1)+"\n--> Director Name= "+rs.getString(2)+"\n--> Year = "+rs.getInt(3)+"\n--> Collection = "+rs.getDouble(4)+"\n--> Language = "+rs.getString(5));
        }
        rs.close();
        con.close();
    }
    void displayYear(int date) throws SQLException, ClassNotFoundException {
        String driverClassName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/movies";
        String username = "root";
        String password = "2@Gautham";
        String query = "select * from movie_details where year=" + date;

        Class.forName(driverClassName);

        Connection con = DriverManager.getConnection(url, username, password);

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            System.out.println("\n--> Movie Name = "+rs.getString(1)+"\n--> Director Name= "+rs.getString(2)+"\n--> Year = "+rs.getInt(3)+"\n--> Collection = "+rs.getDouble(4)+"\n--> Language = "+rs.getString(5));
        }
        rs.close();
        con.close();
    }

    void deleteYear(int yr) throws SQLException, ClassNotFoundException {
        String driverClassName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/movies";
        String username = "root";
        String password = "2@Gautham";
        String query = "delete from movie_details where year<" + yr;
        String query2 = "select * from movie_details";
        Class.forName(driverClassName);
        int numrows=0;
        Connection con = DriverManager.getConnection(url, username, password);

        Statement stm=con.createStatement();
        String qry1="select * from movie_details";
        String qry2="delete from movie_details where year < "+ yr ;
        ResultSet rs = stm.executeQuery(qry1);
        while(rs.next())
        {
            if(rs.getInt(3)<yr)
            {
                System.out.println("\n--> Movie Name = "+rs.getString(1)+"\n--> Director Name= "+rs.getString(2)+"\n--> Year = "+rs.getInt(3)+"\n--> Collection = "+rs.getDouble(4)+"\n--> Language = "+rs.getString(5));
                numrows++;
            }
        }
        rs.close();

        int count =stm.executeUpdate(qry2);
        if(count>1)
            System.out.println(count+" rows deleted!");
        else if(count>0)
            System.out.println(count+" row deleted!");
        else
            System.out.println("No row deleted");
        stm.close();
        con.close();
    }


    public static void main(String args[]) {
        
        System.out.println("Jonathan Mathew     Roll No. TW3");
        
        Scanner S = new Scanner(System.in);
        int date;
        DataBase a = new DataBase();
        char ch;
        char op;
        int with, add;
        do {
            System.out.println("\n1.Display in descending order of their year");
            System.out.println("2.Display the details of a given movie");
            System.out.println("3.Display the details of names of all the movies released in a given year");
            System.out.println("4.Delete detials of movie released before given year ");
            System.out.print(System.lineSeparator() + "Enter choice: ");
            op = S.next().charAt(0);
            switch (op) {
                case '1':
                    try {
                        a.displayDescending();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case '2':
                    a.gui();
                    break;
                case '3':
                    try {
                        System.out.println("Enter the year: ");
                        date = S.nextInt();
                        a.displayYear(date);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case '4':
                    try {
                        System.out.println("Enter the year: ");
                        date = S.nextInt();
                        a.deleteYear(date);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                default:
                    System.out.println("Invalid Input");
            }
            System.out.print("Do you wish to continue (y/n): ");
            ch = S.next().charAt(0);
        } while (ch == 'y');


    }
}