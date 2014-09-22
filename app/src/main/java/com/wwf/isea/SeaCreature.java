package com.wwf.isea;

/**
 * Created by dragos on 9/22/14.
 */
public class SeaCreature {

    private String imagePath;
    private String name;
    private String description;
    private int id;

    public SeaCreature(){}

    public SeaCreature(int id,String name, String description, String imagePath){
        this.description=description;
        this.imagePath=imagePath;
        this.name=name;
        this.id=id;

    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
