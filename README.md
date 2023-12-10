# Just another config

This is a config file for your mods 

If you only want the file, go here [Config](src%2Fmain%2Fjava%2Fbinaris%2Fjac%2Fconfig%2FConfig.java)

### How to instance the config?

Put the [Config](src%2Fmain%2Fjava%2Fbinaris%2Fjac%2Fconfig%2FConfig.java) into a package called config in your mod (This is optional, if you want to put the file wherever you want)

Also create another file for creating the instances [Example](src%2Fmain%2Fjava%2Fbinaris%2Fjac%2Fconfig%2FModConfig.java)

This is an example of how to instance the config class:

```java
    public class ModConfig {
        public static Config FIRST_CONFIG = new Config("first_config", "first_config", false);

        // Just example configs :p
        public static Config MOBS_CONFIG = new Config("random_mod", "mobs_config", true);
        public static Config ITEMS_CONFIG = new Config("random_mod", "items_config", true);
}
```
Explaining the `MOBS_CONFIG`:

`random_mod` : it's your mod id and the folder where you are going to put the config files

`mobs_config` : the config file name

`true/false` : If the config is on a folder 

### How to put values in the config?
Create a method for registering the values (you can save strings, ints, bool, floats and doubles)

Also use the load method to save your config
```java
public class ModConfig {
    public static void registerConfig() {
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
```

and use this method in your mod initializer class
```java
public class JustAnotherConfig implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("justanotherconfig");

	@Override
	public void onInitialize() {
		ModConfig.registerConfig(); //This, put the method before every call to the config

		LOGGER.info("Hello new config world!");
	}
}
```

## How to get the values
Use these methods 
```java
    Config.getString("elemental_creeper_name");
    Config.getInt("any_int_key");
    Config.getFloat("any_float_key");
    Config.getDouble("any_double_key");
```

If you use a not existing key, this will throw a Runtime error.

## How to put a comment or an empty line

Use
```java
        FIRST_CONFIG.set("EmptyLine", null);
        FIRST_CONFIG.set("Comment", "Use your comment here");
	More data...
	FIRST_CONFIG.load();
```
