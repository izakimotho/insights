package com.lunna.insight.Models.DTO.Profile;

public class Permissions {


    private String permission;
    private boolean value = false;

    public Permissions() {

    }

    public Permissions(String permission, boolean value) {
        this.permission = permission;
        this.value = value;
    }

    public Permissions(String permission) {
        this.permission = permission;
        this.value = true;
    }

    /**
     * @return the permission
     */
    public String getPermission() {
        return permission;
    }

    /**
     * @param permission the permission to set
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * @return the value
     */
    public boolean isValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permissions that = (Permissions) o;

        return getPermission() != null ? getPermission().equals(that.getPermission()) : that.getPermission() == null;

    }

    @Override
    public int hashCode() {
        return getPermission() != null ? getPermission().hashCode() : 0;
    }
}
