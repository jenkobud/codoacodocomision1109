import java.sql.*;

public class BaseDeDatos {
    String driver = "com.mysql.cj.jdbc.Driver";//"com.mysql.jdbc.Driver";
    public Connection getConection(){
        Connection c = null;
        try {
            Class.forName(driver);
            c = DriverManager.getConnection("jdbc:mysql://localhost:7070/comision1109","jenko","budnechky01");
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return c;
    }
    public static void main(String[] args) throws SQLException {
        BaseDeDatos db = new BaseDeDatos();
        Connection con = null;
        con = db.getConection();

        PreparedStatement ps;
        ResultSet rs;
        ps = con.prepareStatement("SELECT * FROM participantes");
        rs = ps.executeQuery();

        while(rs.next()){
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String email = rs.getString("email");
            int telefono = rs.getInt("telefono");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| id -> " + id);
            System.out.println("| nombre -> " + nombre);
            System.out.println("| apellido -> " + apellido);
            System.out.println("| email -> " + email);
            System.out.println("| tel -> " + telefono);
            System.out.println("+--------------------------------------------------+");
        }
    }
}
