package DataBaseHandler;

import java.sql.*;

public class DataBase {
    public static String driver = "com.mysql.cj.jdbc.Driver";//"com.mysql.jdbc.Driver";
    Connection con;
    public DataBase(){ con = getConection("jdbc:mysql://localhost:7070/comision1109","jenko","budnechky01"); }
    public DataBase(String url, String usr, String pass){ con = getConection(url, usr, pass); }

    private Connection getConection(String url, String usr, String pass){
        Connection c = null;
        try {
            Class.forName(driver);
            c = DriverManager.getConnection(url, usr, pass);
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return c;
    }

    public ResultSet doDQLCommand(String command) throws SQLException {
        PreparedStatement ps;
        ps = con.prepareStatement(command); //"SELECT * FROM participantes"
        return ps.executeQuery();
    }
}
