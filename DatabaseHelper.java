import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;
import java.sql.ResultSetMetaData;

public class DatabaseHelper {
    private static final String URL = "jdbc:sqlite:pharmacydb.sqlite";

    public static void saveItemToDatabase(Item item) {
        String sql = "INSERT INTO items (id, name, price, quantity) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(URL)) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, item.getId());
                pstmt.setString(2, item.getName());
                pstmt.setDouble(3, item.getPrice());
                pstmt.setInt(4, item.getQuantity());
                
                pstmt.executeUpdate();
                System.out.println("Item saved to database.");
            }
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
    }
    
    public static void displayDatabaseMetadata() {
        try (Connection conn = DriverManager.getConnection(URL)) {
            DatabaseMetaData meta = conn.getMetaData();
            System.out.println("Database Product Name: " + meta.getDatabaseProductName());
            System.out.println("JDBC Driver Name: " + meta.getDriverName());
            
            try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM items");
                 ResultSet rs = pstmt.executeQuery()) {
                 
                ResultSetMetaData rsMeta = rs.getMetaData();
                System.out.println("Columns in items table: " + rsMeta.getColumnCount());
            }
        } catch (SQLException e) {
            System.out.println("Failed to retrieve metadata.");
        }
    }
}
