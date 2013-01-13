package map;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ResourceManager 
{
	public Image sand;
	
	public Image trooper;
	
	public Image bullet;
	
	public ResourceManager() throws SlickException
	{
		sand = new Image("Resources/sand (light).png");
		
		trooper = new Image("Resources/Trooper.png");
		
		bullet = new Image("Resources/bullet.png");
	}
}
