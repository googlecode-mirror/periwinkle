package map;

import java.util.LinkedList;

import entity.Entity;

public abstract class PhysicsTemplate 
{
	public void updateWorldPhysics()
	{
		resolveCollisions();
		moveEntities();
	}
	
	public void resolveCollisions(LinkedList<Entity> entities)
	{
		
	}
	
	public void moveEntities()
	{
		
	}

}
