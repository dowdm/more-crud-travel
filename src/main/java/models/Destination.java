package models;
import java.util.ArrayList;

public class Destination {
    private String country;
    private String cityArea;
    private String date;
    private String reason;
    private String picture;
    private String highlights;
    private static ArrayList<Destination> instances = new ArrayList<>();
    private int id;


    public Destination(String country, String cityArea, String date, String reason, String picture, String highlights ){
        this.country = country;
        this.cityArea = cityArea;
        this.date = date;
        this.reason = reason;
        this. picture = picture;
        this.highlights = highlights;
        instances.add(this);
        this.id = instances.size();
    }

    public String getCountry() {
        return country;
    }

    public String getCityArea() {
        return cityArea;
    }

    public String getDate() {
        return date;
    }

    public String getReason() {
        return reason;
    }

    public String getPicture() {
        return picture;
    }

    public String getHighlights() {
        return highlights;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCityArea(String cityArea) {
        this.cityArea = cityArea;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setHighlights(String highlights) {
        this.highlights = highlights;
    }

    public static ArrayList<Destination> getAll() {
        return instances;
    }
    public static void clearAll(){
        instances.clear();
    }

    public int getId() {
        return id;
    }

    public static Destination findById(int id){
        return instances.get(id-1);
    }


}
