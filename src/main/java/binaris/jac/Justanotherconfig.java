package binaris.jac;

import binaris.jac.config.Config;
import binaris.jac.config.ModConfig;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Justanotherconfig implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("justanotherconfig");

	@Override
	public void onInitialize() {
		ModConfig.registerConfig();

		LOGGER.info("Hello Fabric world!");

		LOGGER.info(Config.getString("elemental_creeper_name"));
		LOGGER.info(String.valueOf(Config.getInt("available")));
		LOGGER.info(String.valueOf(Config.getInt("value_int")));
	}
}