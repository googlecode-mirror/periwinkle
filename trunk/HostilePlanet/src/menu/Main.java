package menu;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame
{
	
	public static final int MAINMENUSTATE = 0;
	public static final int GAMEPLAYSTATE = 1;
	
	public Main()
	{
		super("test game");
		
		this.addState(new MainMenuState(MAINMENUSTATE));
		//this.addState(new GameplayState(GAMEPLAYSTATE));
		this.enterState(MAINMENUSTATE);
	}

	public static void main(String[] args) throws SlickException 
	{
		AppGameContainer game = new AppGameContainer(new Main());
		
		game.setDisplayMode(800, 600, false);
		game.setTargetFrameRate(60);
		game.start();
	}

	public void initStatesList(GameContainer gc) throws SlickException
	{
		this.getState(MAINMENUSTATE).init(gc, this);
		//this.getState(GAMEPLAYSTATE).init(gc, this);
	}
}
