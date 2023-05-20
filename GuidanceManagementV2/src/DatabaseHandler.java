/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author pc
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class DatabaseHandler {

    private Connection conn;

    public void connect(String url, String user, String password) throws SQLException {
        conn = DriverManager.getConnection(url, user, password);
    }

    public void disconnect() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    
    public DefaultTableModel getData(String student) throws SQLException {
        String query = "SELECT * FROM " + student;
        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();

        // Create a DefaultTableModel with the column names
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Grade");
        model.addColumn("Section");
        model.addColumn("Strand");
        

        // Add the rows from the ResultSet to the model
        while (rs.next()) {
            String name = rs.getString("Name");
            String grade = rs.getString("Grade");
            String section = rs.getString("Section");
            String strand = rs.getString("Strand");
            model.addRow(new Object[]{name, grade, section, strand});
        }

        // Close the ResultSet and PreparedStatement
        rs.close();
        pstmt.close();

        return model;
    }
}
