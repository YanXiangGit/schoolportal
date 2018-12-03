package com.portal.utils;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by onion on 2017-03-28 15:58.
 */
public class ReadProperties {

    private static Properties properties = new Properties();

    static {
        try {
            InputStream inputStream = ReadProperties.class
                    .getResourceAsStream("/properties/basic.properties");
            properties.load(inputStream);
            inputStream.close();
        } catch (Exception e) {
            System.out.println("未找到配置文件properties/basic.properties" );
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        String result = (String) properties.get(key);
        if (result == null) {
            System.out.println("未找到属性名:" + key);
        }
        return result;
    }

}
