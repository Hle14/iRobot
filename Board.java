import java.util.Random;

class Board
{
	static final Random generator = new Random(System.nanoTime());
	public static int[][] array;
	private int rows,cols;
	final private int MAX = 30;

	public Board()
	{
		array = new int[MAX][MAX];
	}
	public Board(int cols,int rows)
	{
		this.rows = rows;
		this.cols = cols;
		array = new int[cols][rows];

		for(int j=rows-1;j>=0;j--)
		{
			for(int i=0;i<cols;i++)
			{
				if(j==0 || j==rows-1)
				{
					array[i][j] = 1;
				}
				if(i==0 || i==cols-1)
				{
					array[i][j] = 1;
				}
			}
		}
	}
	public int[][] getArray()
	{
		return array;
	}

	public void populate(int obstacles)
	{
		int x,y;
		for(int i=obstacles;i>0;i--)
		{
			x = generator.nextInt()%(rows-1);
			y = generator.nextInt()%(cols-1);
			if(x<0)
			{
				x = -x;
			}
			if(y<0)
			{
				y = -y;
			}
			array[x][y] = 1;
		}
	}
	void printBoard() //(rows,cols) = (i,j)
	{
		for(int j=rows-1;j>=0;j--)
		{
			for(int i=0;i<cols;i++)
			{
				//System.out.printf("%3d",array[i][j]);
				switch(array[i][j])
				{
					case 0: System.out.printf("%3s",""); break;
					case 1: System.out.printf("%3s","x"); break;
					case 2: System.out.printf("%3s","."); break;
					case 3: System.out.printf("%3s","r"); break;
				}
			}
			System.out.print("\n\n");
		}
	}
}