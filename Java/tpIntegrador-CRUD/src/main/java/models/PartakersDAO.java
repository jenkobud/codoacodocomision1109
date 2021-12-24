package models;

import config.DataBase;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartakersDAO {

    public List<Partaker> getStudents() throws SQLException {
        //SELECT * FROM participantes;
        String[] args = {"*"};
        String[] from = {"Alumnos"};
        String[] emptyArray = {};
        ResultSet rs = DataBase.selectionQuery(args, from, emptyArray, emptyArray);
        List<Partaker> partakers = new ArrayList<Partaker>();
        String names, lastnames, email, address, province;
        int id, age;
        Date rDate;
        while (rs.next()) {
            //public Partaker(int id, String nombres, String apellidos, String email, String direccion, Integer telefono) {
            id = rs.getInt("id");
            names = rs.getString("nombre");
            lastnames = rs.getString("apellido");
            email = rs.getString("email");
            address = rs.getString("addres");
            age = rs.getInt("edad");
            rDate = rs.getDate("fechaIngreso");
            province = rs.getString("provincia");

            partakers.add(new Partaker(id, names, lastnames, age, rDate, province, email, address));
        }
        return partakers;
    }

    public Partaker getStudentById(int id) throws SQLException {
        //SELECT * FROM `participantes` WHERE `participantes`.`id` = id;
        String[] args = {"*"};
        String[] from = {"participantes"};
        String[] whereArg = {"id"};
        String[] whereVal = {String.valueOf(id)};
        ResultSet rs = DataBase.selectionQuery(args, from, whereArg, whereVal);
        if (rs.wasNull()) return null;
        String names, lastnames, email, address, province;
        int age;
        Date rDate;
        names = rs.getString("nombre");
        lastnames = rs.getString("apellido");
        email = rs.getString("email");
        address = rs.getString("addres");
        age = rs.getInt("edad");
        rDate = rs.getDate("fechaIngreso");
        province = rs.getString("provincia");
        return (new Partaker(id, names, lastnames, age, rDate, province, email, address));
    }

    public void modifyPartakerById(int id, String name, String lastname, int age, Date rDate, String province, String email, String address) throws SQLException {
        //UPDATE `participantes` SET `nombre` = 'Pepe', `apellido` = 'Rojas', `edad` = '21', `fechaIngreso` = '2021-11-03 09:52:22',
        //      `provincia` = 'C.A.B.A.', `email` = 'pepeRojas@services.com', `direccion` = 'Av. Siempre Viva 99' WHERE `participantes`.`id` = 1;
        String[] args = {"*"};
        String[] argsValue = {};
        String[] from = {"participantes"};
        String[] whereArg = {"id"};
        String[] whereVal = {String.valueOf(id)};
        DataBase.updateQuery(from, args, argsValue, whereArg, whereVal);
    }
}
