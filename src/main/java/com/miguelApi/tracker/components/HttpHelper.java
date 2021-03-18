package com.miguelApi.tracker.components;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class HttpHelper {

    private static final String apiKey = "b3aef1ecc7fb4d9874401208e8c9f6d9";
    private static final String apiEndPoint = "https://api.the-odds-api.com/v3/odds?apiKey=";


    public URL parseUrl(String region, String mkt, String sport) throws MalformedURLException {

        URL url = new URL(apiEndPoint
                + apiKey
                + "&region="
                + region
                + "&mkt="
                + mkt
                + "&sport="
                + sport);

        return url;

    }

    public InputStream responseStream(URL url) throws IOException {


        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestProperty("accept", "application/json");

        InputStream responseStream = connection.getInputStream();

        return responseStream;
    }
}
