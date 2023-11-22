/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helperclasses;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 *
 * @author ujucoco
 */
public class ReadDBProps {
    public static String dbUrl, dbUser, dbPassword;
    // Main driver method
    public static void loadConfig()
    {
        String filePath = getProjectRootPath()+"/conf/db.properties";
        System.out.println(filePath);
        Properties prop = new Properties();

        try (FileReader fileReader = new FileReader(filePath)) {
            prop.load(fileReader);
        }
 
        // Catch block to handle the exception
        catch (IOException ex) {
            // Print messqage exception occurred as
            // invalid. directory local path is passed
            System.out.println("Invalid Path");
        }
        dbUrl = prop.getProperty("db.hoststring");
        dbUser = prop.getProperty("db.username");
        dbPassword = prop.getProperty("db.password");
        System.out.println(dbUrl+dbUser+dbPassword);
    }
    public static String getProjectRootPath() {
        // Get the current working directory
        Path currentWorkingDirectory = Paths.get(System.getProperty("user.dir"));

        // Navigate up to the project root by going up one directory at a time
        while (currentWorkingDirectory != null && !containsBuildFile(currentWorkingDirectory)) {
            currentWorkingDirectory = currentWorkingDirectory.getParent();
        }

        // If the root directory is not found, return the current working directory
        return (currentWorkingDirectory != null) ? currentWorkingDirectory.toString() : "";
    }

    private static boolean containsBuildFile(Path directory) {
        // Check if the directory contains a file that indicates it's the root of the project
        // You can customize this check based on the files or structure specific to your project
        return directory.resolve("db.properties").toFile().exists()
                || directory.resolve("README.md").toFile().exists();
    }
}


