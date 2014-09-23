package com.wwf.isea;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

/**
 * Created by dragos on 9/22/14.
 */
public class SeaCreature implements Parcelable,ClusterItem {

    private int imagePath;
    private String name;
    private String description;
    private int id;
    private String category;
    private LatLng mPosition;
    private double lat;
    private double lng;

    public SeaCreature(){}

    public SeaCreature(int id,String name, String description, int imagePath,String category,double lat,double lng){
        this.description=description;
        this.imagePath=imagePath;
        this.name=name;
        this.id=id;
        this.category=category;
        this.lat=lat;
        mPosition=new LatLng(lat,lng);

    }

    public double getLat() { return lat; }

    public void setLat(double lat) { this.lat=lat; }

    public double getLng() { return lng; }

    public void setLng(double lng) { this.lng=lng; }

    public int getImagePath() {
        return imagePath;
    }

    public void setImagePath(int imagePath) {
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

    @Override
    public LatLng getPosition() {
        return mPosition;
    }



    //PARCELABLE
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(category);
        parcel.writeInt(imagePath);
        parcel.writeInt(id);
        parcel.writeDouble(lat);
        parcel.writeDouble(lng);
    }

    public SeaCreature(Parcel in)
    {
        readFromParcel(in);

    }
    @SuppressWarnings("rawtypes")
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public SeaCreature createFromParcel(Parcel in)
        {
            return new SeaCreature(in);
        }

        public SeaCreature[] newArray(int size)
        {
            return new SeaCreature[size];
        }

    };

    public void readFromParcel(Parcel in)
    {
        name = in.readString();
        description=in.readString();
        category= in.readString();
        imagePath=in.readInt();
        id=in.readInt();
        lat=in.readDouble();
        lng=in.readDouble();

    }
}
