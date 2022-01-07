package models;


import config.DataBase;
import config._Connection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    private String[] fromTable = {"administradores"};
    private DataBase db;
    public LoginDAO(){ db = new DataBase(new _Connection()); }

    public Boolean isEmailInDB(String email) throws SQLException {
        //SELECT `email` FROM `administradores` WHERE `email`=email;
        String[] args = {"email"};
        String[] whereValues = {email};
        ResultSet rs = db.selectionQuery(args, this.fromTable, args, whereValues);
        return rs.next();
    }

    public Boolean isPassOfEmail(String email, String pass) throws SQLException {
        //SELECT `email` FROM `administradores` WHERE `email`=email AND `contrasena` = pass;
        String[] args = {"email"};
        String[] whereParams = {"email", "contrasena"};
        String[] whereValues = {email, pass};
        ResultSet rs = db.selectionQuery(args, this.fromTable, whereParams, whereValues);
        return rs.next();
    }

    public Boolean createUser(String email, String pass){
        //INSERT INTO `administradores` (`email`, `contrasena`) VALUES ('email', 'contrasena');
        String[] args = {"email", "contrasena"};
        String[] argsValue = {email, pass};
        try { if (isEmailInDB(email)) return false; }
        catch (SQLException e) { return false; }

        try {
            db.insertQuery(this.fromTable[0], args, argsValue);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
