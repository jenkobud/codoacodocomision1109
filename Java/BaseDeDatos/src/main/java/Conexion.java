import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    static String driver = "com.mysql.cj.jdbc.Driver";//"com.mysql.jdbc.Driver";
    String dBurl, usr, pass;

    //dBurl -> "jdbc:mysql://localhost:7070/comision1109"
    //user -> "jenko"
    //password -> "budnechky01"
    public Conexion(String dBurl, String usr, String pass) {
        this.dBurl = dBurl;
        this.usr = usr;
        this.pass = pass;
    }

    public Connection getConection(){
        Connection c = null;
        try {
            Class.forName(driver);
            c = DriverManager.getConnection(dBurl,usr,pass);
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return c;
    }
}
