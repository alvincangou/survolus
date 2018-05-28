package com.mkyong.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Triggered {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Longitude;
    private String Laditude;
    private Date Date;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="idmodule")
    private Module module;

    public Triggered(String longitude, String laditude, java.util.Date date, Module module) {
        Longitude = longitude;
        Laditude = laditude;
        Date = date;
        this.module = module;
    }

    public Triggered() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getLaditude() {
        return Laditude;
    }

    public void setLaditude(String laditude) {
        Laditude = laditude;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
