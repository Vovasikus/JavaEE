package ru.housemanagement.model;

public class Metric {
    private int id;
    private String owner;
    private int vol;
    private String timeoffilling;


    public Metric() {
    }

    public Metric(int vol) {
    }

    public Metric(int id, String owner, int vol, String timeoffilling) {
        this.id = id;
        this.vol = vol;
        this.owner = owner;
        this.timeoffilling = timeoffilling;
    }

    public Metric(String owner, int vol) {
        this.owner = owner;
        this.vol = vol;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVol() {
        return vol;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }

    public String getTimeoffilling() {
        return timeoffilling;
    }

    public void setTimeoffilling(String timeoffilling) {
        this.timeoffilling = timeoffilling;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Metric{" +
                "owner='" + owner + '\'' +
                ", vol='" + vol + '\'' +
                '}';
    }
}
