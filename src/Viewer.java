import java.util.Objects;
class Viewer extends Person {
    private int age;

    public Viewer(String name, int age) {
        super(name);
        this.age = age;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public void display() {
        System.out.println("Viewer: " + name + ", Age: " + age);
    }

    public String toString() {
        return "Viewer [Name: " + name + ", Age: " + age + "]";
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Viewer viewer = (Viewer) obj;
        return age == viewer.age && name.equals(viewer.name);
    }

    public int hashCode() {
        return Objects.hash(name, age);
    }
}