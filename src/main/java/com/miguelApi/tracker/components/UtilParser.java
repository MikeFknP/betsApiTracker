package com.miguelApi.tracker.components;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;


@Component
public class UtilParser {

    public static JsonNode parseInputStream(InputStream stream) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonNode = mapper.readTree(stream);

        return jsonNode;
    }

    public static float[] parseOddsToFloat(String oddsString){

        String[] stringValues = oddsString.split(",");
        String firstOdd = stringValues[0].substring(1,stringValues[0].length());
        String secondOdd = stringValues[1].substring(0,stringValues[1].length()-1);

        float[] odds = {Float.parseFloat(firstOdd),Float.parseFloat(secondOdd)};

        return odds;
    }




}
