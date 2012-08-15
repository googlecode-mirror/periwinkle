package World;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ImagePreload {
	static Image bg1;    //Fullscreen background 1
	static Image invbg1; //Inventory background 1
	
	public static void preloadimages() throws SlickException{
		bg1 = new Image("images/nature-wallpaper-1920x1080-039.jpg");
		invbg1 = new Image("images/inventorybg.png");

		
	}
	
}
