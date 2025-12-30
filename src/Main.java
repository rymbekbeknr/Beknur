import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Film film1 = new Film("Interstellar", "Sci-Fi", 169);
        Film film2 = new Film("Whiplash", "Drama", 106);

        Viewer viewer1 = new Viewer("Aruzhan", 25);
        Viewer viewer2 = new Viewer("Dmitriy", 30);

        Cinema cinema = new Cinema("Astana Cinema", "Astana");

        film1.display();
        film2.display();
        viewer1.display();
        viewer2.display();
        cinema.display();

        List<Film> films = new ArrayList<>();
        films.add(film1);
        films.add(film2);

        films.sort(Comparator.comparingInt(Film::getDuration));
        System.out.println("\nSorted Films by Duration:");
        for (Film film : films) {
            System.out.println(film);
        }

        System.out.println("\nFiltered Films by Genre 'Sci-Fi':");
        for (Film film : films) {
            if (film.getGenre().equals("Sci-Fi")) {
                System.out.println(film);
            }
        }
    }
}

