package org.TalCoWarPro;

import org.TalCoWarPro.Objects.UniteDescriptor.UniteDescriptor;
import org.TalCoWarPro.UniteDescriptorDecode.UniteDescriptorDecode;
import org.TalCoWarPro.UniteDescriptorWrite.UniteDescriptorWrite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Scanner;
import org.apache.ibatis.jdbc.ScriptRunner;


public class TalCoWarPro {

    public static void main(String[] args){
        int x = 0;
        String username = "root";
        String password = "";
        Connection connection = null;
        while (x == 0) {
            Scanner scanner = new Scanner(System.in);
            try {
                try{
                    String url = "jdbc:mariadb://localhost:3306/WarPro";
                    connection = DriverManager.getConnection(url, username, password);
                } catch (Exception e){
                    System.out.println("ERROR: Cannot connect to database");
                    System.out.println(e.getMessage());
                    if (e.getMessage().contains("Unknown database 'warpro'")){
                        try {
                            String url = "jdbc:mariadb://localhost:3306/";
                            connection = DriverManager.getConnection(url, username, password);
                            ScriptRunner sr = new ScriptRunner(connection);
                            Reader reader = new BufferedReader(new FileReader("src\\main\\java\\org\\TalCoWarPro\\schema.sql"));
                            sr.runScript(reader);
                            System.out.println("\nCREATED WARPRO DATABASE");
                        } catch (Exception ex){
                            System.out.println(ex.getMessage());
                        }
                    }
                }

                System.out.println("\nPlease enter 0 to exit, 1 to decode a new ndf file, 2 to write changes to a new ndf file [NOT ADDED], or 3 to alter your MariaDB login details");
                int userString = scanner.nextInt();

                switch (userString) {
                    case 0 -> {
                        System.out.println("\nPlease don't leave mee :(");
                        x += 1;
                    }
                    case 1 -> {
                        System.out.println("\nReading ndf...");
                        UniteDescriptorDecode uniteDescriptorDecode = new UniteDescriptorDecode();
                        ArrayList<UniteDescriptor> uniteDescriptorList = uniteDescriptorDecode.uniteDescriptorDecode();
                        System.out.println("\nWriting to the database...");
                        UniteDescriptorWrite uniteDescriptorWrite = new UniteDescriptorWrite(username, password);
                        uniteDescriptorWrite.insertUniteDescriptor(uniteDescriptorList);
                        System.out.println("\nFinished successfully!");
                    }
                    case 2 -> System.out.println("\nWriting changes...");
                    case 3 -> {
                        System.out.println("\nPlease enter MariaDB username");
                        username = scanner.next();
                        System.out.println("\nPlease enter MariaDB password");
                        password = scanner.next();
                    }
                }

            } catch (Exception e) {
                System.out.println("Error");
            }
        }
    }
}
