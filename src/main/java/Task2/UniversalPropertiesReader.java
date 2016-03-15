package Task2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Oleg on 14.03.2016.
 */
public class UniversalPropertiesReader {

    public static void main(String[] args) {
        String path = "c:/homework/test/properties.prop";
        UniversalPropertiesReader universalPropertiesReader = new UniversalPropertiesReader();
        universalPropertiesReader.createProperties(path);
        universalPropertiesReader.getPropertyValue("1");
        universalPropertiesReader.getPropertyValue("5");

    }

    private Properties properties;

    UniversalPropertiesReader(){
        properties = new Properties();
    }

    public void createProperties(String path){

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        properties.setProperty("1", "test1");
        properties.setProperty("2", "test2");
        properties.setProperty("3", "test3");
        try {
            properties.store(fileOutputStream, "test");
        } catch (IOException e) {

            e.printStackTrace();
        }


    }


    public void loadProperties(String path) {

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getPropertyValue(String key){
        try{
            System.out.println(throwExceptionWithoutKeyFound(key));

        }catch (KeyNotFoundInPropertyFileException e){
            System.out.println("Key "+e.notFindedKey+ " not found");
        }

    }

    private String throwExceptionWithoutKeyFound(String key) throws KeyNotFoundInPropertyFileException{
        if(properties.getProperty(key) == null ){
            throw new KeyNotFoundInPropertyFileException(key);
        }
        return properties.getProperty(key);
    }

    }

