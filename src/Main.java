import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Connection conn = DBConnection.getConnection()) {
            FilmDAO filmDAO = new FilmDAO(conn);
            CinemaDAO cinemaDAO = new CinemaDAO(conn);
            ViewerDAO viewerDAO = new ViewerDAO(conn);

            while (true) {
                System.out.println("\n--- MAIN MENU ---");
                System.out.println("1. Manage Films");
                System.out.println("2. Manage Cinemas");
                System.out.println("3. Manage Viewers");
                System.out.println("0. Exit");
                System.out.print("Select category: ");

                int mainChoice = scanner.nextInt();
                scanner.nextLine();

                if (mainChoice == 0) break;

                System.out.println("\n1. Add | 2. Show All | 3. Update | 4. Delete | 0. Back");
                System.out.print("Select action: ");
                int action = scanner.nextInt();
                scanner.nextLine();

                if (action == 0) continue;

                switch (mainChoice) {
                    case 1:
                        handleFilmActions(action, filmDAO, scanner);
                        break;

                    case 2:
                        handleCinemaActions(action, cinemaDAO, scanner);
                        break;

                    case 3:
                        handleViewerActions(action, viewerDAO, scanner);
                        break;

                    default:
                        System.out.println("Invalid category!");
                }
            }
        } catch (SQLException e) {
            System.err.println(" Database error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void handleFilmActions(int action, FilmDAO dao, Scanner sc) throws SQLException {
        if (action == 1) {
            System.out.print("Title: "); String t = sc.nextLine();
            System.out.print("Genre: "); String g = sc.nextLine();
            System.out.print("Duration: "); int d = sc.nextInt();
            dao.addFilm(t, g, d);
        } else if (action == 2) {
            dao.showAllFilms();
        } else if (action == 3) {
            System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
            System.out.print("New Title: "); String nt = sc.nextLine();
            System.out.print("New Dur: "); int nd = sc.nextInt();
            dao.updateFilm(id, nt, nd);
        } else if (action == 4) {
            System.out.print("ID to delete: "); int id = sc.nextInt();
            dao.deleteFilm(id);
        }
    }

    private static void handleCinemaActions(int action, CinemaDAO dao, Scanner sc) throws SQLException {
        if (action == 1) {
            System.out.print("Cinema Name: "); String n = sc.nextLine();
            System.out.print("City: "); String c = sc.nextLine();
            dao.addCinema(n, c);
        } else if (action == 2) {
            dao.showAllCinemas();
        } else if (action == 3) {
            System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
            System.out.print("New City: "); String nc = sc.nextLine();
            dao.updateCinema(id, nc);
        } else if (action == 4) {
            System.out.print("ID to delete: "); int id = sc.nextInt();
            dao.deleteCinema(id);
        }
    }

    private static void handleViewerActions(int action, ViewerDAO dao, Scanner sc) throws SQLException {
        if (action == 1) {
            System.out.print("Name: "); String n = sc.nextLine();
            System.out.print("Age: "); int a = sc.nextInt();
            dao.addViewer(n, a);
        } else if (action == 2) {
            dao.showAllViewers();
        } else if (action == 3) {
            System.out.print("ID: "); int id = sc.nextInt();
            System.out.print("New Age: "); int na = sc.nextInt();
            dao.updateViewer(id, na);
        } else if (action == 4) {
            System.out.print("ID to delete: "); int id = sc.nextInt();
            dao.deleteViewer(id);
        }
    }
}