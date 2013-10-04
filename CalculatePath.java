import java.io.*;

class RoboBrain
{
	public Board b;

	public RoboBrain()
	{
		//
	}

	public void createBoard(int x,int y)
	{
		b = new Board(x,y);
	}

	public void setCoordinate(int x,int y)
	{
		b.array[x][y] = 1;
	}

	public void