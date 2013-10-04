class tNode
{
	tNode prev,next,up,down,left,right;
	int x,y;

	public tNode()
	{
		//
	}
	public tNode(int xpos,int ypos)
	{
		this(xpos,ypos,null);
	}
	public tNode(int xpos,int ypos,tNode p)
	{
		x = xpos;
		y = ypos;
		prev = p;
	}
	/*x and y parameters here are position of Node which this Node is attached to,
	Direction tells whether to inc or dec x or y to calculate this Node's position*/
	public tNode(Direction dir,int xpos,int ypos,tNode p)
	{
		switch(dir)
		{
			case UP:
				x = xpos;
				y = ypos+1;
				break;
			case DOWN:
				x = xpos;
				y = ypos-1;
				break;
			case LEFT:
				x = xpos-1;
				y = ypos;
				break;
			case RIGHT:
				x = xpos+1;
				y = ypos;
				break;
		}
	}

	public String toString()
	{
		String s = new String();
		s = "[" + x + "," + y + "]";
		return s;
	}
}

class lNode
{
	lNode next;
	int x,y;

	public lNode()
	{
		//
	}
	public lNode(int xpos,int ypos)
	{
		this(xpos,ypos,null);
	}
	public lNode(int xpos,int ypos,lNode n)
	{
		x = xpos;
		y = ypos;
		next = n;
	}
	public String toString()
	{
		String s = new String();
		s = "[" + x + "," + y + "]";
		return s;
	}

}

class dNode
{
	dNode next;
	Direction dir;

	public dNode()
	{
		//
	}
	public dNode(Direction d)
	{
		this(d,null);
	}
	public dNode(Direction d,dNode n)
	{
		dir = d;
		next = n;
	}
	public String toString()
	{
		String s = new String();
		s = "" + dir;
		return s;
	}
}