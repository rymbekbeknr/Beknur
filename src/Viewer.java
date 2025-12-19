public class Viewer {
    private String name;

    public Viewer(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public void display() {
        System.out.println("Viewer: " + name);
    }
}