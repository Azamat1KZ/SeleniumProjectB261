package com.cydeo.test.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //1. Create properties objects
    //2. We make it private to make it inaccessible from outside
    //3. We make it static to run it first, and we will use this object under static method
    private static Properties properties = new Properties();

    // having static block because static runs first
    static {

            try {
                FileInputStream file = new FileInputStream("configuration.properties");
                properties.load(file);
            } catch (IOException e) {
                System.out.println("File not found in ConfigurationReader class");
                e.printStackTrace();
            }
        }
        public static String getProperty(String keyword){
        return properties.getProperty(keyword);
        }
    }

