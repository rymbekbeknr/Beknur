public class Main {
    public static void main(String[] args) {

        Film film1 = new Film("Interstellar", "Sci-Fi", 169);
        Film film2 = new Film("Whiplash", "Drama", 106);

        Viewer viewer = new Viewer("Aruzhan");
        Cinema cinema = new Cinema("Astana Cinema");

        film1.display();
        film2.display();
        viewer.display();
        cinema.display();

        if (film1.getDuration() > film2.getDuration()) {
            System.out.println("Film1 is longer than Film2");
        } else {
            System.out.println("Film2 is longer or equal to Film1");
        }
    }
}
