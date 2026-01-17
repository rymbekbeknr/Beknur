import java.sql.*;

public class ViewerDAO {
    private Connection conn;

    public ViewerDAO(Connection conn) {
        this.conn = conn;
    }

    public void addViewer(String name, int age) throws SQLException {
        String sql = "INSERT INTO Viewer (name, age) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.executeUpdate();
            System.out.println(" Viewer added.");
        }
    }

    public void showAllViewers() throws SQLException {
        String sql = "SELECT * FROM Viewer";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- LIST OF VIEWERS ---");
            while (rs.next()) {
                System.out.printf("ID: %d | Name: %s | Age: %d\n",
                        rs.getInt("id"), rs.getString("name"), rs.getInt("age"));
            }
        }
    }

    public void updateViewer(int id, int newAge) throws SQLException {
        String sql = "UPDATE Viewer SET age = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, newAge);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println(" Viewer age updated.");
        }
    }

    public void deleteViewer(int id) throws SQLException {
        String sql = "DELETE FROM Viewer WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println(" Viewer deleted.");
        }
    }
}
