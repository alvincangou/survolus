package com.mkyong;

public class Histo {

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    private Long Id;
  private String Phonename;
  private String Date;
  private String Laditude;
  private String Longitude;

    public Histo(Long id ,String phonename, String date, String laditude, String longitude) {
        Phonename = phonename;
        Date = date;
        Laditude = laditude;
        Longitude = longitude;
        Id = id;
    }

    public String getPhonename() {
        return Phonename;
    }

    public void setPhonename(String phonename) {
        Phonename = phonename;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getLaditude() {
        return Laditude;
    }

    public void setLaditude(String laditude) {
        Laditude = laditude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }
}
