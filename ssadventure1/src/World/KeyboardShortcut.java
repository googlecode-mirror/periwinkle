package World;

import org.newdawn.slick.Input;

public class KeyboardShortcut {
	
	World w;
	boolean ikeyToggle = false;
	Inventory inventory = new Inventory();
	
	public KeyboardShortcut(World w){
		this.w = w;
	}
	
	public void getKeyPressed(Input input){
		
		//Show the inventory screen with key I
		if (input.isKeyDown(Input.KEY_I) & ikeyToggle == false){
			w.add.add(inventory);
			ikeyToggle=true;
		}else if(input.isKeyDown(Input.KEY_I) & ikeyToggle == true){
			w.remove.add(inventory);
			ikeyToggle=false;
		}
		
		
		
	}

	
}
