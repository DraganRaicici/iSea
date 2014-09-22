package com.wwf.isea;

/**
 * Created by dragos on 9/22/14.
 */
public class SeaCreature {

    private String imagePath;
    private String name;
    private String description;
    private int id;
    private String category;

    public SeaCreature(){}

    public SeaCreature(int id,String name, String description, String imagePath,String category){
        this.description=description;
        this.imagePath=imagePath;
        this.name=name;
        this.id=id;
        this.category=category;

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
    public String getCategory(){
        return  category;
    }
    public void setCategory(String category){
        this.category=category;
    }
}
