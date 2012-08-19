/*
 * this class extends the tile class and sets if it is solid to true
 * 
 * rock id = 1
 */
 public class Rock extends Tile
{
	public Rock(int arrayPosititonX, int arrayPositionY)
	{
		super(arrayPosititonX, arrayPositionY,true, 1);
	}
}
