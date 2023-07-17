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
		String mainConfigFileName = "debugOutput";

		debugOutput = config.get(Configuration.CATEGORY_GENERAL, mainConfigFileName, false).getBoolean();

		minimalDistanceBetweenChests = config.get(Configuration.CATEGORY_GENERAL, mainConfigFileName, 300.0).getDouble();

		chestDefaultSpawnChance =  config.get(Configuration.CATEGORY_GENERAL, mainConfigFileName, 10).getInt();

		if (config.hasChanged()) {
			config.save();
		}
	}

}
