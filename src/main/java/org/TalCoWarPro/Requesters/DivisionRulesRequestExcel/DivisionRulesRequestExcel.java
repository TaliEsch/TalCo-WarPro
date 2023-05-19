package org.TalCoWarPro.Requesters.DivisionRulesRequestExcel;

import org.TalCoWarPro.Objects.DivisionRules.DivisionRules;
import org.TalCoWarPro.Objects.UniteDescriptor.UniteDescriptor;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;

public class DivisionRulesRequestExcel {
    ArrayList<DivisionRules> divisionRulesList;
    DataFormatter formatter;
    int referenceId;
    String descriptorDeck;
    String uniteDescriptor;
    boolean availableWithoutTransport;
    String availableTransportList;
    int numberOfUnitInPack;
    String numberOfUnitInPackXPMultiplier;

    public ArrayList<DivisionRules> readDivisionRulesExcel() {
        divisionRulesList = new ArrayList<>();

        try {

            FileInputStream fis = new FileInputStream("Output\\DivisionRulesExcel.xlsx");
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fis);
            XSSFSheet xssfSheet = xssfWorkbook.getSheet("Division Rules");
            unloadSheet(xssfSheet);
            xssfWorkbook.close();
            fis.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return divisionRulesList;
    }

    private void unloadSheet(XSSFSheet sheet) {
        int rows = sheet.getLastRowNum();

        formatter = new DataFormatter();

        for (int r = 1; r <= rows; r++) {
            XSSFRow row = sheet.getRow(r);

            try {
                referenceId = Integer.parseInt(formatter.formatCellValue(row.getCell(0)));
                descriptorDeck = formatter.formatCellValue(row.getCell(1));
                uniteDescriptor = formatter.formatCellValue(row.getCell(2));
                availableWithoutTransport = Boolean.parseBoolean(formatter.formatCellValue(row.getCell(3)));
                availableTransportList = formatter.formatCellValue(row.getCell(4));
                numberOfUnitInPack = Integer.parseInt(formatter.formatCellValue(row.getCell(5)));
                numberOfUnitInPackXPMultiplier = formatter.formatCellValue(row.getCell(6));
                DivisionRules divisionRule = new DivisionRules(referenceId, descriptorDeck, uniteDescriptor, availableWithoutTransport,
                        availableTransportList, numberOfUnitInPack, numberOfUnitInPackXPMultiplier);
                divisionRulesList.add(divisionRule);

            }catch (NumberFormatException nfe) {
                System.out.println(nfe.getMessage());
            }
        }
    }
}
