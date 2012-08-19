import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.util.pathfinding.AStarPathFinder;

/*
 * This class holds the methods used for pathing when the enemy hits an object
 */
public class Pathing 
{

	static World map = new World();
	
	final static int MAX_PATH_LENGTH = 300;
	static AStarPathFinder pathFinder = new AStarPathFinder(map, MAX_PATH_LENGTH, true);
		
	public static Vector2f slickPathing(int START_X, int START_Y, int GOAL_X, int GOAL_Y, GameContainer gc, int selectedCharater)
	{
		Vector2f nextMove = new Vector2f();
		int pathMax = 0;	
		
		boolean firstRun = Starter.charaters[selectedCharater].isFirstRun();
		int refreshPath = Starter.charaters[selectedCharater].getRefreshPath();
		int currentPathStep = Starter.charaters[selectedCharater].getCurrentPathStep();
	
		if(firstRun)
		{
			Starter.charaters[selectedCharater].setPath(pathFinder.findPath(null, START_X, START_Y, GOAL_X, GOAL_Y));
			Starter.charaters[selectedCharater].setFirstRun(false);
		}
		
		if(refreshPath >= gc.getFPS())
        {
			Starter.charaters[selectedCharater].setPath(pathFinder.findPath(null, START_X, START_Y, GOAL_X, GOAL_Y));
        	
        	refreshPath = 0;
        	currentPathStep = 0;
        }
        else
        {
        	refreshPath++;
        	currentPathStep++;
        }
		
		Starter.charaters[selectedCharater].setRefreshPath(refreshPath);
    	Starter.charaters[selectedCharater].setCurrentPathStep(currentPathStep);
		
		pathMax = Starter.charaters[selectedCharater].getPath().getLength();
		
		if(currentPathStep >= pathMax)
		{
			currentPathStep = pathMax -1;
		}
		nextMove.set(Starter.charaters[selectedCharater].getPath().getX(currentPathStep), Starter.charaters[selectedCharater].getPath().getY(currentPathStep));
        
		return nextMove;
	}
}
