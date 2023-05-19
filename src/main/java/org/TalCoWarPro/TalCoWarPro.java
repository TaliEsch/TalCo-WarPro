package org.TalCoWarPro;

import org.TalCoWarPro.Decoders.DivisionRulesDecode.DivisionRulesDecode;
import org.TalCoWarPro.Objects.DivisionRules.DivisionRules;
import org.TalCoWarPro.Objects.UniteDescriptor.UniteDescriptor;
import org.TalCoWarPro.Decoders.UniteDescriptorDecode.UniteDescriptorDecode;
import org.TalCoWarPro.Requesters.DivisionRulesRequestExcel.DivisionRulesRequestExcel;
import org.TalCoWarPro.Requesters.UniteDescriptorRequest.UniteDescriptorRequest;
import org.TalCoWarPro.Requesters.UniteDescriptorRequestExcel.UniteDescriptorRequestExcel;
import org.TalCoWarPro.Requesters.UniteRulesComboRequestExcel.UniteRulesComboRequestExcel;
import org.TalCoWarPro.Writers.DivisionRulesWriteExcel.DivisionRulesWriteExcel;
import org.TalCoWarPro.Writers.UniteDescriptorWrite.UniteDescriptorWrite;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Scanner;

import org.TalCoWarPro.Writers.UniteDescriptorWriteExcel.UniteDescriptorWriteExcel;
import org.TalCoWarPro.Writers.UniteRulesComboWriteExcel.UniteRulesComboWriteExcel;
import org.TalCoWarPro.Writers.UploadDivisionRules.UploadDivisionRules;
import org.TalCoWarPro.Writers.UploadUniteDescriptor.UploadUniteDescriptor;
import org.apache.ibatis.jdbc.ScriptRunner;


public class TalCoWarPro {


    static String username = "root";
    static String password = "comsc";
    static int y = 0;
    static int x = 0;
    static int z = 0;

    public static void main(String[] args){
        Connection connection = null;
        while (x == 0) {
            Scanner scanner = new Scanner(System.in);
            try {
                if (z==0){
                    System.out.println("\nUniteDescriptor Selected");
                }else if (z==1){
                    System.out.println("\nDivision Rules Selected");
                }else{
                    System.out.println("\nNalyd Special Mode Selected");
                }
                if (y == 0) {
                    System.out.println("\nYou are in Excel mode");
                    mainLoop(scanner);
                } else {
                    System.out.println("\nYou are in MariaDB mode");
                    try {
                        String url = "jdbc:mariadb://localhost:3306/WarPro";
                        connection = DriverManager.getConnection(url, username, password);
                    } catch (Exception e) {
                        System.out.println("ERROR: Cannot connect to database");
                        System.out.println(e.getMessage());
                        if (e.getMessage().contains("Unknown database 'warpro'")) {
                            try {
                                String url = "jdbc:mariadb://localhost:3306/";
                                connection = DriverManager.getConnection(url, username, password);
                                ScriptRunner sr = new ScriptRunner(connection);
                                Reader reader = new BufferedReader(new FileReader("src\\main\\java\\org\\TalCoWarPro\\schema.sql"));
                                sr.runScript(reader);
                                System.out.println("\nCREATED WARPRO DATABASE");
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                            }
                        }
                    }
                    mainLoop(scanner);
                }
            } catch (Exception e) {
                System.out.println("Error");
                System.out.println(e.getMessage());
            }
        }
    }

    private static void mainLoop (Scanner scanner) throws IOException {
        System.out.println("Please enter 0 to exit, 1 to decode a new ndf file, 2 to write changes to a new ndf file," +
                " 3 to alter your MariaDB login details, 4 to switch to mode, 5 to switch NDF");
        int userString = scanner.nextInt();

        switch (userString) {
            case 0 -> {
                System.out.println("\nPlease don't leave mee :(");
                x += 1;
            }
            case 1 -> {
                switch (z) {
                    case 0 -> {
                        System.out.println("\nReading UniteDescriptor.ndf...");
                        UniteDescriptorDecode uniteDescriptorDecode = new UniteDescriptorDecode();
                        ArrayList<UniteDescriptor> uniteDescriptorList = uniteDescriptorDecode.uniteDescriptorDecode();
                        if (y == 1) {
                            System.out.println("\nWriting to the database...");
                            UniteDescriptorWrite uniteDescriptorWrite = new UniteDescriptorWrite(username, password);
                            uniteDescriptorWrite.insertUniteDescriptor(uniteDescriptorList);
                            System.out.println("\nFinished successfully!");
                        } else {
                            System.out.println("\nWriting to the xlsx...");
                            UniteDescriptorWriteExcel uniteDescriptorWriteExcel = new UniteDescriptorWriteExcel();
                            String insertUniteDescriptorFilePath = "Output\\UniteDescriptorExcel.xlsx";
                            uniteDescriptorWriteExcel.insertUniteDescriptor(uniteDescriptorList, insertUniteDescriptorFilePath);
                            System.out.println("\nFinished successfully!");
                        }
                    }
                    case 1 ->{
                        System.out.println("\nReading DivisionRules.ndf...");
                        DivisionRulesDecode divisionRulesDecode = new DivisionRulesDecode();
                        ArrayList<DivisionRules> divisionRulesList = divisionRulesDecode.readDivisionRules();
                        DivisionRulesWriteExcel divisionRulesWriteExcel = new DivisionRulesWriteExcel(divisionRulesList);
                        divisionRulesWriteExcel.writeToExcel();
                    }
                    case 2 ->{
                        System.out.println("\nReading DivisionRules.ndf and UniteDescriptor...");
                        UniteDescriptorDecode uniteDescriptorDecode = new UniteDescriptorDecode();
                        ArrayList<UniteDescriptor> uniteDescriptorList = uniteDescriptorDecode.uniteDescriptorDecode();
                        DivisionRulesDecode divisionRulesDecode = new DivisionRulesDecode();
                        ArrayList<DivisionRules> divisionRulesList = divisionRulesDecode.readDivisionRules();
                        String insertUniteDescriptorFilePath = "Output\\ComboUniteRulesExcel.xlsx";
                        UniteRulesComboWriteExcel uniteRulesComboWriteExcel = new UniteRulesComboWriteExcel(divisionRulesList,
                                uniteDescriptorList, insertUniteDescriptorFilePath);
                        uniteRulesComboWriteExcel.writeToExcel();
                    }
                }
            }
            case 2 -> {
                switch(z) {
                    case 0 -> {
                        ArrayList<UniteDescriptor> uniteDescList;
                        if (y == 1) {
                            System.out.println("\nReading database...");
                            UniteDescriptorRequest uniteDescriptorRequest = new UniteDescriptorRequest(username, password);
                            uniteDescList = uniteDescriptorRequest.readUniteDescriptor();
                        } else {
                            System.out.println("\nReading changes...");
                            UniteDescriptorRequestExcel uniteDescriptorRequestExcel = new UniteDescriptorRequestExcel();
                            uniteDescList = uniteDescriptorRequestExcel.readUniteDescriptor();
                        }
                        System.out.println("\nWriting changes...");
                        UploadUniteDescriptor uploadUniteDescriptor = new UploadUniteDescriptor(uniteDescList);
                        uploadUniteDescriptor.WriteToFile();
                    }
                    case 1 -> {
                        ArrayList<DivisionRules> divisionRules;
                        DivisionRulesRequestExcel divisionRulesRequestExcel = new DivisionRulesRequestExcel();
                        divisionRules = divisionRulesRequestExcel.readDivisionRulesExcel();
                        UploadDivisionRules uploadDivisionRules = new UploadDivisionRules(divisionRules);
                        uploadDivisionRules.WriteToFile();
                    }
                    case 2 -> {
                        System.out.println("\nReading DivisionRules.ndf and UniteDescriptor...");
                        UniteDescriptorDecode uniteDescriptorDecode = new UniteDescriptorDecode();
                        ArrayList<UniteDescriptor> uniteDescriptorList = uniteDescriptorDecode.uniteDescriptorDecode();
                        DivisionRulesDecode divisionRulesDecode = new DivisionRulesDecode();
                        ArrayList<DivisionRules> divisionRulesList = divisionRulesDecode.readDivisionRules();

                        UniteRulesComboRequestExcel uniteRulesComboRequestExcel = new UniteRulesComboRequestExcel(divisionRulesList,
                                uniteDescriptorList);

                        uniteDescriptorList = uniteRulesComboRequestExcel.readUniteDescriptorExcel();
                        divisionRulesList = uniteRulesComboRequestExcel.readDivisionRulesExcel();

                        UploadUniteDescriptor uploadUniteDescriptor = new UploadUniteDescriptor(uniteDescriptorList);
                        uploadUniteDescriptor.WriteToFile();
                        UploadDivisionRules uploadDivisionRules = new UploadDivisionRules(divisionRulesList);
                        uploadDivisionRules.WriteToFile();

                    }
                }
            }
            case 3 -> {
                System.out.println("\nPlease enter MariaDB username");
                username = scanner.next();
                System.out.println("\nPlease enter MariaDB password");
                password = scanner.next();
            }
            case 4 -> {
                if (y == 0){
                    y = 1;
                }else{
                    y = 0;
                }
            }
            case 5 -> {
                if (z != 2){
                    z++;
                }else{
                    z = 0;
                }
            }
        }

    }
}
