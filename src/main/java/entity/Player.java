package main.java.entity;

public class Player {

    private long id;
    private String name;
    private String position;
    private int age;
    private int shirtNumber;

    public Player(long id, String name, String position, int age, int shirtNumber) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.age = age;
        this.shirtNumber = shirtNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }
}
