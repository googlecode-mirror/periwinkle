
public class StringDrawer extends LetterArrayManager
{
	
	public void requestString(String requestedString, float startX, float startY, int lineLimit, LetterArrayManager letterDrawer)
	{
		addString(requestedString, startX, startY, 2, -1, 0, lineLimit, letterDrawer);
	}
	
	public void requestString(String requestedString, float startX, float startY, int letterSpacing, int lineLimit, LetterArrayManager letterDrawer)
	{
		addString(requestedString, startX, startY, letterSpacing, -1, 0, lineLimit, letterDrawer);
	}
		
	public void requestString(String requestedString, float startX, float startY, int letterSpacing, double displayTime, double displayTimeSpacing, int lineLimit, LetterArrayManager letterDrawer)
	{
		addString(requestedString, startX, startY, letterSpacing, displayTime, displayTimeSpacing, lineLimit, letterDrawer);
	}
	
	
	
	private void addString(String requestedString, float startX, float startY, float letterSpacing, double displayTime,
						   double displayTimeSpacing, int lineLimit, LetterArrayManager letterDrawer)
	{
		
		float currentX = startX;
		float currentY = startY;
		
		int letterWidth = 5;
		int letterHeight = 8;
		
		String formatedString = requestedString.trim();
		char selectedChar;
		int stringLength = formatedString.length();
		
		for(int i = 0; i < stringLength; i++)
		{
			selectedChar = formatedString.charAt(i);
			
			if(currentX > (startX + lineLimit - letterWidth))
			{
				currentX = startX;
				
				currentY += letterHeight + 2;
			}
			
			if (selectedChar != ' ')
			{
				addChar(selectedChar, currentX, currentY, 1, displayTime,letterDrawer);
				displayTime  += displayTimeSpacing;
			}
			
			currentX += letterWidth + letterSpacing;
			
			
		}
		
	}
	
	public void addChar(char requestedChar, float posX, float posY, float scale, double displayTime, LetterArrayManager letterDrawer)
	{
		
		int selectedArrayPos;

		//if char is upper case it searches that section of the array
		if (Character.isUpperCase(requestedChar))
		{
			
			int testChar;
			int correctArraySlot = 0;
			
			for(int i = 0; i < 25; i++)
			{
				testChar = getLetters()[i].getSelectedChar();
				
				if(testChar == requestedChar)
				{
					correctArraySlot = i;
				}
			}
			
			selectedArrayPos  = LetterImage.getOpenSlot(letterDrawer);
			
			getWordRenderArray()[selectedArrayPos] = new LetterImage(getLetters()[correctArraySlot].getCharImage(), requestedChar, selectedArrayPos, posX, posY, scale, displayTime);
		}
		
		
		//if char is lower case it searches that section of the array
		if (Character.isLowerCase(requestedChar))
		{
			int testChar;
			int correctArraySlot = 0;
			
			for(int i = 0; i < 26; i++)
			{
				testChar = getLetters()[i+26].getSelectedChar();
				
				if(testChar == requestedChar)
				{
					correctArraySlot = (i+26);
				}
			}
			
			selectedArrayPos  = LetterImage.getOpenSlot(letterDrawer);
			
			getWordRenderArray()[selectedArrayPos] = new LetterImage(getLetters()[correctArraySlot].getCharImage(), requestedChar, selectedArrayPos,  posX, posY, scale, displayTime);
		}
		
		
		//if the char is a digit it looks at that part of the array
		if (Character.isDigit(requestedChar))
		{
			int testChar;
			int correctArraySlot = 0;
			
			for(int i = 0; i < 10; i++)
			{
				testChar = getLetters()[i+52].getSelectedChar();
				
				if(testChar == requestedChar)
				{
					correctArraySlot = (i+52);
				}
			}
			
			selectedArrayPos  = LetterImage.getOpenSlot(letterDrawer);
			
			getWordRenderArray()[selectedArrayPos] = new LetterImage(getLetters()[correctArraySlot].getCharImage(), requestedChar, selectedArrayPos,  posX, posY, scale, displayTime);
		}
	}
}
