
package com.lunna.insight.Models.DTO.Common;


public class City {
    private int id = 0;
    private int countryID = 0;
    private String name = "";
    private boolean active = false;

    public City() {
    }

    public City(int id) {
        this.id = id;
    }

    public City(int id, int countryID, String name, boolean active) {
        this.id = id;
        this.countryID = countryID;
        this.name = name;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
