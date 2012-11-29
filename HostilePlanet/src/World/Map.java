package World;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.newdawn.slick.geom.Vector2f;

import Entity.Entity;
import Entity.Tile;


/**
 * 
 * @author C. Fox
 *
 * The map class contains all functionality for getting, setting and rendering all tiles in
 * a given map object
 */
public class Map
{
	public int width;
	public Tile[] layer0 = new Tile[500];
	public Tile[] layer1 = new Tile[10];
	
	public Map(World world)
	{
		//temporary code for testing map
//		int y = 0;
//		int x = 0;
//		
//		for (int i = 0; i < layer0.length; i++)
//		{
//			y = i / 25;
//			
//			if (i % 25 == 0)
//				x = 0;
//			else
//				x++;
//			
//			layer0[i] = new Tile(world, "Sand", new Vector2f(x * 32, y * 32));
		
		loadMap(world);
//		}
	}
	
	public Entity tileAt(int layer, int xPos, int yPos)
	{
		int pos = (yPos / width) + xPos;
		Entity tile;
		
		if (layer == 0)
			tile = layer0[pos];
		
		else
			tile = layer1[pos];
		
		return tile;
	}
	
	public void setTile(int layer, int xPos, int yPos, Tile newTile)
	{
		//int pos = (yPos / width) + xPos;
		int pos = yPos + xPos;
		
		if (layer == 0)
		{
			 layer0[pos] = newTile;
		}
		else
		{
			 layer1[pos] = newTile;
		}
	}
	
	/**
	 * this method reads from a file line by line.
	 * [] contain the title id. the id must also be in the
	 * getTileByID() switch statement
	 * 
	 * @param world 
	 */
	public void loadMap(World world) 
	{
		File newMap = new File("Map/MapFile");
		BufferedReader reader = null;
		
		String currentLine = null;
		
		String selectedTileIDString;
		int selectedTileID;
		
		int selectedIndex = 0; 
		
		int startBracket;
		int stopBracket;
		
		int maxTiles = 500;
		
		
		//the y cord
		for(int i = 0; i < 20; i++)
		{
			try 
			{
				reader = new BufferedReader(new FileReader(newMap));
			} 
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			
			try 
			{
				currentLine = reader.readLine();
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
			selectedIndex = 0;
			
			//the x cord
			for (int j = 0; j < 25; j++) 
			{
				startBracket = currentLine.indexOf('[', selectedIndex);
				
				stopBracket = currentLine.indexOf(']', selectedIndex + 1);
				
				selectedTileIDString = currentLine.substring(startBracket + 1, stopBracket);
				
				selectedTileID = Integer.valueOf(selectedTileIDString);
				
				setTile(0, j, i * 25,getTileByID(selectedTileID, j, i, world));
				
				selectedIndex = stopBracket;
			}
			
			
		}
	}
	
	
	/**
	 * This compares the tiles id to a switch statement and return a tile based on the id.
	 * 
	 * @param tileID - ID taken from the text/map file
	 * @param x - tile's x position (0-24)
	 * @param y - tile's y position (0-19)
	 * 
	 * @return a tile object based on the id supplied
	 */
	
	public Tile getTileByID(int tileID, int x, int y, World world)
	{
		Tile selectedTile = null;
		
		switch(tileID)
		{
		case 0: selectedTile = new Tile(world, "Sand", new Vector2f(x * 32, y * 32));
				break;
		
		
		}
		return selectedTile;
	}
}
