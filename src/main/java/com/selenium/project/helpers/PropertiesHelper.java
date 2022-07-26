package com.selenium.project.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {
  private static Properties properties;
  private static FileInputStream fileIn;

  public static Properties loadFile() {
    String fileLink = "src/main/resources/configs.properties";
    try {
      properties = new Properties();
      fileIn = new FileInputStream(fileLink);
      properties.load(fileIn);
      return properties;
    } catch (IOException ioe) {
      return new Properties();
    }
  }
/*  public static String getValue(String key){
    String keyval = null;;
  }*/
}
