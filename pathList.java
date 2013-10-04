class pathList
{
	lNode head;
	int length;

	public pathList()
	{
		//
		length = 0;
	}

	public pathList(tNode t)
	{
		this.head = new lNode(t.x,t.y);
		length = 1;
	}

	public void enqueue(tNode t) //add a new node to the beginning
	{
		this.head = new lNode(t.x,t.y,this.head);//creates a new node whose .next = head (or mem address stored in head), then reassigns head pointer(i.e. gives head new address to head) to the new node
		this.length++;
	}
	public void enqueue(lNode l)
	{
		this.head = new lNode(l.x,l.y,this.head);
		this.length++;
	}
	public lNode dequeue() //remove a node from the beginning
	{
		lNode temp = this.head;

		if(head!=null)
		{
			head = head.next;
			this.length--;
		}
		return temp;
	}

	public Boolean isEmpty()
	{
		return head==null;
	}

	public Boolean contains(int xpos,int ypos)
	{
		//System.out.print(new lNode(xpos,ypos));
		Boolean contains = false;

		for(lNode ptr=this.head;ptr!=null;ptr=ptr.next)
		{
			if(ptr.x == xpos && ptr.y == ypos)
			{
				contains = true;
				break;
			}
		}

		return contains;
	}

	public pathList reverse(pathList p)
	{
		pathList reversed = new pathList();

		lNode ptr = p.head;
		while(!p.isEmpty())
		{
			reversed.enqueue(p.dequeue());
		}

		return reversed;
	}
	public pathList returnCopy() //the pathList will return a copy of itself
	{
		pathList copy = new pathList();

		for(lNode ptr=this.head;ptr!=null;ptr=ptr.next)
		{
			copy.enqueue(ptr);
		}
		copy = reverse(copy);

		return copy;
	}

	public String toString()
	{
		String s = new String();

		for(lNode ptr=this.head;ptr!=null;ptr=ptr.next)
		{
			s = "[" + ptr.x + "," + ptr.y + "]:" + s;
		}

		return s;
	}
}

//another list class for dNodes (will be built after shortest path is found and dNodes consist only of the directional information / no coordinate info)
class dirList
{
	dNode head;

	public void enqueue(dNode d)
	{
		this.head = new dNode(d.dir,this.head);
	}
	public void enqueue(Direction d)
	{
		this.head = new dNode(d,this.head);
	}
	public dNode dequeue()
	{
		dNode temp = this.head;;

		if(this.head!=null)
		{
			this.head = this.head.next;
		}

		return temp;
	}
	public String toString()
	{
		String s = new String();

		for(dNode ptr=this.head;ptr!=null;ptr=ptr.next)
		{
			s = s + ptr.dir + " ";
		}

		return s;
	}
}