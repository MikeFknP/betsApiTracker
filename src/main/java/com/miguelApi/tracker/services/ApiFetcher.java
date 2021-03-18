package com.miguelApi.tracker.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.miguelApi.tracker.components.HttpHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import static com.miguelApi.tracker.components.UtilParser.parseInputStream;

@Service
public class ApiFetcher {

    @Autowired
    private HttpHelper httpHelper;


    public JsonNode getApiResults(String sport, String region, String mkt) throws IOException {
        URL url = httpHelper.parseUrl(region, mkt, sport);
        InputStream stream = httpHelper.responseStream(url);
        JsonNode node = parseInputStream(stream);
        JsonNode dataNode = node.at("/data");
        return dataNode;
    }

}
