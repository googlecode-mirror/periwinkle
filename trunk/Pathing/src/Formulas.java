/*
 *This class provides the methods used in finding
 *the slope. Other methods could be put into this 
 *as well
 */
public class Formulas 
{
	
	/*
	 * Finds the slope based on 4 points
	 */
	public static double getSlope(float object1X, float object1Y, float object2X, float object2Y)
	{
		
		//this will be the point slop formula
		
		float leftSide;
		float rightSide;
		double slope;
		
		leftSide = object1Y  - object2Y;
		
		rightSide = object1X - object2X;
		
		slope = leftSide/rightSide;
		
		
		//testing capping the frame rate
		if (slope > 2)
		{
			slope = 2;
		}
		
		
		return slope;
	}

	/*
	 * this method finds the y intercept of a line 
	 * based on 2 points and a slope
	 */
	public static int getYIntcept(int aXPos, int aYPos, double slope) 
	{
		
		float leftSide;
		float rightSide;
		
		int yIntercept;
		
		leftSide = aYPos;
		
		rightSide = (float) slope * aXPos;
		
		
		yIntercept = (int) (leftSide - rightSide);
		
		return yIntercept;
	}
}
