package model;

import entity.CalendarioBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by J Michael
 */
public class DbManager {

    private String db ;
    private String url;
    private String user;
    private String pass;
    private Connection con;

    private PreparedStatement ps;

    /**
     * Método constructor
     * @param db
     * @param user
     * @param pass
     */
    public DbManager(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
        url = "jdbc:mysql://localhost:3306/" + this.db;
        connect();
    }

    /**
     * db connect
     */
    public void connect() {

        try {

            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Database Connected !");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cannot connect the db " + e.getSQLState() + e.getMessage() + e.getCause());
        }
    }

    /**
     * close connection
     */
    public void closeConnection(){
        try {
            if (con != null) {
                con.close();
                System.out.println("Database Desconnected");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * first Insert into CalendarioBase table
     */
    public void firstInsertCalendarioBase(ArrayList<CalendarioBase> data) {

        String query = "insert into calendariobase(id, isSummer, isFestivo) values(?,?,?)";

        for (int i = 0; i < data.size(); i++) {
            try {
                ps = con.prepareStatement(query);
                ps.setString(1, data.get(i).getIdDate());
                ps.setBoolean(2, data.get(i).isSummer());
                ps.setBoolean(3, data.get(i).isFestivo());
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("error firstInsertCalendarioBase : " + e.getMessage());
                closeConnection();
                break;
            }
        }
        System.out.println("Se registró correctamente el calendarioBase xD");
    }
}
