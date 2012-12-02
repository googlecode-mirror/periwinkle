package World;

public class Cell <E>
{
	public Cell ref;
	public E myData;
	
	public Cell(E data, Cell next)
	{
		myData= data;
		ref = next;
	}
}
