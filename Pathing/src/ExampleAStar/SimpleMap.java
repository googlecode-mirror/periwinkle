package ExampleAStar;

import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

class SimpleMap implements TileBasedMap {
    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;

    private static final int[][] MAP = {
        {1,1,1,1,1,1,1,1,1,1},
        {1,0,0,0,0,0,1,1,1,1},
        {1,0,1,1,1,0,1,1,1,1},
        {1,0,1,1,1,0,0,0,1,1},
        {1,0,0,0,1,1,1,0,1,1},
        {1,1,1,0,1,1,1,0,0,0},
        {1,0,1,0,0,0,0,0,1,0},
        {1,0,1,1,1,1,1,1,1,0},
        {1,0,0,0,0,0,0,0,0,0},
        {1,1,1,1,1,1,1,1,1,0}
    };

    @Override
    public boolean blocked(PathFindingContext ctx, int x, int y) {
        return MAP[y][x] != 0;
    }

    @Override
    public float getCost(PathFindingContext ctx, int x, int y) {
        return 1.0f;
    }

    @Override
    public int getHeightInTiles() {
        return HEIGHT;
    }

    @Override
    public int getWidthInTiles() {
        return WIDTH;
    }

    @Override
    public void pathFinderVisited(int x, int y)
    {
    	
    }

}