package com.ipiecoles.java.mdd324.homepage;

import com.ipiecoles.java.mdd324.homepage.utils.Utils;
import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
       String meteo =  Utils.getPageContents(" https://api.openweathermap.org/data/2.5/weather?q=Paris&appid=5dfc2a06c8157403e9107053a73aca92&lang=fr&main.temp=Celsius");
       System.out.println(meteo);

       String coucher;
       Long humidite;
       Long icon;
       String lever;
       Double temp;
       String temps;

        Genson genson = new GensonBuilder().useRuntimeType(true).create();
        Map<String, Object> map = genson.deserialize(meteo, Map.class);


        //lever du soleil
        HashMap<String, Object> sys = (HashMap<String, Object>) map.get("sys");
        Long sunriseInt = (Long) sys.get("sunrise");

        sunriseInt = sunriseInt * 1000;

        Date sunrise = new Date(sunriseInt);

        SimpleDateFormat df = new SimpleDateFormat("HH:mm");

        String sunriseheure = df.format(sunrise);

        lever = sunriseheure;


        //coucher du soleil
        Long sunsetInt = (Long) sys.get("sunset");

        sunsetInt = sunsetInt * 1000;

        Date sunset = new Date(sunsetInt);

        String sunsetheure = df.format(sunset);

        coucher = sunsetheure;


        //humidité
        HashMap<String, Object> humidity = (HashMap<String, Object>) map.get("main");
        Long humidityInt = (Long) humidity.get("humidity");

        humidite = humidityInt;


        //icon
        ArrayList icons = (ArrayList) map.get("weather");
        HashMap<String, Object> icones = (HashMap<String, Object>) icons.get(0);
        Long iconInt = (Long) icones.get("id");

        icon = iconInt;


        //temp
        HashMap<String, Object> temp1 = (HashMap<String, Object>) map.get("main");
        Double tempInt = (Double) temp1.get("temp");

        tempInt = tempInt - 273d;

        tempInt = Math.round(tempInt * 10d) / 10d;

        temp = tempInt;


        //temps description
        String temps1 = (String) icones.get("description");

        temps = temps1;

        Meteo meteos = new Meteo(coucher,humidite, icon, lever, temp, temps);


        //Tout afficher en Json
        String jsonOutput = genson.serialize(meteo);
        System.out.println(jsonOutput);
    }

}
