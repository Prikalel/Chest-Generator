package mrriegel.chegen;

import algs.model.IPoint;

public class ChestLocation implements IPoint {
    private int chunkX;
    private int chunkZ;

    public ChestLocation(int chunkX, int chunkZ) {
        this.chunkX = chunkX;
        this.chunkZ = chunkZ;
    }

    @Override
    public int compareTo(IPoint o) {
        if (o instanceof ChestLocation) {
            ChestLocation other = (ChestLocation) o;
            if (this.chunkX != other.chunkX)
                return this.chunkX - other.chunkX;
            return this.chunkZ - other.chunkZ;
        }
        final Class pointClass = o.getClass();
        throw new UnsupportedOperationException("Unimplemented method 'compareTo' for type " + pointClass.getTypeName());
    }

    public double getDistance(ChestLocation other) {
        return Math.sqrt(Math.pow((this.chunkX - other.chunkX), 2) + Math.pow((this.chunkZ - other.chunkZ), 2));
    }

    @Override
    public double getX() {
        return chunkX;
    }

    @Override
    public double getY() {
        return chunkZ;
    }
    
    @Override
    public String toString() {
        return "chunkX " + String.valueOf(chunkX) + ", chunkZ " + String.valueOf(chunkZ);
    }
}
