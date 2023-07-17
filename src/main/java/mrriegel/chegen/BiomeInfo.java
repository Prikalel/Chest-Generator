package mrriegel.chegen;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class BiomeInfo {
    /**
     * Возвращает имя биома в указанном мире и позиции.
     * Нельзя пользоваться getBiomeName потому что на 1.12 из-за этого сервер падает.
     * @param world Мир.
     * @param pos Позиция (блок).
     * @return Имя биома.
     */
    public static String getBiomeName(World world, BlockPos pos) {
        Biome currentBiome = world
			.getChunkFromBlockCoords(pos)
			.getBiome(pos, world.getBiomeProvider());
        ResourceLocation resourceLocation = currentBiome
            .getRegistryName();
        if (resourceLocation != null) {
            String currentBiomeName = resourceLocation
                .toString()
                .toLowerCase();
            return currentBiomeName;
        }
        return "null";
    }

}
