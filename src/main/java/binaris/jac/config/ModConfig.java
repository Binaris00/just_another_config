package binaris.jac.config;

public class ModConfig {
    public static Config FIRST_CONFIG = new Config("first_config", "first_config", false);

    // Just example configs :p
    public static Config MOBS_CONFIG = new Config("random_mod", "mobs_config", true);
    public static Config ITEMS_CONFIG = new Config("random_mod", "items_config", true);

    public static void registerConfig(){
        // Some random and test values
        FIRST_CONFIG.set("value_string", "hello world");
        FIRST_CONFIG.set("value_int", 15);
        FIRST_CONFIG.load();

        // Config for our random mod:

        MOBS_CONFIG.set("elemental_creeper_name", "fire creeper");
        MOBS_CONFIG.set("elemental_creeper_damage", 50);
        MOBS_CONFIG.load();

        ITEMS_CONFIG.set("item_name", "just a random name");
        ITEMS_CONFIG.set("available", 7);
        ITEMS_CONFIG.load();


    }
}
