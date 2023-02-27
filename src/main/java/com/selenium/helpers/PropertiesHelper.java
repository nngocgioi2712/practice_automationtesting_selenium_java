package com.selenium.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {
  private static Properties properties;
  private static FileInputStream fileIn;
  private static String configsPropertiesFilePath = System.getProperty("user.dir") + "/src/main/resources/configs.properties";

  public static Properties loadFile() {
    try {
      properties = new Properties();
      fileIn = new FileInputStream(configsPropertiesFilePath);
      properties.load(fileIn);
      return properties;
    } catch (IOException ioe) {
      return new Properties();
    }
  }
    public static String getValue(String key) {
    String keyVal = "";
    try {
      if (fileIn == null) {
        properties = new Properties();
        fileIn = new FileInputStream(configsPropertiesFilePath);
        properties.load(fileIn);
        fileIn.close();
      }
      keyVal = properties.getProperty(key);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return keyVal;
  }
}
