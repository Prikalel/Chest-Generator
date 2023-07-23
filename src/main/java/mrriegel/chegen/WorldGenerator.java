package mrriegel.chegen;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;
import org.apache.logging.log4j.Logger;

import algs.model.kdtree.TwoDTree;

public class WorldGenerator implements IWorldGenerator {
	private static Logger logger = ChestGenerator.logger;
	private static TwoDTree tree = new TwoDTree();

	private double minimalDistanceBetweenChests = ConfigHandler.minimalDistanceBetweenChests;

	private final int MINIMUM_SPACE_ON_TOP_OF_CHEST = 3;

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		Chest chest = ChestGenerator.instance.GetRandomChest(random);
		if (chest != null) {
			if (random.nextInt(100) >= chest.chance)
				return;
			if (!spawnChest(chunkX, chunkZ, world, chest)) {
				logger.debug("Can not spawn chest at location X:" + String.valueOf(chunkX) + " Z: " + String.valueOf(chunkZ));
			}
		} else {
			logger.debug("No chests in list! Nothing to spawn.");
		}
	}

	/**
	 * Спавнит сундук в чанке.
	 * 
	 * @param chunkX Позиция чанка.
	 * @param chunkZ Позиция чанка.
	 * @param world Мир.
	 * @param chest Сундук который надо заспавнить.
	 * @return true если получилось и false иначе.
	 */
	private boolean spawnChest(int chunkX, int chunkZ, World world, Chest chest) {
		int j = chunkX * 16 + world.rand.nextInt(6) - world.rand.nextInt(6);
		int k = chunkZ * 16 + world.rand.nextInt(6) - world.rand.nextInt(6);
		ChestLocation newChestLocation = new ChestLocation(j, k);

		if (!checkMinimalDistance(newChestLocation)) {
			logger.warn("Will not spawn chest at location " + newChestLocation.toString() + " because the nearest chest is at less distance than minimal allowed");
			return false;
		}

		BlockPos blockpos = new BlockPos(j, chest.minY, k);
		if (!chest.matchBiome(world, blockpos)) {
			logger.warn("Will not spawn chest at location " + newChestLocation.toString() + " because it do not matches the biome");
			return false;
		}

		int max = Math.min(chest.maxY, 256); // TODO: use binary search
		while (blockpos.getY() < max && !isPositionGood(blockpos, world)) {
			blockpos = blockpos.up();
		}
		if (blockpos.getY() > max)
			return false;
		
		if (!checkNoBlocksUp(blockpos, world)) {
			logger.warn("Will not spawn chest at location " + newChestLocation.toString() + " because no enough space up the position.");
			return false;
		}

		generate(world, world.rand, blockpos, chest);
		tree.insert(newChestLocation);
		return true;
	}

	/**
	 * Проверяет, что позиция удовлетворяет минимальной допустимой дистанции для сундуков.
	 * @param location Позиция для нового сундука.
	 * @return true если условие выполнено.
	 */
	private boolean checkMinimalDistance(ChestLocation location) {
		if (tree.count() == 0) {
			return true;
		}
		ChestLocation nearestChestSpawned = (ChestLocation) tree.nearest(location);
		if (nearestChestSpawned != null) {
			double nearestChestDistance = nearestChestSpawned.getDistance(location);
			logger.debug("Nearest chest distance is " + nearestChestDistance);
			if (nearestChestDistance < minimalDistanceBetweenChests) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Проверяет, что свеху нету никаких блоков (т.е. можно спавнить сундук).
	 * @param blockpos Позиция для проверки.
	 * @param world Мир.
	 * @return true если блоков нет и false если места мало.
	 */
	private boolean checkNoBlocksUp(BlockPos blockpos, World world) {
		for (int ii = 0; ii < MINIMUM_SPACE_ON_TOP_OF_CHEST; ii++) {
			if (!world.isAirBlock(blockpos.up(ii + 1))) {
				return false;
			}
		}
		return true;
	}

	private boolean isPositionGood(BlockPos blockpos, World world) {
		return world.getBlockState(blockpos.down()).getMaterial().blocksMovement() && world.isAirBlock(blockpos);
	}

	private void generate(World world, Random rand, BlockPos position, Chest chest) {
		BlockPos blockpos = new BlockPos(position);
		world.setBlockState(blockpos, Blocks.CHEST.getStateFromMeta(rand.nextInt(6)), 2);
		logger.info("Chest " + chest.name + " at " + blockpos);
		TileEntity tileentity = world.getTileEntity(blockpos);

		if (tileentity instanceof TileEntityChest) {
			chest.fill((TileEntityChest) tileentity, rand);
		}

		BlockPos blockpos1 = blockpos.east();
		BlockPos blockpos2 = blockpos.west();
		BlockPos blockpos3 = blockpos.north();
		BlockPos blockpos4 = blockpos.south();
		if (chest.light) {
			if (world.isAirBlock(blockpos2) && world.getBlockState(blockpos2.down()).getMaterial().blocksMovement()) {
				world.setBlockState(blockpos2, Blocks.TORCH.getDefaultState(), 2);
			}

			if (world.isAirBlock(blockpos1) && world.getBlockState(blockpos1.down()).getMaterial().blocksMovement()) {
				world.setBlockState(blockpos1, Blocks.TORCH.getDefaultState(), 2);
			}

			if (world.isAirBlock(blockpos3) && world.getBlockState(blockpos3.down()).getMaterial().blocksMovement()) {
				world.setBlockState(blockpos3, Blocks.TORCH.getDefaultState(), 2);
			}

			if (world.isAirBlock(blockpos4) && world.getBlockState(blockpos4.down()).getMaterial().blocksMovement()) {
				world.setBlockState(blockpos4, Blocks.TORCH.getDefaultState(), 2);
			}
		}
	}

}
