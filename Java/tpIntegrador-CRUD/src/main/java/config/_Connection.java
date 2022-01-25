package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class _Connection {
    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private Connection con;
    public _Connection(String url, String usr, String pass){
        con = null;
        try{
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(url, usr, pass);
        }catch(ClassNotFoundException | SQLException e){ System.err.println(e.toString()); }
    }

    /* Function with the only purpose of "default" DB & usr connection */
    public _Connection(){
        con = null;
        try{
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection("jdbc:mysql://localhost:7070/comision1109", "root", "");//En linux-pc con puerto SQL personalizado.
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/comision1109","root", ""); //En windows-pc con puerto SQL default (3306).
        }catch(ClassNotFoundException | SQLException e){ System.err.println(e.toString()); }
    }

    public Connection getConnection(){ return con; }

    public Boolean endConnection() throws SQLException {
        this.con.close();
        return this.con.isClosed();
    }
}
