package com.miguelApi.tracker.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.miguelApi.tracker.components.ExcelGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrinterService {

    @Autowired
    private ExcelGenerator excelGenerator;


    public void printNodes(JsonNode dataNode,String sport){
        excelGenerator.start();
        excelGenerator.printAllMatches(dataNode);
        excelGenerator.close(sport);

    }

}
