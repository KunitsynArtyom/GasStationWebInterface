package repositories;

import entities.Station;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class GasStationRepository {

    List<Station> stationList;

    public GasStationRepository() {

    }

    public List<Station> showTable() {
        Connection connection;
        Statement stmt;
        ResultSet rs;
        stationList = new ArrayList<Station>();
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/AZS", "postgres", "qwerty1");
            String query = "SELECT * FROM \"AZS\".\"GasStation\"";
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
            try {
                while (rs.next()) {
                    Station st = new Station(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
                    stationList.add(st);
                }
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (!connection.isClosed()) {
                    connection.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stationList;
    }

    public void addNewStation(Station station) {
        Connection connection;
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/AZS", "postgres", "qwerty1");
            try {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO \"AZS\".\"GasStation\" (orgname, country, city, street, storagecap) VALUES(?, ?, ?, ?, ?);");
                ps.setString(1, station.getOrgname());
                ps.setString(2, station.getCountry());
                ps.setString(3, station.getCity());
                ps.setString(4, station.getStreet());
                ps.setInt(5, station.getStoragecap());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (!connection.isClosed()) {
                    connection.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
