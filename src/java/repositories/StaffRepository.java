package repositories;

import entities.Staff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class StaffRepository {

    List<Staff> staffList;
    Connection connection;
    ;

    public List<Staff> showTable() {
        Statement stmt;
        ResultSet rs;
        staffList = new ArrayList<Staff>();
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/AZS", "postgres", "qwerty1");
            String query = "SELECT * FROM \"AZS\".\"Staff\"";
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
            try {
                while (rs.next()) {
                    Staff st = new Staff(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                    staffList.add(st);
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
        return staffList;
    }

    public void addNewStaff(Staff staff) {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/AZS", "postgres", "qwerty1");
            try {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO \"AZS\".\"Staff\" (station_id, surname, name, gender, function, salary) VALUES(?, ?, ?, ?, ?, ?);");
                ps.setInt(1, staff.getStationId());
                ps.setString(2, staff.getSurname());
                ps.setString(3, staff.getName());
                ps.setString(4, staff.getGender());
                ps.setString(5, staff.getFunction());
                ps.setInt(6, staff.getSalary());
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

    public Staff findStaffById(Integer i) {
        Statement stmt;
        ResultSet rs;
        Staff staff = null;
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/AZS", "postgres", "qwerty1");
            String query = "SELECT * FROM \"AZS\".\"Staff\" WHERE staff_id = " + i;
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
            try {
                while (rs.next()) {
                    staff = new Staff(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                }
                rs.close();
            } catch (SQLException e) {

            }
        } catch (Exception e) {

        }
        return staff;
    }

    public void updateStaff(Staff staff) {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/AZS", "postgres", "qwerty1");
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE \"AZS\".\"Staff\" SET surname = ?, name = ?, gender = ?, function = ?, salary = ? WHERE staff_id = ?");
                ps.setString(1, staff.getSurname());
                ps.setString(2, staff.getName());
                ps.setString(3, staff.getGender());
                ps.setString(4, staff.getFunction());
                ps.setInt(5, staff.getSalary());
                ps.setInt(6, staff.getStaffId());
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
