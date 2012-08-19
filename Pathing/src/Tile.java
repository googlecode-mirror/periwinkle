/*
 * this class is the base class all the other tile classes extend.
 * it holds the cords of the tile and if it is solid or not
 */
public class Tile 
{
	
	private int arrayPositionX;
	private int arrayPositionY;
	private int id;
	private boolean solid;
	
	public Tile (int arrayPositionY, int arrayPositionX, boolean solid, int id)
	{
		this.arrayPositionX = arrayPositionX;
		this.arrayPositionY = arrayPositionY;
		this.solid  = solid;
		this.id = id;
	}
	
	public void setArrayPositionX(int arrayPositionX)
	{
		this.arrayPositionX = arrayPositionX;
	}

	public int getArrayPositionX() 
	{
		return arrayPositionX;
	}

	public void setArrayPositionY(int arrayPoitionY) 
	{
		this.arrayPositionY = arrayPoitionY;
	}

	public int getArrayPositionY() 
	{
		return arrayPositionY;
	}

	public void setSolid(boolean solid)
	{
		this.solid = solid;
	}

	public boolean isSolid() 
	{
		return solid;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public int getId() 
	{
		return id;
	}

}
