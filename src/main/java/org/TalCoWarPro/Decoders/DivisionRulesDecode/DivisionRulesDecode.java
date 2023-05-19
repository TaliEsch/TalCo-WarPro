package org.TalCoWarPro.Decoders.DivisionRulesDecode;

import org.TalCoWarPro.Objects.DivisionRules.DivisionRules;
import org.TalCoWarPro.Objects.UniteDescriptor.UniteDescriptor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DivisionRulesDecode {

    BufferedReader reader;
    String line;
    ArrayList<DivisionRules> divisionRulesList;


    public ArrayList<DivisionRules> readDivisionRules() throws IOException {
        divisionRulesList = new ArrayList<>();

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("DivisionRules.ndf")));
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Sorry, the application cannot find DivisionRules.ndf Please ensure it is in the same director as this jar file");
        }

        while ((line = reader.readLine())!= null) {

            // Start of export block
            if (line.contains("Descriptor_Deck")) {
                // Read Deck name
                String descriptorDeck = line.substring(12);
                while (!(line = reader.readLine()).startsWith("                ]")) {
                    // Unit Block Variables
                    String uniteDescriptor;
                    boolean availableWithoutTransport;
                    String availableTransportList = null;
                    int numberOfUnitInPack;
                    String numberOfUnitInPackXPMultiplier;
                    try {
                        uniteDescriptor = stringDecode("UnitDescriptor", 43, null);
                        availableWithoutTransport = booleanDecode("AvailableWithoutTransport", 52, null);
                        if (!availableWithoutTransport) {
                            availableTransportList = stringDecode("AvailableTransportList", 52, 1);
                        }
                        numberOfUnitInPack = Integer.parseInt(stringDecode("NumberOfUnitInPack", 45, null));
                        numberOfUnitInPackXPMultiplier = stringDecode("NumberOfUnitInPackXPMultiplier", 58, 1);
                        DivisionRules divisionRule = new DivisionRules(descriptorDeck, uniteDescriptor, availableWithoutTransport,
                                availableTransportList, numberOfUnitInPack, numberOfUnitInPackXPMultiplier);

                        divisionRulesList.add(divisionRule);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    line = reader.readLine(); // Line after this is unique to the end of a block

                }


            }
        }
        reader.close();
        return divisionRulesList;
    }

    private String stringDecode(String str, Integer index1, Integer index2) throws IOException {
        String result = null;
        try {
            while (!(line.startsWith(")"))) {
                if (line.contains(str)) {
                    if (index2 != null) {
                        result = line.substring(index1, line.length() - index2);
                    } else {
                        result = line.substring(index1);
                    }
                    break;
                }
                line = reader.readLine();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    private Boolean booleanDecode(String str, Integer index1, Integer index2) throws IOException {
        Boolean result = null;
        try {
            while (!(line.startsWith(")"))) {
                if (line.contains(str)) {
                    if (index2 != null) {
                        result = Boolean.valueOf(line.substring(index1, line.length() - index2));
                    } else {
                        result = Boolean.valueOf(line.substring(index1));
                    }
                    break;
                }
                line = reader.readLine();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }


}
