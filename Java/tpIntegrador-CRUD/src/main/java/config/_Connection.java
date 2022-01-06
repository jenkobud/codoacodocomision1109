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
            //Check that connection URL & USER are correct for my DB. DELETE
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.toString());
        }
        return c;
    }

    /* Function with the only purpose of "default" DB & usr connection */
    public static Connection getConection(){
        return getConection("jdbc:mysql://localhost:3306/entregadb",
                "root", ""); //En linux-pc usar puerto 7070 DELETE
    }
}
