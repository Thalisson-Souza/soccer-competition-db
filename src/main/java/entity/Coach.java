package main.java.entity;

public class Coach {

   private long id;
   private String name;

    public Coach(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Coach() {

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
}
