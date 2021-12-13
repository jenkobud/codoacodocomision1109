import java.sql.*;

public class BaseDeDatos {
    private Connection connection;

    public BaseDeDatos(Connection connection) {
        this.connection = connection;
    }
    /*
    * PRE: vars, fromTables, whereVars, whereValues are all real variables from the DataBase.
    *       vars & fromTables can't be empty.
    *      Only accepts equal (=) conditions (applied with &) at WHERE.
    * This function receives "vars" with the variables that we want to select,
    * the "fromTables" the tables from where the data will be retrieved,
    * the "whereVars" the variables for the where condition,
    * the "whereValues" the values which will check with whereVars to retrieve the data.
    * whereVars & whereValues need to have the same size & same variable-value index.
    * POST: returns a ResultSet with the data retrieved, in case of no data selected
    * the resultset will be "empty".
    */
    public ResultSet selectQuery(String[] vars, String[] fromTables, String[] whereVars, String[] whereValues) throws SQLException {
        String query = "SELECT ";
        query+= strArrayToStringWithcomas(vars);
        query+=" FROM ";
        query+= strArrayToStringWithcomas(fromTables);
        if(whereVars.length != 0) query+=" WHERE ";
        for (int i=0; i < whereVars.length; i++){
            query+= whereVars[i]+" = "+whereValues[i];
            if(i+1 == fromTables.length) continue;
            query+="AND ";
        }

        PreparedStatement ps;
        ps = connection.prepareStatement(query + ";");
        return ps.executeQuery();
    }

    /*
    * PRE: -fields & table must exists on the Database.
    *      -fields & values must have the same size and field-value index.
    * Inserts values to the specified fields over the given table at the DataBase.
    * fields: fields to be inserted with the values at the database.
    * values: values to be inserted to the Database.
    * table: table where the values will be inserted.
    */

    public void insertQuery(String[] values, String[] fields, String table) throws SQLException{
        values.toString();
        String query =
                "INSERT INTO " + table + " (" + strArrayToStringWithcomas(fields) + " )"
                + " VALUES (" + strArrayToStringWithcomas(values) + " );";
        PreparedStatement ps;
        ps = connection.prepareStatement(query);
        ps.executeQuery();
    }

    /*
     * PRE: -whereFields & tables must exists on the Database.
     *      -whereFields & whereValues must have the same length and field-value index.
     * Removes the data (when the WHERE-condition applies) from the given tables at the DataBase.
     * whereFields: fields to use as condition with the values at the database.
     * values: values to use as condition with the fields at the database.
     * tables: tables where the data will be deleted.
     */
    public void deleteQuery(String[] tables, String[] whereFields, String[] whereValues) throws SQLException {
       String query= "DELETE FROM " + strArrayToStringWithcomas(tables) + " WHERE ";
       for (int i=0; i < whereFields.length; i++){
           query+= whereFields[i] +" = "+ whereValues[i];
           if (i+1 == whereFields.length) continue;
           query+= "AND ";
       }
        PreparedStatement ps;
        ps = connection.prepareStatement(query +"; ");
        ps.executeQuery();
    }
    /*
    * PRE: -arr is not empty.
    * RETURN: arr[0], arr[1], arr[2],.., arr[n]
    * */
    private String strArrayToStringWithcomas(String[] arr){
        String s = "";
        for (int i=0; i < arr.length; i++){
            s+= arr[i];
            if(i+1 == arr.length) continue;
            s+= ", ";
        }
        return s;
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
