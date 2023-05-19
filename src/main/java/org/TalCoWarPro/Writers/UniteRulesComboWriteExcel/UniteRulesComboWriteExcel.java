package org.TalCoWarPro.Writers.UniteRulesComboWriteExcel;

import org.TalCoWarPro.Objects.DivisionRules.DivisionRules;
import org.TalCoWarPro.Objects.UniteDescriptor.UniteDescriptor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class UniteRulesComboWriteExcel {

    String excelDivisionRulesPath = "Output\\ComboUniteRulesExcel.xlsx";
    ArrayList<DivisionRules> divisionRulesList;
    ArrayList<UniteDescriptor> uniteDescriptorList;

    public UniteRulesComboWriteExcel(ArrayList<DivisionRules> divisionRulesList,
                                          ArrayList<UniteDescriptor> uniteDescriptorList,
                                     String excelDivisionRulesPath){
        this.divisionRulesList = divisionRulesList;
        this.uniteDescriptorList = uniteDescriptorList;
        this.excelDivisionRulesPath = excelDivisionRulesPath;
    }

    public void writeToExcel(){
        try {
            File yourFile = new File("Output\\");
            if (!yourFile.exists()) {
                yourFile.mkdirs();
            }
            try {
                XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
                XSSFSheet xssfSheet = xssfWorkbook.createSheet("Combo Unite Rules");
                writeHeaderLine(xssfSheet);
                writeDataLines(xssfSheet);
                FileOutputStream outputStream = new FileOutputStream(excelDivisionRulesPath);
                xssfWorkbook.write(outputStream);
                xssfWorkbook.close();
                outputStream.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void writeHeaderLine(XSSFSheet sheet) {
        XSSFRow headerRow = sheet.createRow(0);

        XSSFCell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("Reference ID");

        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("Deck Descriptor");

        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("Unit Descriptor");

        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("Availability");

        headerCell = headerRow.createCell(4);
        headerCell.setCellValue("Unit Cost");
    }

    private void writeDataLines(XSSFSheet sheet) {
        int rowCount = 1;

        for (DivisionRules divisionRule : divisionRulesList) {
            int columnCount = 0;

            Row row = sheet.createRow(rowCount++);
            Cell cell = row.createCell(columnCount++);
            cell.setCellValue(divisionRule.getReferenceId());

            cell = row.createCell(columnCount++);
            cell.setCellValue(divisionRule.getDescriptorDeck());

            cell = row.createCell(columnCount++);
            cell.setCellValue(divisionRule.getUniteDescriptor());

            cell = row.createCell(columnCount++);
            cell.setCellValue(divisionRule.getNumberOfUnitInPack());

            int unitCost = 0;
            for(UniteDescriptor d : uniteDescriptorList) {
                if(d.getDescriptor() != null && d.getDescriptor().contains(divisionRule.getUniteDescriptor())){
                    unitCost = Integer.parseInt(d.getCommandPoints());
                }
            }

            cell = row.createCell(columnCount);
            cell.setCellValue(unitCost);

        }
    }
}
