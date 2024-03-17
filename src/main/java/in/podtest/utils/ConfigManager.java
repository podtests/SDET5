package in.podtest.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    String filePath = "src/test/resources/config.properties";

    Properties prop;

    public Properties readFile() throws IOException {

        File f1 = new File(filePath);
        FileInputStream fis = new FileInputStream(f1);

        prop = new Properties();
        prop.load(fis);

        fis.close();

        return prop;
    }






}
