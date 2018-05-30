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


    public Destination(String country, String cityArea, String date, String reason, String picture, String highlights ){
        this.country = country;
        this.cityArea = cityArea;
        this.date = date;
        this.reason = reason;
        this. picture = picture;
        this.highlights = highlights;
        instances.add(this);
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

    public static ArrayList<Destination> getAll() {
        return instances;
    }
    public static void clearAll(){
        instances.clear();
    }
}
