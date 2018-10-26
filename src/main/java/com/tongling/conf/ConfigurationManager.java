package com.tongling.conf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 管理配置组件
 * Created by 张宝玉 on 2018/10/9.
 */
public class ConfigurationManager {
    private static Properties prop = new Properties();

    /**
     * 静态代码块
     */
    static {
        try {
            InputStream in = ConfigurationManager.class
                    .getClassLoader().getResourceAsStream("my.properties");
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取指定key对应的value
     * @param key
     * @return
     */
    public static String getProperty(String key) {
        return prop.getProperty(key);
    }

    public static Integer getInteger(String key) {
        String value = getProperty(key);

        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException e){
            e.printStackTrace();
        }
        return 0;
    }

    public static Boolean getBoolean(String key) {
        String value = getProperty(key);

        try {
            return Boolean.valueOf(value);
        } catch (NumberFormatException e){
            e.printStackTrace();
        }
        return false;
    }
}
