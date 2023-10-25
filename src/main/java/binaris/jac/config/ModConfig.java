package binaris.jac.config;

import java.io.IOException;

public class ModConfig {
    public static Config FIRST_CONFIG;
    public static void registerConfig(){
        FIRST_CONFIG = new Config("first_config", "first_config", false);



        setValues();

        try {
            FIRST_CONFIG.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void setValues(){
        FIRST_CONFIG.set("value_string", "hello world");
        FIRST_CONFIG.set("value_int", 15);


    }
}
