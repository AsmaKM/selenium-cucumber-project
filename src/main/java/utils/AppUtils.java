package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class AppUtils {

    public static String getPropertyFromFile(String filePathAndName, String propertyName){
        try{
            Properties prop = new Properties();
            prop.load(Files.newInputStream(Paths.get(filePathAndName)));
            return prop.getProperty(propertyName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitByTime(int timeInMilliseconds){
        try{
            Thread.sleep(timeInMilliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Path getAbsolutePath(String relativePath){
        Path currentRelativePath = Paths.get(relativePath);
        return currentRelativePath.toAbsolutePath();
    }

    public static List<String> getFileNamesInDirectory(String dirPath){
        File[] files = new File(dirPath).listFiles();
        List<File> filesList = Arrays.asList(files);
        return filesList.stream().map(file -> file.getName()).collect(Collectors.toList());
    }

    public static String addDefault(String mainStringValue, String defaultValue){
        return mainStringValue == null || mainStringValue.equals("") ? defaultValue : mainStringValue;
    }

    public static int addDefault(String mainStringValue, int defaultValue){
        return mainStringValue == null || mainStringValue.equals("") ? defaultValue : Integer.parseInt(mainStringValue);
    }

    public static String getPropertyOrDefault(String key, String filePathAndName, String defaultValue) {
        String propertyValue = System.getProperty(key
                , AppUtils.getPropertyFromFile(filePathAndName, key));
        return propertyValue == null || propertyValue.equals("") ? defaultValue : propertyValue;
    }

    public static int getPropertyOrDefault(String key, String filePathAndName, int defaultValue) {
        String propertyValue = System.getProperty(key
                , AppUtils.getPropertyFromFile(filePathAndName, key));
        return propertyValue == null || propertyValue.equals("") ? defaultValue : Integer.parseInt(propertyValue);
    }

    public static String getMandatoryProperty(String key, String filePathAndName){
        String property = System.getProperty(key
                , AppUtils.getPropertyFromFile(filePathAndName, key));
        if (property == null){
            String errorMessage = String.format("Property: %s not found in %s file or command argument -D%s=<value>", key,filePathAndName, key);
            throw new IllegalArgumentException(errorMessage);
        } else {
            return property;
        }
    }

}
