package Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import World.ViewArea;
import World.World;

public class Player extends Entity
{	
	float movementSpeed = 1;
	Input input;
	
	public Player(World world, String id, Vector2f position) 
	{
		super(world, id, position);
		
		try 
		{
			addComponent(new ImageRenderComponent("player", new Image("Resources/trooper.png", false, Image.FILTER_NEAREST)));
		}
		catch (SlickException e) 
		{
			e.printStackTrace();
		}
		
		width = 32;
		height = 32;
	}
	
	public void update(GameContainer gc, StateBasedGame sb, ViewArea screen)
	{
		 super.update(gc, sb, screen);
	    	
		 input = gc.getInput();
		 getAction(input);
		 getMovement(input, gc);
	    	
		 rotation = getRotationTheta();	
	}
	
	public void getAction(Input input)
	{
		if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
		{

			Vector2f bulletPos = new Vector2f(position.getX() + 8, position.getY() + 8);
			float mouseY = input.getMouseY();
			float changeToX;
			float changeToY;
			float newHypot = 16;
			
			if(mouseY != position.getY())
			{
				bulletPos.set(bulletPos.getX() + 4, bulletPos.getY());
			}
			
			changeToY = (float) (newHypot * Math.sin(Math.toRadians(rotation + 90)));
			changeToX = (float) (newHypot * Math.cos(Math.toRadians(rotation + 90)));
			
			bulletPos.set(bulletPos.getX() - changeToX, bulletPos.getY() - changeToY);
			world.add(new Bullet(world, "shot", bulletPos, -1, rotation));

			//world.add(new Bullet(world, "shot", new Vector2f(position), -25, rotation));
		}
		
		if (input.isMousePressed(Input.MOUSE_RIGHT_BUTTON))
		{
			world.add(new BladeSphere(world, id, new Vector2f(position), 5, this));
		}
	}
	
	public void getMovement(Input input, GameContainer gc)
	{
		if(input.isKeyDown(Input.KEY_A))
		{
			position.set((position.getX() - movementSpeed), position.getY());
		}
	    	
		if(input.isKeyDown(Input.KEY_S))
    	{
    		position.set(position.getX(), (position.getY() + movementSpeed));
    	}
	    	
	    if(input.isKeyDown(Input.KEY_D))
	    {
	    	position.set((position.getX() + movementSpeed), position.getY());
		}
	    	
	    if(input.isKeyDown(Input.KEY_W))
	    {
		   	position.set(position.getX(), (position.getY() - movementSpeed));
	    }
	    
	    if(input.isKeyDown(Input.KEY_M))
	    {
		   	world.switchMap(gc);
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
