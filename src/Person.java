abstract class Person {
    protected String name;
    public Person(String name) {
        this.name = name;
    }
    public abstract void display();
    public String toString() {
        return "Name: " + name;
    }
}