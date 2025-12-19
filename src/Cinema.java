public class Cinema {
    private String name;

    public Cinema(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public void display() {
        System.out.println("Cinema: " + name);
    }
}
