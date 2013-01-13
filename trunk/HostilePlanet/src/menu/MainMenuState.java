package menu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class MainMenuState extends BasicGameState
{
	int stateID = -1;
	
	Image masterImage;
	Image background;
	
	Image planetAnim;
	Image planet;
	
	Image gradientScroll1;
	Image gradientScroll2;
	
	Image startGameOption;
	Image optionsOption;
	Image helpOption;
	Image quitOption;
	
	int optionW = 285;
	int optionH = 40;
	int optionX = 10;
	
	int xScroll1 = -1000;
	int xScroll2 = 0;
	
	int planetX = 200;
	int planetY = 250;
	float planetTheta = 0.1f;
	
	MainMenuState(int stateID)
	{
		this.stateID = stateID;
	}
	
	@Override
	public int getID()
	{
		return stateID;
	}
	
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException 
	{
		masterImage = new Image("Resources/MasterImage.png");
		background = masterImage.getSubImage(0,0, 800, 600);
		planetAnim = new Image("Resources/Planet.png");
		planet = planetAnim.getSubImage(0, 0, 800, 800);
		
		gradientScroll1 = new Image("Resources/GradientBack.png");
		gradientScroll2 = new Image("Resources/GradientBack.png");
		
		startGameOption = masterImage.getSubImage(0, 610, optionW, optionH);
		optionsOption = masterImage.getSubImage(0, 660, optionW, optionH);
		helpOption = masterImage.getSubImage(0, 710, optionW, optionH);
		quitOption = masterImage.getSubImage(0, 760, optionW, optionH);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException
	{

		
		gradientScroll1.draw(xScroll1, 130);
		gradientScroll2.draw(xScroll2, 230);
		
		background.draw(0,0);
		planet.draw(planetX, planetY);
		
		startGameOption.draw(optionX, 400, 1);
		optionsOption.draw(optionX, 450, 1);
		helpOption.draw(optionX, 500, 1);
		quitOption.draw(optionX, 550, 1);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException
	{
		if (xScroll1 > 800) //scrolling background loop
		{
			xScroll1 = -2000;
		}
		else
		{
			xScroll1 += 5;
		}
		
		if (xScroll2 < -2000) //second scroller loop
		{
			xScroll2 = 800;
		}
		else
		{
			xScroll2 -= 5;
		}
	
		planet.rotate(planetTheta);
		
		Input input = gc.getInput();
		
		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();
		
		
		boolean insideStartGame = false;
		boolean insideOptions = false;
		boolean insideHelp = false;
		boolean insideQuit = false;
		
		
		//finds if over start game option
		if ((mouseX >= optionX && mouseX <= optionX + optionW) && (mouseY >= 400 && mouseY <= 435))
		{
			insideStartGame = true;
			insideOptions = false;
			insideHelp = false;
			insideQuit = false;
		}
		

		//finds if over options option
		else if ((mouseX >= optionX && mouseX <= optionX + optionW) && (mouseY >= 450 && mouseY <= 485))
		{
			insideStartGame = false;
			insideOptions = true;
			insideHelp = false;
			insideQuit = false;
		}
		
		
		//finds if over help option
		else if ((mouseX >= optionX && mouseX <= optionX + optionW) &&	(mouseY >= 500 && mouseY <= 535))
		{

			insideStartGame = false;
			insideOptions = false;
			insideHelp = true;
			insideQuit = false;
		}
		
		//finds if over exit option
		else if ((mouseX >= optionX && mouseX <= optionX + optionW) && (mouseY >= 550 && mouseY <= 585))
		{
	    	insideStartGame = false;
			insideOptions = false;
			insideHelp = false;
			insideQuit = true;
		}
		
	    
	    //effect on startGame
	    if(insideStartGame)
		{
	    	startGameOption = masterImage.getSubImage(275, 610, optionW, optionH);
		}
		if (insideStartGame == false)
		{
			startGameOption = masterImage.getSubImage(0, 610, optionW, optionH);
		}
	    
	    
	    //effect on options
	    if(insideOptions)
		{
	    	optionsOption = masterImage.getSubImage(275, 660, optionW, optionH);
		}
	    if (insideOptions == false)
		{
			optionsOption = masterImage.getSubImage(0, 660, optionW, optionH);
		}
	    
	    
	    //effect on help
	    if(insideHelp)
		{
	    	helpOption = masterImage.getSubImage(275, 710, optionW, optionH);
		}
	    if (insideHelp == false)
		{
			helpOption = masterImage.getSubImage(0, 710, optionW, optionH);
		}
	    
	    
	    //effect on exit
		if(insideQuit)
		{
			quitOption = masterImage.getSubImage(275, 760, optionW, optionH);
		   
		   if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) )
			    gc.exit();
		}
		if (insideQuit == false)
		{
			quitOption = masterImage.getSubImage(0, 760, optionW, optionH);
		}
	}
}
