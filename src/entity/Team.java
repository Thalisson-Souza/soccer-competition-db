package entity;

import java.time.LocalDate;

public class Team {

    private long id;
    private String name;
    private String estadium;
    private String city;
    private LocalDate dateFundation;

   public Team() {
   }

    public Team(long id, String name, String estadium, String city, LocalDate dateFundation) {
        this.id = id;
        this.name = name;
        this.estadium = estadium;
        this.city = city;
        this.dateFundation = dateFundation;
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

    public String getEstadium() {
        return estadium;
    }

    public void setEstadium(String estadium) {
        this.estadium = estadium;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getDateFundation() {
        return dateFundation;
    }

    public void setDateFundation(LocalDate dateFundation) {
        this.dateFundation = dateFundation;
    }
}
