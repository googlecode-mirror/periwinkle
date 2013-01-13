package entity;

import map.Game;
import map.Gameplay;
import map.ViewArea;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import entity.concrete.BladeSphere;
import entity.movementbehavior.MovementKeyboard;


public class Player extends Entity
{	
	float movementSpeed = 1;
	Input input;
	
	public Player(String id, Vector2f position) 
	{
		super(id, position);
		
		r = new ImageRenderer(this, "Player", Game.rm.trooper);
		mb = new MovementKeyboard(this, 2);
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
			Gameplay.add(new Bullet("shot", bulletPos, -1, rotation));

			//world.add(new Bullet(world, "shot", new Vector2f(position), -25, rotation));
		}
		
		if (input.isMousePressed(Input.MOUSE_RIGHT_BUTTON))
		{
			Gameplay.add(new BladeSphere("bs", new Vector2f(position), 5, this));
		}
	}
	 
	/**
	 * calculates the direction to face the player based on the mouse position
	 * @return
	 */
	public float getDirection()
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
