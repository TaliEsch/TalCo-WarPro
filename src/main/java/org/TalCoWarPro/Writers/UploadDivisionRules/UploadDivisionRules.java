package org.TalCoWarPro.Writers.UploadDivisionRules;

import org.TalCoWarPro.Objects.DivisionRules.DivisionRules;
import org.TalCoWarPro.Objects.UniteDescriptor.UniteDescriptor;

import java.io.*;
import java.util.ArrayList;

public class UploadDivisionRules {
    BufferedReader reader;
    BufferedWriter writer;
    String line;
    ArrayList<DivisionRules> divisionRulesList;

    public UploadDivisionRules (ArrayList<DivisionRules> divisionRulesList){
        this.divisionRulesList = divisionRulesList;
    }

    public void WriteToFile() throws IOException{
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("DivisionRules.ndf")));
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("\nSorry, the application cannot find DivisionRules.ndf Please ensure it is in the same director as this jar file");
        }
        try {
            File file = new File("Output");
            if (!file.exists()) {
                file.mkdirs();
            }
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Output/DivisionRules.ndf")));
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("\nSorry the application is unable to write to Output/DivisionRules.ndf");
        }
        int count = 0;
        String booleanTemp;

        while ((line = reader.readLine())!= null) {
            writer.newLine();
            writer.write(line);
            // Start of export block
            if (line.contains("Descriptor_Deck")) {
                // Read Deck name
                while (!(line = reader.readLine()).startsWith("                ]")) {
                    try {
                        stringWrite("UnitDescriptor", 43, null, null, divisionRulesList.get(count).getUniteDescriptor());
                        booleanTemp = String.valueOf(divisionRulesList.get(count).getAvailableWithoutTransport());
                        stringWrite("AvailableWithoutTransport", 52, null, null, booleanTemp.substring(0, 1).toUpperCase() + booleanTemp.substring(1));
                        stringWrite("AvailableTransportList", 52, 1, null, divisionRulesList.get(count).getAvailableTransportList());
                        stringWrite("NumberOfUnitInPack", 45, null, null, String.valueOf(divisionRulesList.get(count).getNumberOfUnitInPack()));
                        stringWrite("NumberOfUnitInPackXPMultiplier", 58, 1, null, divisionRulesList.get(count).getNumberOfUnitInPackXPMultiplier());
                        count++;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    writer.newLine();
                    writer.write(line);
                }
                writer.newLine();
                writer.write(line);
            }
        }
        reader.close();
        writer.close();
        System.out.println("Written successfully");
    }

    private void stringWrite(String str, Integer index1, Integer index2, String strIndex, String strToInsert) throws IOException {
        String result;
        if (strToInsert != null && !strToInsert.equals("Null") && !strToInsert.equals("")) {
            while (!(line.startsWith(")"))) {
                if (line.contains(str)) {
                    if (strIndex != null && index2 != null){
                        // TODO: Remove this.. It's a dumb workaround
                        if (str.equals("SpecializedDetections")){
                            writer.newLine();
                            writer.write(line);
                            line = reader.readLine();
                        }
                        result = line.substring(0, index1) + strToInsert + line.substring(line.lastIndexOf(strIndex) - index2);
                        writer.newLine();
                        writer.write(result);
                        line = reader.readLine();
                    } else if (index2 != null) {
                        result = line.substring(0, index1) + strToInsert + line.substring(line.length() - index2);
                        writer.newLine();
                        writer.write(result);
                        line = reader.readLine();
                    } else if (strIndex != null) {
                        result = line.substring(0, index1) + strToInsert + line.substring(line.lastIndexOf(strIndex));
                        writer.newLine();
                        writer.write(result);
                        line = reader.readLine();
                    } else {
                        result = line.substring(0, index1) + strToInsert;
                        writer.newLine();
                        writer.write(result);
                        line = reader.readLine();
                    }
                    break;
                } else {
                    writer.newLine();
                    writer.write(line);
                    line = reader.readLine();
                }
            }
        }
    }
}
