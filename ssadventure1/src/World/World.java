package World;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;


public class World {
	
	Image backgroundImage;
	
	ArrayList<Object> add = new ArrayList<Object>();
	ArrayList<Object> remove = new ArrayList<Object>();
	ArrayList<Object> layer0 = new ArrayList<Object>();
	ArrayList<Object> layer1 = new ArrayList<Object>();
	ArrayList<Object> layer2 = new ArrayList<Object>();
	
	public void init(){}
	
	public void add(){
		
	}
	
	public void remove(){}
	
	public void update(GameContainer gc){
		for (Object o : add){
			layer1.add(o);
		}
		
		add.clear();
		
		for (Object o : remove){
			layer1.remove(o);
		}
		
		remove.clear();
		
	}
	
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr){
		
		ImagePreload.bg1.draw(0, 0, Game.ScreenWidth, Game.ScreenHeight);
		
		for (Object o : layer1){
			((Inventory) o).render(gc, sb, gr);
			}
		
	}


}
