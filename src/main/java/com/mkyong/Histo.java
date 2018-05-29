package com.mkyong;

public class Histo {

  private String Phonename;
  private String Date;
  private String Laditude;
  private String Longitude;

    public Histo(String phonename, String date, String laditude, String longitude) {
        Phonename = phonename;
        Date = date;
        Laditude = laditude;
        Longitude = longitude;
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
