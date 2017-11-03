package com.example.inventoryMaterial.pojo;

/**
 * Created by usuario on 25/10/17.
 * @author Alejandro Mechiné
 * Clase que emula una dependencia en la vida real. Almacenando los campos que contiene. A partir
 * de él crearemos las distintas dependencia.
 */

public class Dependency {
    private int _ID;
    private String name;
    private String shortname;
    private String description;

    public Dependency(int id, String name, String shortname, String description) {
        _ID = id;
        this.name = name;
        this.shortname = shortname;
        this.description = description;
    }

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return shortname;
    }
}
