package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class _Connection {
    public static String driver = "com.mysql.cj.jdbc.Driver";

    public static Connection getConection(String url, String usr, String pass){

        Connection c = null;
        try{
            Class.forName(driver);
            c = DriverManager.getConnection(url, usr, pass);
        }catch(ClassNotFoundException | SQLException e){ System.out.println(e.toString()); }
        return c;
    }

    /* Function with the only purpose of "default" DB & usr connection */
    public static Connection getConection(){
        return getConection("jdbc:mysql://localhost:3306/comision1109","root", ""); //En windows-pc con puerto SQL default (3306).
        //return getConection("jdbc:mysql://localhost:7070/comision1109", "root", "");//En linux-pc con puerto SQL personalizado.
    }
}
