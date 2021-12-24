package config;

import com.mysql.cj.PreparedQuery;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase {
    private _Connection c = null;

    public DataBase(_Connection c) { this.c = c; }
    public static ResultSet selectionQuery(String[] argumentsToSelect, String[] fromTables, String[] whereArguments, String[] whereValues) throws SQLException {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("SELECT ");
        //strBuilder.append(argumentsToSelect);
        for (String s : argumentsToSelect){ strBuilder.append(s + ", "); }
        strBuilder.delete(strBuilder.length()-2, strBuilder.length()); // check if is removing the last ", ". DELETE
        strBuilder.append(" FROM ");
        for (String s : fromTables){ strBuilder.append("`"+ s + "`, "); }
        strBuilder.delete(strBuilder.length()-2, strBuilder.length()); // check if is removing the last ", ". DELETE
        if(whereArguments.length != 0 ) strBuilder.append(" WHERE ");
        for(int i=0; i < whereArguments.length; i++){
            strBuilder.append("`" + whereArguments[i]+"`="+whereValues[i]+" AND ");
        }
        if(whereArguments.length != 0 ) strBuilder.delete(strBuilder.length()-3, strBuilder.length());
        strBuilder.append(";");
        PreparedStatement ps = _Connection.getConection().prepareStatement(strBuilder.toString());
        return ps.executeQuery();
    }

    public static void updateQuery(String[] from, String[] args, String[] argsValue, String[] whereArg, String[] whereVal) throws SQLException {
        //UPDATE `participantes` SET `nombre` = '_nombre', `apellido` = '_apellido', `edad` = '_edad', `fechaIngreso` = '_fechaIngreso',
        //      `provincia` = '_provincia', `email` = '_email', `direccion` = '_direccion' WHERE `participantes`.`id` = _id;

        StringBuilder sB = new StringBuilder("UPDATE ");
        for (String s: from) sB.append("`" + s + "` ,");
        sB.delete(sB.length()-1, sB.length());
        sB.append("SET ");
        for (int i=0; i < args.length; i++){
            sB.append("`" + args[i] + "`='" + argsValue +"',");
        }
        sB.delete(sB.length()-1, sB.length());
        sB.append(" WHERE ");
        for (int i=0; i < whereArg.length; i++) sB.append("`" + whereArg[i] + "`=" + whereVal[i] + ",");
        sB.delete(sB.length()-1, sB.length());
        sB.append(";");
        PreparedStatement pS = _Connection.getConection().prepareStatement(sB.toString());
        pS.executeQuery();
    }
}
