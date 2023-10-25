package binaris.jac.config;

import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Config {
    public static String id;
    public static String name;
    public static File file;
    public static boolean onFolder;
    public static HashMap<String, String> config = new HashMap<>();
    private static List<String> writeList = new ArrayList<>();


    public Config(String id, String name, boolean onFolder){
        Config.id = id;
        Config.name = name;
        Config.onFolder = onFolder;
    }

    public void load() throws IOException {
        File folder = new File("./config/");
        if(!folder.exists()){folder.mkdirs();}

        if (onFolder) {
            folder = new File("./config/" + id + "/");

            if (!folder.exists()) {
                folder.mkdirs();
            }

            file = new File("./config/" + id + "/" + name + ".properties");
        } else {
            file = new File("./config/" + name +".properties");

            if (!file.exists()) {
                file.createNewFile();

                FileWriter writer = new FileWriter(file);
                for (String value: writeList) {
                    writer.write(value + "\n");
                }
                writer.close();
            }
            else {
                Scanner reader = new Scanner(file);

                for (int line = 1; reader.hasNextLine(); line++) {
                    parseConfig(reader.nextLine(), line);
                }
            }
        }
    }

    public void set(String key, @Nullable Object value){
        if(key.equals("Comment")){
            writeList.add("# " + value);
        }
        else if(key.equals("EmptyLine") && value == null){
            writeList.add("\n");
        }
        else {
            writeList.add(key + " = " + value + " #[default: " + value + "]");
            config.put(key, String.valueOf(value));
        }
    }

    public static boolean getBool(String key){
        return Objects.equals(config.get(key), "true");
    }
    public static int getInt(String key){
        try {
            return Integer.parseInt(config.get(key));
        }  catch (Exception e){
            throw new RuntimeException("Error loading the config for: " + key);
        }
    }
    public static double getDouble(String key){
        try {
            return Double.parseDouble(config.get(key));

        } catch (Exception e){
            throw new RuntimeException("Error loading the config for: " + key);
        }
    }
    public static String getString(String key){return config.get(key);}
    public static float getFloat(String key){
        try {
            return Float.parseFloat(config.get(key));
        }catch (Exception e){
            throw new RuntimeException("Error loading the config for: " + key);
        }
    }

    private void parseConfig(String entry, int line) {
        if (!entry.isEmpty() && !entry.startsWith("# ")) {
            String[] parts = entry.split(" = ", 2);
            if (parts.length == 2) {
                String temp = parts[1].split(" #")[0];
                config.put(parts[0], temp);
            } else {
                throw new RuntimeException("Syntax error in config file on line " + line + "!");
            }
        }
    }
}
