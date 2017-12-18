package ru.housemanagement.model;

public class Coldwatercounter {
    private int vol;
    private int flatnumber;

    public Coldwatercounter() {
    }

    public Coldwatercounter(int vol, int flatnumber) {
        this.vol = vol;
        this.flatnumber = flatnumber;
    }

    public int getVol() {
        return vol;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }

    public int getFlatnumber() {
        return flatnumber;
    }

    public void setFlatnumber(int flatnumber) {
        this.flatnumber = flatnumber;
    }
}
