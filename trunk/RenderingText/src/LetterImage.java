import org.newdawn.slick.Image;


public class LetterImage
{
	/** The Image to be Drawn */
	private Image charImage;
	
	/** the charater the image represents */
	private char selectedChar;
	
	/** the x position for the letter to be drawn */
	private float posX = 0;
	
	/** the Y position for the letter to be drawn */
	private float posY = 0;
	
	/**POsition in the render Array */
	private int arrayPos;
	
	/** scale of the letter to be drawn*/
	private float scale = 1; //reset to one
	
	/**time it should be on screen Screen*/
	private double displayTime;
	
	/**time its been on Screen*/
	private double timeOnScreen;
	
	public LetterImage(Image charImage, char selectedChar)
	{
		setCharImage(charImage);
		setSelectedChar(selectedChar);
	}
	
	public LetterImage(Image charImage, char selectedChar, int arrayPos)
	{
		setCharImage(charImage);
		setSelectedChar(selectedChar);
		setArrayPos(arrayPos);
	}
	
	public LetterImage(Image charImage, char selectedChar, int arrayPos, float posX, float posY, float scale, double displayTime)
	{
		setCharImage(charImage);
		setSelectedChar(selectedChar);
		setArrayPos(arrayPos);
		setPosX(posX);
		setPosY(posY);
		setScale(scale);
		setDisplayTime(displayTime);
	}

	public static int getOpenSlot(LetterArrayManager letterDrawer) 
	{
		
		int openSlot = 0;
		for(int i= 0; i < letterDrawer.getWordRenderArray().length; i++)
		{
			if(letterDrawer.getWordRenderArray()[i] == null)
			{
				openSlot = i;
				break;
			}
		}
		return openSlot;
	}
	
	public void draw()
	{
		charImage.draw(posX ,posY, scale);
	}
	
	
	public Image getCharImage() 
	{
		return charImage;
	}

	public void setCharImage(Image charImage) 
	{
		this.charImage = charImage;
	}

	public char getSelectedChar() 
	{
		return selectedChar;
	}

	public void setSelectedChar(char selectedChar) 
	{
		this.selectedChar = selectedChar;
	}
	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}
	
	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}

	public int getArrayPos() {
		return arrayPos;
	}

	public void setArrayPos(int arrayPos) {
		this.arrayPos = arrayPos;
	}

	public double getDisplayTime() {
		return displayTime;
	}

	public void setDisplayTime(double displayTime) {
		this.displayTime = displayTime;
	}

	public double getTimeOnScreen() {
		return timeOnScreen;
	}

	public void setTimeOnScreen(double timeOnScreen) {
		this.timeOnScreen = timeOnScreen;
	}
	
}
