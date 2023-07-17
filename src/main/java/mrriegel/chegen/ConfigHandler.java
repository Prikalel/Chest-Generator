package mrriegel.chegen;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {

	public static Configuration config;

	/**
	 * Enable debug output. (actually do not used)
	 */
	public static boolean debugOutput;

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
		// TODO: refactor and make clearer.

		debugOutput = config.get(Configuration.CATEGORY_GENERAL, "debugOutput", false).getBoolean();
		config.get(Configuration.CATEGORY_GENERAL, "debugOutput", false).setComment("Enable debug output. (not used actually)");

		minimalDistanceBetweenChests = config.get(Configuration.CATEGORY_GENERAL, "minimalDistanceBetweenChests", 300.0).getDouble();
		config.get(Configuration.CATEGORY_GENERAL, "minimalDistanceBetweenChests", 300.0).setComment("Minimal allowed distance (in horizontal) between two spawned chests.");

		chestDefaultSpawnChance = config.get(Configuration.CATEGORY_GENERAL, "chestDefaultSpawnChance", 10).getInt();
		config.get(Configuration.CATEGORY_GENERAL, "chestDefaultSpawnChance", 10).setComment("Default spawn chance for new created chest json configuration. Values are from range [0; 100].");


		if (config.hasChanged()) {
			config.save();
		}
	}

}
