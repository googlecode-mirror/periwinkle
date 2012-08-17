package World;

import org.newdawn.slick.Input;

public class KeyboardShortcut {
	
	World w;
	boolean KeyToggle_I = false;
	boolean keyLock_I = false;
	Inventory inventory = new Inventory();
	
	public KeyboardShortcut(World w){
		this.w = w;
	}
	
	public void getKeyPressed(Input input){
		
		//Show the inventory screen with key I
		
		if (input.isKeyDown(Input.KEY_I) && keyLock_I == false)
		{
			if (KeyToggle_I == false)
			{
				w.add.add(inventory);
				KeyToggle_I=true;
			}
			
			else
			{
				w.remove.add(inventory);
				KeyToggle_I=false;
			}
			
			keyLock_I = true;
		}
		
		else if (input.isKeyDown(Input.KEY_I) == false && keyLock_I == true)
		{
			keyLock_I = false;
		}
	}
}
