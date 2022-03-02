package com.ipiecoles.java.mdd324.homepage;


public class Meteo {

    private String coucher;
    private Long humidite;
    private Long icon;
    private String lever;
    private Double temp;
    private String temps;

    public Meteo(String coucher, Long humidite, Long icon, String lever, Double temp, String temps) {
        this.coucher = coucher;
        this.humidite = humidite;
        this.icon = icon;
        this.lever = lever;
        this.temp = temp;
        this.temps = temps;
    }


    public String getCoucher() {
        return coucher;
    }

    public void setCoucher(String coucher) {
        this.coucher = coucher;
    }

    public Long getHumidite() {
        return humidite;
    }

    public void setHumidite(Long humidite) {
        this.humidite = humidite;
    }

    public Long getIcon() {
        return icon;
    }

    public void setIcon(Long icon) {
        this.icon = icon;
    }

    public String getLever() {
        return lever;
    }

    public void setLever(String lever) {
        this.lever = lever;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public String getTemps() {
        return temps;
    }

    public void setTemps(String temps) {
        this.temps = temps;
    }
}
