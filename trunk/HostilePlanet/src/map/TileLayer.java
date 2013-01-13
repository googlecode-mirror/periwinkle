package map;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import entity.Tile;

public class TileLayer extends MapLayer
{
	static final int TILE_WIDTH = 32;
	static final int TILE_HEIGHT = 32;
	
	int gridWidth;
	int gridHeight;
	
	Tile[][] tiles;
	
	public TileLayer(String id, int sizeX, int sizeY)
	{
		super(id);
		
		gridWidth = sizeX;
		gridHeight = sizeY;
		tiles = new Tile[sizeX][sizeY];
	}
	
	@Override
	public void init()
	{
		for (int i = 0; i < gridWidth; i++)
		{
			for (int j = 0; j < gridHeight; j++)
			{
				try 
				{
					tiles[i][j] = new Tile("tile", new Vector2f(i * TILE_WIDTH, j * TILE_HEIGHT));
				} 
				catch (SlickException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * returns the pixel position of a grid coordinate in the tile grid.
	 * @param gridX
	 * @param gridY
	 * @return
	 */
	public Vector2f getPixelPosition(int gridX, int gridY)
	{
		return new Vector2f(gridX * TILE_WIDTH, gridY * TILE_HEIGHT);
	}
	
	public Tile getTileAt(int gridX, int gridY)
	{
		return tiles[gridX][gridY];
	}
	
	public void placeTile(Tile t, int gridX, int gridY)
	{
		tiles[gridX][gridY] = t;
	}
	
	public void render(Graphics g)
	{
		super.render(g);
		
		for (Tile[] ta : tiles)
		{
			for (Tile t : ta)
			{
				t.render(g);
			}
		}
	}
}
