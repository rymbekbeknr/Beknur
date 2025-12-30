import java.util.Objects;

class Cinema {
    private String name;
    private String city;

    public Cinema(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public void display() {
        System.out.println("Cinema: " + name + ", City: " + city);
    }

    public String toString() {
        return "Cinema [Name: " + name + ", City: " + city + "]";
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cinema cinema = (Cinema) obj;
        return name.equals(cinema.name) && city.equals(cinema.city);
    }

    public int hashCode() {
        return Objects.hash(name, city);
    }
}