import java.sql.*;

public class BaseDeDatos {
    private Connection connection;

    public BaseDeDatos(Connection connection) {
        this.connection = connection;
    }
    /*
    * PRE: vars, fromVars, fromValues are all real variables from the DataBase
    * This function receives "vars" with the variables that we want to select,
    * the "fromVars" the variables from where the data will be retrieved,}
    * the "fromValues" the values to that will check with fromVars to retrieve the data.
    * fromVars & fromValues need to have the same size & same parameter-value index.
    * POST: returns a ResultSet with the data retrieved, in case of no-data selected
    * the resultset will be "empty"*/
    public ResultSet SelectQuery(String[] vars, String[] fromVars, String[] fromValues) throws SQLException {
        String query = "";
        PreparedStatement ps;
        ps = connection.prepareStatement("SELECT * FROM participantes");
        return ps.executeQuery();
    }

    public Connection getConnection() { return connection; }
    public void setConnection(Connection connection) { this.connection = connection; }

    public static void main(String[] args) throws SQLException {
        Conexion conexion = new Conexion("jdbc:mysql://localhost:7070/comision1109","jenko","budnechky01");
        BaseDeDatos db = new BaseDeDatos(conexion.getConection());

/*        while(rs.next()){
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
        }*/
    }
}
