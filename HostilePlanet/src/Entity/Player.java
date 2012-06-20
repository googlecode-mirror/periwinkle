package Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import World.ViewArea;

public class Player extends Entity
{	
	float movementSpeed = 1;
	Input input;
	
	public Player(String id, Vector2f position) 
	{
		super(id, position);
		
		try 
		{
			addComponent(new ImageRenderComponent("player", new Image("Resources/trooper.png")));
		} 
		catch (SlickException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sb)
	{
		 super.update(gc, sb);
	    	
		 input = gc.getInput();
		 getMovement(input);
	    	
		 super.rotation = getRotationTheta();	
	}
	
	public void getMovement(Input input)
	{
		if (input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_S) ||
			input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_D))
		{
			if(input.isKeyDown(Input.KEY_A))
			{
				position.set((position.getX() - movementSpeed), position.getY());
				ViewArea.x = -1;
			}
	    	
	    	if(input.isKeyDown(Input.KEY_S))
	    	{
	    		position.set(position.getX(), (position.getY() + movementSpeed));
	    		ViewArea.y = 1;
	    	}
	    	
		    if(input.isKeyDown(Input.KEY_D))
		    {
		    	position.set((position.getX() + movementSpeed), position.getY());
		    	ViewArea.x = 1;
		    }
	    	
		    if(input.isKeyDown(Input.KEY_W))
		    {
		    	position.set(position.getX(), (position.getY() - movementSpeed));
		    	ViewArea.y = -1;
		    }
		}
	    
		else
		{
		    ViewArea.y = 0;
		    ViewArea.x = 0;
		}
	}
	 
	public float getRotationTheta()
	{
		float playerX = position.getX() + 16;
		float playerY = position.getY() + 16;
		 
		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();
		 
		double adjSideLength;
		double oppSideLength;
		 
		float thetaToMouse = 0;
		 
		if (mouseX != playerX || mouseY != playerY) //center glitch fix
		{
			adjSideLength = mouseX - playerX;
		 	oppSideLength = mouseY - playerY;
		 
		 	thetaToMouse = (float) Math.atan(oppSideLength/adjSideLength);
		 	thetaToMouse = (float) Math.toDegrees(thetaToMouse);
		 
		 	thetaToMouse += 90;
		 	if (mouseX < playerX)
		 	{
		 		thetaToMouse += 180; 
		 	}
		 }
		 
		 return thetaToMouse;
	}
}
