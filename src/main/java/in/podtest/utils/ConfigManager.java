package in.podtest.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*
-------------------------
Created By: Akhil Jain
Owner: PodTest.in
Website: https://podtest.in
Email Address: akhil.jain@podtest.in
-------------------------
 */
public class ConfigManager {

    String filePath = "src/test/resources/config.properties";

    Properties prop;

    public Properties readFile()  {

        File f1 = new File(filePath);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(f1);
            prop = new Properties();
            prop.load(fis);

            fis.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return prop;
    }






}
