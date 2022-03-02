package com.ipiecoles.java.mdd324.homepage.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.StringJoiner;

public class Utils {

    /**
     * Méthode permettant de récupérer sous forme d'une String le contenu situé à une URL
     * @param address URL à aller consulter
     * @return le contenu situé à l'adresse
     * @throws IOException si impossible d'aller chercher le contenu situé à l'adresse indiquée
     */
    public static String getPageContents(String address) throws IOException {
        BufferedReader br = null;
        StringJoiner lines = new StringJoiner(System.lineSeparator());

        try {
            URL url = new URL(address);
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return lines.toString();

    }
}
