import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;


public class LetterArrayManager 
{
	
	private int letterHeight = 8;
	private int letterWidth = 5;
	
	private int arrayMax  = (26+26+10);
	private LetterImage [] letters = new LetterImage[arrayMax];
	private LetterImage [] wordRenderArray = new LetterImage[500];
	
	public void createArray(Image masterImage)
	{
		int currentX = 0;
		int currentY = 0;
	
		char selectedChar = 65;
		//int arraySize = (masterImage.getHeight() - 2) /letterHeight  * (masterImage.getWidth() / letterWidth);
		
		for(int i = 0; i < getArrayMax(); i++)
		{
			getLetters()[i] =  new LetterImage(masterImage.getSubImage(currentX, currentY, letterWidth, letterHeight), selectedChar);
			
			currentX += (getLetterWidth() + 3);
			
			if(currentX >= masterImage.getWidth())
			{
				currentX = 0;
				currentY += (getLetterHeight() + 1);
			}
			
			selectedChar++;
			
			if(selectedChar == 91)
			{
				selectedChar = 97;
			}
			
			
			if(selectedChar == 123)
			{
				selectedChar = 48;
			}
		}
	}
	
	public void drawWholeArray()
	{
		int currentArrayPos = 0;
		int currentX = 0;
		int currentY = 0;
		
		int rowLength = 200;
		
		for (int i = 0; i < getLetters().length; i++) 
		{
			getLetters()[currentArrayPos].getCharImage().draw(currentX, currentY, 1);
			
			currentX += getLetterWidth();
			
			if(currentX >= rowLength)
			{
				currentX = 0;
				currentY += getLetterHeight() + 5;
			}
			
			currentArrayPos++;
		}
		
	}

	public void drawRenderArray()
	{
		for(int i = 0; i < getWordRenderArray().length; i++)
		{
			if(getWordRenderArray()[i] == null)
			{
				continue;
			}
			else
			{
				getWordRenderArray()[i].draw();
			}
		}
	}
	
	
	
	public void checkDisplayTime(GameContainer gc)
	{
		
		int fps = gc.getFPS();
		
		for(int i = 0; i < getWordRenderArray().length; i++)
		{
			if(getWordRenderArray()[i] == null)
			{
				continue;
			}
			else
			{
				double timeOnScreen;
				double displayTime;
				
				timeOnScreen = getWordRenderArray()[i].getTimeOnScreen();
				displayTime = getWordRenderArray()[i].getDisplayTime();
				
				
				if (displayTime == -1)
				{
					continue;
				}
				if (fps != 0) 
				{
					if (timeOnScreen / fps >= displayTime)
					{
						getWordRenderArray()[i] = null;
					} 
					else
					{
						getWordRenderArray()[i].setTimeOnScreen(timeOnScreen + 1);
					}
				}
			}
		}
	}

	public int getLetterHeight() {
		return letterHeight;
	}

	public void setLetterHeight(int letterHeight) {
		this.letterHeight = letterHeight;
	}

	public int getLetterWidth() {
		return letterWidth;
	}

	public void setLetterWidth(int letterWidth) {
		this.letterWidth = letterWidth;
	}

	public int getArrayMax() {
		return arrayMax;
	}

	public void setArrayMax(int arrayMax) {
		this.arrayMax = arrayMax;
	}

	public LetterImage [] getLetters() {
		return letters;
	}

	public void setLetters(LetterImage [] letters) {
		this.letters = letters;
	}

	public LetterImage [] getWordRenderArray() {
		return wordRenderArray;
	}

	public void setWordRenderArray(LetterImage [] wordRenderArray) {
		this.wordRenderArray = wordRenderArray;
	}
}
