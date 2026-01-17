import java.sql.*;

public class FilmDAO {
    private Connection conn;

    public FilmDAO(Connection conn) {
        this.conn = conn;
    }

    public void addFilm(String title, String genre, int duration) throws SQLException {
        String sql = "INSERT INTO Film (title, genre, duration) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, genre);
            pstmt.setInt(3, duration);
            pstmt.executeUpdate();
            System.out.println(" Movie added successfully.");
        }
    }

    public void showAllFilms() throws SQLException {
        String sql = "SELECT * FROM Film";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- LIST OF FILMS ---");
            while (rs.next()) {
                System.out.printf("ID: %d | %s [%s] | %d min\n",
                        rs.getInt("id"), rs.getString("title"), rs.getString("genre"), rs.getInt("duration"));
            }
        }
    }

    public void updateFilm(int id, String newTitle, int newDuration) throws SQLException {
        String sql = "UPDATE Film SET title = ?, duration = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newTitle);
            pstmt.setInt(2, newDuration);
            pstmt.setInt(3, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println(" Movie updated.");
            else System.out.println(" ID not found.");
        }
    }

    public void deleteFilm(int id) throws SQLException {
        String sql = "DELETE FROM Film WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println(" Movie deleted.");
        }
    }
}