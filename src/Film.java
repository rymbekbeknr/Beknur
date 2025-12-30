import java.util.Objects;

public class Film {
    private String title;
    private String genre;
    private int duration;

    public Film(String title, String genre, int duration) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public void display() {
        System.out.println("Film: " + title + ", " + genre + ", " + duration + " min");
    }

    public String toString() {
        return "Film [Title: " + title + ", Genre: " + genre + ", Duration: " + duration + " minutes]";
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Film film = (Film) obj;
        return duration == film.duration && title.equals(film.title) && genre.equals(film.genre);
    }

    public int hashCode() {
        return Objects.hash(title, genre, duration);
    }
}