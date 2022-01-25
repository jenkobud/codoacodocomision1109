package models;

import config.DataBase;
import config._Connection;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartakersDAO extends DAOClass{

    private String[] from = {"participantes"};

    public PartakersDAO(){ db = new DataBase(new _Connection()); }

    public List<Partaker> getStudents() throws SQLException {
        //SELECT * FROM participantes;
        String[] args = {"*"};
        String[] emptyArray = {};
        ResultSet rs = db.selectionQuery(args, this.from, emptyArray, emptyArray);
        List<Partaker> partakers = new ArrayList<Partaker>();
        String names, lastnames, email, address, province;
        int id, age;
        Date rDate;
        while (rs.next()) {
            id = rs.getInt("id");
            names = rs.getString("nombre");
            lastnames = rs.getString("apellido");
            email = rs.getString("email");
            address = rs.getString("direccion");
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
        String[] whereArg = {"id"};
        String[] whereVal = {String.valueOf(id)};
        ResultSet rs = db.selectionQuery(args, this.from, whereArg, whereVal);
        if (rs.wasNull()) return null;
        String names, lastnames, email, address, province;
        int age;
        Date rDate;
        names = rs.getString("nombre");
        lastnames = rs.getString("apellido");
        email = rs.getString("email");
        address = rs.getString("direccion");
        age = rs.getInt("edad");
        rDate = rs.getDate("fechaIngreso");
        province = rs.getString("provincia");
        return (new Partaker(id, names, lastnames, age, rDate, province, email, address));
    }

    public void modifyPartakerById(int id, String name, String lastname, int age, Date rDate, String province, String email, String address) throws SQLException {
        //UPDATE `participantes` SET `nombre` = 'Pepe', `apellido` = 'Rojas', `edad` = '21', `fechaIngreso` = '2021-11-03 09:52:22',
        //      `provincia` = 'C.A.B.A.', `email` = 'pepeRojas@services.com', `direccion` = 'Av. Siempre Viva 99' WHERE `participantes`.`id` = 1;
        String[] args = {"nombre", "apellido", "edad", "fechaIngreso", "provincia", "email", "direccion"};
        String[] argsValue = {name, lastname, String.valueOf(age), String.valueOf(rDate), province, email, address};
        String[] whereArg = {"id"};
        String[] whereVal = {String.valueOf(id)};
        db.updateQuery(this.from, args, argsValue, whereArg, whereVal);
    }

    public void deletePartakerById(Integer id) throws SQLException{
        //DELETE FROM `participantes` WHERE `participantes`.`id` = idValue;
        String[] args = { "id" };
        String[] argsValue = { id.toString() };
        db.deleteQuery(this.from[0], args, argsValue);
    }

    public void addNewPartaker(String name, String lastname, Integer age, Date rDate, String state, String email, String address) throws SQLException{
        //INSERT INTO `table` (`nombre`, `apellido`, `edad`, `fechaIngreso`, `provincia`, `email`, `direccion`)
        // VALUES ('Ryan', 'Riñas', '54', current_timestamp(), 'Chubut', 'ryanRiñas@gmail.com', 'Av. Siempre Muerta 102');
        String[] args ={"nombre", "apellido", "edad", "fechaIngreso","provincia","email", "direccion"};
        String[] argsValue = {name, lastname, age.toString(), rDate.toString(), state, email, address };
        db.insertQuery(this.from[0], args, argsValue);
    }
}
