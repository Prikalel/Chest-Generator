package mrriegel.chegen;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class ConfigHandler {

	public static Configuration config;

	/**
	 * Minimal allowed distance (in horizontal) between two spawned chests.
	 */
	public static double minimalDistanceBetweenChests;

	/**
	 * Default spawn chance for new created chest json configuration. Values are from range [0; 100].
	 */
	public static int chestDefaultSpawnChance;

	public static void refreshConfig(File file) {
		config = new Configuration(file);
		config.load();

		Property minimalDistanceBetweenChestsProperty = config.get(Configuration.CATEGORY_GENERAL, "minimalDistanceBetweenChests", 300.0);
		minimalDistanceBetweenChests = minimalDistanceBetweenChestsProperty.getDouble();
		minimalDistanceBetweenChestsProperty.setComment("Minimal allowed distance (in horizontal) between two spawned chests.");

		Property chestDefaultSpawnChanceProperty = config.get(Configuration.CATEGORY_GENERAL, "chestDefaultSpawnChance", 10);
		chestDefaultSpawnChance = chestDefaultSpawnChanceProperty.getInt();
		chestDefaultSpawnChanceProperty.setComment("Default spawn chance for new created chest json configuration. Values are from range [0; 100].");


		if (config.hasChanged()) {
			config.save();
		}
	}
}
