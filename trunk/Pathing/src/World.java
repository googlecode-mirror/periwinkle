import org.newdawn.slick.Image;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;


public class World implements TileBasedMap
{
	private final static int MAP_WIDTH = 288;
	private final static int MAP_HEIGHT = 288;
	
	static Tile [][] tiles = new Tile[9] [9];
	static short [][]pathingWorld = new short[MAP_WIDTH][MAP_HEIGHT];
	
	//the string that is used to make the world
	static String worldString = "000000000" +
								"000001000" +
								"001000000" +
								"000000000" +
								"000010000" +
								"000000010" +
								"010010000" +
								"000000000" +
								"000000000";
		
	
	/*
	 * this method takes the string and makes a 2d array from it
	 */
	public static void CreateWorld() 
	{
	
		int worldStringLength = worldString.length();
		//int selectedChar = 0;
		char currentChar;
		
		int xRow = 0;
		int yRow = 0;
		
		for (int i = 0; i <  worldStringLength; i++)	
		{
			
			currentChar = worldString.charAt(i);		
			
			if (currentChar == '0')
			{
				tiles [xRow] [yRow] = (new Air(xRow, yRow));
			}
			
			if (currentChar == '1')
			{
				tiles [xRow] [yRow] = (new Rock(xRow, yRow));
			}
			
			//selectedChar++;
			xRow++;
			
			if (xRow % 9 == 0)
			{
				xRow = 0;
				
				yRow++;
			}
		}
	}
	
	/*
	 * this goes through the level array and draws the needed tile
	 * 
	 * there seems to be a bug where some aren't drawn 
	 * in right place that i haven't fixed yet
	 */
	public static void drawWorld(Image air, Image rock)
	{
		int worldStringLength = worldString.length();
		int selectedID;
		
		int xRow = 0;
		int yRow = 0;
		
		for(int i = 0; i < worldStringLength; i++)
		{
			selectedID = tiles [xRow][yRow].getId();
			
			if (selectedID == 0)
			{
				air.draw(xRow * 32,yRow * 32, 1 );
			}
			
			if (selectedID == 1)
			{
				rock.draw(xRow * 32,yRow * 32, 1 );
			}
			
			xRow++;

			if (xRow % 9 == 0)
			{
				xRow = 0;
				
				yRow++;
			}
		}
	}
	
	/*
	 * this takes a set of cords and compares them to the array
	 * to see it the title is solid or not
	 */
	
	public static void convertWorld()
	{
		int cellSize = 32;
		int xRowTiled = 0;
		int yRowTiled = 0;
		
		int xRowPathing = 0;
		int yRowPathing = 0;
		int selectedID;
		
		
		while (xRowTiled != 8 && yRowTiled != 8) 
		{
			selectedID = tiles [xRowTiled][yRowTiled].getId();
			
			if (selectedID == 0)
			{
				for(int i =  0; i < cellSize; i++)
				{
					pathingWorld [xRowPathing][yRowPathing] = 0;
					
					xRowPathing++;
					
					if(xRowPathing % 288 == 0)
					{
						xRowPathing = 0;
						yRowPathing++;
					}
				}
			}
			
			if (selectedID == 1)
			{
				for(int i =  0; i < cellSize; i++)
				{
					pathingWorld [xRowPathing][yRowPathing] = 0;
				}
				
				xRowPathing++;
				
				if(xRowPathing % 288 == 0)
				{
					xRowPathing = 0;
					yRowPathing++;
				}
			}
			
			xRowTiled++;
			
			if(xRowTiled % 9 == 0)
			{
				xRowTiled = 0;
				yRowTiled++;
			}
		}
	}
	
	public static boolean isPassable(int xRow, int yRow)
	{
		boolean isTilePassable;
		
		if(xRow > 8)
		{
			xRow = 8;
		}
		
		if(yRow > 8)
		{
			yRow = 8;
		}
		isTilePassable = tiles[xRow][yRow].isSolid();
	
		
		return isTilePassable;
		
	}

	@Override
	public boolean blocked(PathFindingContext arg0, int xRow, int yRow) 
	{
		boolean isBlocked = false;
		short tileID;
		
		if(xRow > 287)
		{
			xRow = 287;
		}
		
		if(yRow > 287)
		{
			yRow = 287;
		}
		
		tileID = pathingWorld[xRow][yRow];
	
		if(tileID == 0)
		{
			isBlocked = false;
		}
		if(tileID == 1)
		{
			isBlocked = true;
		}
		
		return isBlocked;
	}

	@Override
	public float getCost(PathFindingContext arg0, int arg1, int arg2)
	{
		
		return 1.0f;
	}
	@Override
	public int getHeightInTiles() 
	{
		
		return MAP_HEIGHT;
	}

	@Override
	public int getWidthInTiles() 
	{
	
		return MAP_WIDTH;
	}

	@Override
	public void pathFinderVisited(int x, int y) 
	{
		
		
	}
}
