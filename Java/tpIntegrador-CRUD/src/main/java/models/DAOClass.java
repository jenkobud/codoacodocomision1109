package models;

import config.DataBase;

import java.sql.SQLException;

public abstract class DAOClass {
    protected DataBase db;

    public Boolean closeDB() throws SQLException { return this.db.closeDBConnection(); }
}
