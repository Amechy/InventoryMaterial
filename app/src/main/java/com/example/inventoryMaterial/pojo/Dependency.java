package com.example.inventoryMaterial.pojo;

import android.support.annotation.NonNull;

import java.util.Comparator;

/**
 * Created by usuario on 25/10/17.
 * @author Alejandro Mechiné
 * Clase que emula una dependencia en la vida real. Almacenando los campos que contiene. A partir
 * de él crearemos las distintas dependencia.
 */

public class Dependency implements Comparable{
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

    @Override
    public int compareTo(@NonNull Object o) {
        return name.compareTo(((Dependency)o).getName());
    }

    public static class DependenctOrderByShortName implements Comparator<Dependency>{

        @Override
        public int compare(Dependency d1, Dependency d2) {
            return d1.getShortname().compareTo(d2.getShortname());
        }
    }
}
