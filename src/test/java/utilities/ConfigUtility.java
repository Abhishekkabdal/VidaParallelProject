package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigUtility {

    static Properties prop;

    static {
        try {
            FileInputStream fis = new FileInputStream("./src/test/resources/Config.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String getLoginID() {
        return prop.getProperty("loginID");
    }

    public static String getPassword() {
        return prop.getProperty("loginPassword");
    }
}
