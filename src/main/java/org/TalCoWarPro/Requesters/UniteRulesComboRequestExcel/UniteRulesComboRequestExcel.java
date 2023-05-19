package org.TalCoWarPro.Requesters.UniteRulesComboRequestExcel;

import org.TalCoWarPro.Objects.DivisionRules.DivisionRules;
import org.TalCoWarPro.Objects.UniteDescriptor.UniteDescriptor;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class UniteRulesComboRequestExcel {
    ArrayList<DivisionRules> divisionRulesList;
    ArrayList<UniteDescriptor> uniteDescriptorList;
    DataFormatter formatter;
    int referenceId;
    String descriptorDeck;
    String uniteDescriptor;
    int numberOfUnitInPack;
    int unitCost;

    public UniteRulesComboRequestExcel(ArrayList<DivisionRules> divisionRulesList, ArrayList<UniteDescriptor> uniteDescriptorList){
        this.divisionRulesList = divisionRulesList;
        this.uniteDescriptorList = uniteDescriptorList;
    }


    public ArrayList<UniteDescriptor> readUniteDescriptorExcel() {

        try {

            FileInputStream fis = new FileInputStream("Output\\ComboUniteRulesExcel.xlsx");
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fis);
            XSSFSheet xssfSheet = xssfWorkbook.getSheet("Combo Unite Rules");
            unloadSheet(xssfSheet);
            xssfWorkbook.close();
            fis.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return uniteDescriptorList;
    }

    public ArrayList<DivisionRules> readDivisionRulesExcel() {

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
                numberOfUnitInPack = Integer.parseInt(formatter.formatCellValue(row.getCell(3)));
                unitCost = Integer.parseInt(formatter.formatCellValue(row.getCell(4)));
                for(UniteDescriptor d : uniteDescriptorList) {
                    if(d.getDescriptor() != null && d.getDescriptor().contains(uniteDescriptor)){
                        if(d.getIsEdited() == null || !d.getIsEdited()){
                            d.setCommandPoints(String.valueOf(unitCost));
                            d.setIsEdited(true);
                        }
                    }
                }
                for(DivisionRules d : divisionRulesList) {
                    if(d.getDescriptorDeck() != null && d.getDescriptorDeck().contains(descriptorDeck)){
                        if(d.getUniteDescriptor() != null && d.getUniteDescriptor().contains(uniteDescriptor)){
                            if(d.getIsEdited() == null || !d.getIsEdited()){
                                d.setNumberOfUnitInPack(numberOfUnitInPack);
                                d.setIsEdited(true);
                            }
                        }
                    }
                }

            }catch (NumberFormatException nfe) {
                System.out.println(nfe.getMessage());
            }
        }
    }
}
