package model;

import entity.CalendarioBase;
import entity.Universidad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        url = "jdbc:mysql://mysql.asico.bcn.ninja:3306/" + this.db;
        connect();
        try {
            checkDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //              //
    //              //
    //      API     //
    //              //
    //              //

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

    private boolean isColumnMissing(DatabaseMetaData metaData, String columnName, String tableName) throws SQLException {
        try (ResultSet rs = metaData.getColumns(null, null, tableName, columnName)) {
            return !rs.next();
        }
    }

    private void checkDB() throws SQLException {
        checkUniversidad();
        System.out.println("Tablas revisadas correctamente.");
    }

    public void checkUniversidad() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS universidad ("
                + "id_universidad MEDIUMINT(8) UNSIGNED AUTO_INCREMENT,"
                + "PRIMARY KEY (id_universidad)"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";

        String table = "universidad";

        Statement st = con.createStatement();
        st.executeUpdate(sql);
        DatabaseMetaData md = con.getMetaData();

        if (isColumnMissing(md, "nombre", table)) {
            st.executeUpdate("ALTER TABLE " + table
                    + " ADD COLUMN nombre VARCHAR(60) AFTER id_universidad;");
        }
    }

    private void checkRoles() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS roles (" +
                "id MEDIUMINT(8) UNSIGNED AUTO_INCREMENT,"
                + "PRIMARY KEY (id)"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";

        String table = "roles";

        Statement st = con.createStatement();
        st.executeUpdate(sql);

        DatabaseMetaData md = con.getMetaData();
        if (isColumnMissing(md, "nombre", table)) {
            st.executeUpdate("ALTER TABLE " + table
                    + " ADD COLUMN nombre int(8) AFTER id;");
        }

        if (isColumnMissing(md, "perms", table)) {
            st.executeUpdate("ALTER TABLE " + table
                    + " ADD COLUMN perms VARCHAR(3) AFTER nombre;");
        }

        if (isColumnMissing(md, "color", table)) {
            st.executeUpdate("ALTER TABLE " + table
                    + " ADD COLUMN color VARCHAR(7) AFTER perms;");
        }
    }



    //                  //
    //                  //
    //      GETTERS     //
    //                  //
    //                  //

    public List<CalendarioBase> getCalendariosBase(Universidad uni, String curso) throws SQLException {
        String sql = "select * " +
                "from calendario_base " +
                "where id_universidad=? and curso_academico=? " +
                "order by id desc;";
        ResultSet rs = null;
        List<CalendarioBase> list = new ArrayList<>();

        ps = con.prepareStatement(sql);
        ps.setInt(1, uni.getId());
        ps.setString(2, curso);
        rs = ps.executeQuery();

        while (rs.next()) {
            CalendarioBase cb = new CalendarioBase();
            cb.setDia(rs.getInt("id"));
            cb.setUniversidad(uni);
            cb.setDescSpa(rs.getString("desc_spa"));
            cb.setDescCat(rs.getString("desc_cat"));
            cb.setWeekDay(rs.getInt("week_day"));
            cb.setSummer(rs.getBoolean("is_summer"));
            cb.setFestivo(rs.getBoolean("is_festivo"));
            cb.setActive(rs.getBoolean("is_active"));
            cb.setCursoAcademico(curso);
            list.add(cb);
        }

        return list;
    }


    //                  //
    //                  //
    //      INSERTS     //
    //                  //
    //                  //

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
