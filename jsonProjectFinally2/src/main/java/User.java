public class User {
    String name;
    int age;

    public String toString() {
        return "User{name='" + this.name + "', age=" + this.age + "}";
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}