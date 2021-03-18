package com.miguelApi.tracker.components;

import com.fasterxml.jackson.databind.JsonNode;
import com.miguelApi.tracker.models.Bet;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;

@Component
public class ExcelGenerator {

    private CellStyle style;
    private Sheet sheet;
    private Workbook workbook;
    private int rowCounter;


    public Sheet start() {

        workbook = new XSSFWorkbook();

        sheet = workbook.createSheet("Bets");
        sheet.setColumnWidth(0, 6000);
        sheet.setColumnWidth(1, 4000);

        Row header = sheet.createRow(0);
        rowCounter = 1;

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 16);
        font.setBold(true);
        headerStyle.setFont(font);

        Cell headerCell = header.createCell(0);
        headerCell.setCellValue("site_key");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(1);
        headerCell.setCellValue("odds");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(2);
        headerCell.setCellValue("position");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(3);
        headerCell.setCellValue("points");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(4);
        headerCell.setCellValue("Team A");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(5);
        headerCell.setCellValue("Team B");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(6);
        headerCell.setCellValue("Home Team");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(7);
        headerCell.setCellValue("Game Id");
        headerCell.setCellStyle(headerStyle);

        style = workbook.createCellStyle();
        style.setWrapText(true);

        return sheet;
    }

    public void printAllMatches(JsonNode dataNode){
        for (int i = 0; i < dataNode.size(); i++) {

            LinkedList<Bet> bets = new LinkedList<>();
            JsonNode sitesNode = dataNode.get(i).get("sites");

            for (int j = 0; j < sitesNode.size(); j++) {

                String site_key = sitesNode.get(j).get("site_key").asText();

                JsonNode oddsNode = sitesNode.get(j);

                JsonNode totals = oddsNode.get("odds");
                JsonNode tot = totals.get("totals");

                String odds = tot.get("odds").toString();
                String position = tot.get("position").toString();
                String points = tot.get("points").toString();

                String teamA = dataNode.get(i).get("teams").get(0).toString();
                String teamB = dataNode.get(i).get("teams").get(1).toString();

                String homeTeam = dataNode.get(i).get("home_team").toString();
                String gameId = dataNode.get(i).get("id").toString();
                printMatch(site_key, odds, position, points, teamA, teamB, homeTeam, gameId);
            }

        }
    }

    public void printMatch(String site_key, String odds, String position, String points, String teamA, String teamB, String homeTeam, String gameId) {

        Row row = sheet.createRow(rowCounter);

        Cell cell = row.createCell(0);
        cell.setCellValue(site_key);
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue(odds);
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue(position);
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue(points);
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellValue(teamA);
        cell.setCellStyle(style);

        cell = row.createCell(5);
        cell.setCellValue(teamB);
        cell.setCellStyle(style);

        cell = row.createCell(6);
        cell.setCellValue(homeTeam);
        cell.setCellStyle(style);

        cell = row.createCell(7);
        cell.setCellValue(gameId);
        cell.setCellStyle(style);
        rowCounter++;

    }

    public void close(String sport) {
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) +sport+ "_bets.xlsx";

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(fileLocation);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
