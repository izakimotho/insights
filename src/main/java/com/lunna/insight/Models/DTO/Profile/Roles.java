package com.lunna.insight.Models.DTO.Profile;

public class Roles {
    private int id = 0;
    private String name = "";
    private boolean active = false;

    public Roles() {
    }

    public Roles(int id, String name, boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object object) {
        boolean same = false;
        if (object != null && object instanceof Roles) {
            same = this.getId() == ((Roles) object).getId();
        }
        return same;
    }
}