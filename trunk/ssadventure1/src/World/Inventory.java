package World;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

public class Inventory{
	
	//Width and height of inventory background graphic
	int inventoryWidth;
	int inventoryHeight;
	Image inventorybg;
	
	//Position of inventory background graphic
	int x;
	int y;
	
	public Inventory(){
		inventoryWidth = Game.ScreenWidth / 4;
		inventoryHeight = Game.ScreenHeight;
		
		x = (Game.ScreenWidth / 4) * 3;
		y = 0;
		
		init();
		
	}
	
	
	
	public void init(){}
	
	public void destroy(){}

	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {
		ImagePreload.invbg1.draw(x, y, inventoryWidth, inventoryHeight);
		
	}

}
