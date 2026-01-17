import java.sql.*;

public class CinemaDAO {
    private Connection conn;

    public CinemaDAO(Connection conn) {
        this.conn = conn;
    }

    public void addCinema(String name, String city) throws SQLException {
        String sql = "INSERT INTO Cinema (name, city) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, city);
            pstmt.executeUpdate();
            System.out.println(" Cinema added.");
        }
    }

    public void showAllCinemas() throws SQLException {
        String sql = "SELECT * FROM Cinema";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- LIST OF CINEMAS ---");
            while (rs.next()) {
                System.out.printf("ID: %d | Name: %s | City: %s\n",
                        rs.getInt("id"), rs.getString("name"), rs.getString("city"));
            }
        }
    }

    public void updateCinema(int id, String newCity) throws SQLException {
        String sql = "UPDATE Cinema SET city = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newCity);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println(" Cinema city updated.");
        }
    }

    public void deleteCinema(int id) throws SQLException {
        String sql = "DELETE FROM Cinema WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println(" Cinema deleted.");
        }
    }
}