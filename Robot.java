import java.util.Scanner;

class Robot
{
	public Direction dir;

	//(x,y) = (column position, row position)
	private int x,y;
	private int dx,dy; //destination coordinates x and y
	private int left,right,front;
	private pathList path = new pathList();
	private pathList list = new pathList();

	Scanner kb = new Scanner(System.in);

	public Robot()
	{
		x = 1;
		y = 1;
	}
	public Robot(int xpos,int ypos)
	{
		x = xpos;
		y = ypos;
		list.enqueue(new lNode(x,y));
	}

	public void setDest(int xtarget,int ytarget)
	{
		dx = xtarget;
		dy = ytarget;
	}
	/*
	private checkMoves(int[][] array,Direction)
	{
		switch(Direction)
		{
			case UP:
				left = Board.array[x-1][y];
				right = Board.array[x+1][y];
				front = Board.array[x][y+1];
				break;
			case DOWN:
				left = Board.array[x+1][y];
				right = Board.array[x-1][y];
				front = Board.array[x][y-1];
				break;
			case LEFT:
				left = Board.array[x][y+1];
				right = Board.array[x][y-1];
				front = Board.array[x-1][y];
				break;
			case RIGHT:
				left = Board.array[x][y-1];
				right = Board.array[x][y+1];
				front = Board.array[x+1][y];
				break;
		}

	}*/

	//uses position data of node n + map to determine possible moves
	private void checkMoves(tNode n)
	{
		//System.out.println("current list = " + list);
		////System.out.println("\nattaching to " + n + ":");
		if(n.x!=dx || n.y!=dy)
		{
			//System.out.print("\ntesting (" + (n.x-1) + "," + n.y + ")");
			//System.out.print(list.contains(n.x-1,n.y));
			if(Board.array[n.x-1][n.y]==0 && !list.contains(n.x-1,n.y))
			{
				//System.out.print("LEFT");
				n.left = new tNode(n.x-1,n.y,n);
			}
			//System.out.print("\ntesting (" + (n.x+1) + "," + n.y + ")");
			//System.out.print(list.contains(n.x+1,n.y));
			if(Board.array[n.x+1][n.y]==0 && !list.contains(n.x+1,n.y))
			{
				//System.out.print("RIGHT");
				n.right = new tNode(n.x+1,n.y,n);
			}
			//System.out.print("\ntesting (" + n.x + "," + (n.y+1) + ")");
			//System.out.print(list.contains(n.x,n.y+1));
			if(Board.array[n.x][n.y+1]==0 && !list.contains(n.x,n.y+1))
			{
				//System.out.print("UP");
				n.up = new tNode(n.x,n.y+1,n);
			}
			//System.out.print("\ntesting (" + n.x + "," + (n.y-1) + ")");
			//System.out.print(list.contains(n.x,n.y-1));
			if(Board.array[n.x][n.y-1]==0 && !list.contains(n.x,n.y-1))
			{
				//System.out.print("DOWN");
				n.down = new tNode(n.x,n.y-1,n);
			}
		}
		//System.out.print("\n");
		//kb.nextLine();
	}

	public void buildMoves(tNode n)
	{
		if(list.length<path.length || path.length==0)
		{
			checkMoves(n);

			if(n.up!=null)
			{
				list.enqueue(n.up);
				buildMoves(n.up);
				n.up = null;
				//pathlist.dequeue();
			}
			if(n.down!=null)
			{
				list.enqueue(n.down);
				buildMoves(n.down);
				n.down = null;
				//pathlist.dequeue();
			}
			if(n.left!=null)
			{
				list.enqueue(n.left);
				buildMoves(n.left);
				n.left = null;
				//pathlist.dequeue();
			}
			if(n.right!=null)
			{
				list.enqueue(n.right);
				buildMoves(n.right);
				n.right = null;
				//pathlist.dequeue();
			}
		}
		////System.out.println("list = " + list);
		if((n.x==dx && n.y==dy) && (list.length<path.length || path.length==0))
		{
			path = list.returnCopy(); //method that duplicates pathlist and returns that copy
			System.out.println("current PATH = " + path);
		}

		list.dequeue();
	}

	public String buildDirList()
	{
		dirList d = new dirList();

		int xdif = 0;
		int ydif = 0;

		lNode ptr = path.head;
		if(ptr!=null)
		{
			while(ptr.next!=null)//use ptr and ptr.next difference in coordinates to determine which direction to go
			{
				xdif = ptr.next.x-ptr.x;
				ydif = ptr.next.y-ptr.y;

				if(xdif!=0) //x coordinates are not same, thus LEFT or RIGHT
				{
					if(xdif<0)
					{
						d.enqueue(Direction.RIGHT);
					} else
					{
						d.enqueue(Direction.LEFT);
					}
				}else //x coordinates are same, thus UP or DOWN
				{
					if(ydif<0)
					{
						d.enqueue(Direction.UP);
					} else
					{
						d.enqueue(Direction.DOWN);
					}
				}

				ptr = ptr.next;
			}
		}

		//System.out.println(d);
		String s = "" + d;
		return s;
	}
	/*
	public buildMoveTree(int[][] array)
	{
		tNode origin = new Node(x,y);
		tNode current = origin;
		while(left==0 || right==0 || front==0)
		{
			if(left==0)
			{
				current.left = new tNode(dir,x,y,origin);
			}
			if(right==0)
			{
				current.right = new tNode(dir,x,y,origin);
			}
			if(front==0)
			{
				current.front = new tNode(dir,x,y,origin);
			}

		}
	}*/

}