import java.util.Scanner;
import java.io.*;

class Test
{
	public static void main(String args[])
	{
		//

		Scanner in = null;
		PrintWriter out = null;
		FileWriter file = null;

		try
		{
			file = new FileWriter("F://iRobot//directions.txt");
			in = new Scanner(new File("F://iRobot//board.txt"));
			out = new PrintWriter(file);
		} catch (Exception e)
		{
			System.out.println("the exception was thrown");
			System.out.println(e);
		}


		/*

		int xval,yval;

		xval = Integer.parseInt(in.nextLine());
		yval = Integer.parseInt(in.nextLine());

		String s = in.nextLine();
		*/

		/*Variables store data about the board read in from file*/
		int x_dest = in.nextInt(); //(x,y) coord of desired destination for robot to head to
		int y_dest = in.nextInt();
		int x_val = in.nextInt(); //x width and y heighth of board
		int y_val = in.nextInt();
		int x_robot = in.nextInt(); //(x,y) coord of robot's current location
		int y_robot = in.nextInt();

		Board a = new Board(x_val,y_val);
		a.array[x_robot][y_robot] = 3;
		//a.array[x_dest][y_dest] = 2;

		a.printBoard();

		/*loop read coordinates of obstacles on board and sets those coordinates*/
		int x_obstacle;
		int y_obstacle;
		while(in.hasNextInt())
		{
			x_obstacle = in.nextInt();
			y_obstacle = in.nextInt();
			a.array[x_obstacle][y_obstacle] = 1;
		}

		a.printBoard();

		//Board a = new Board(10,10);
		//a.populate(10);

		/*
		for(int i=0;i<s.length();i+=2)
		{
			a.array[s.charAt(i)][s.charAt(i+1)] = 1;
		}
		*/

		Scanner kb = new Scanner(System.in);

/*		pathList test = new pathList();
		for(int i=0;i<3;i++)
		{
			System.out.print("x: ");
			x = kb.nextInt();
			System.out.print("y: ");
			y = kb.nextInt();
			test.enqueue(new lNode(x,y));

			System.out.println(test);
		}

		System.out.println(test.contains(3,3));
*/
		//a.printBoard();

		Robot r = new Robot(x_robot,y_robot);//default robot position is 1,1
		//a.array[1][1] = 3;//value of 3 marks location of robot
		a.printBoard();

		/*
		int x,y;
		System.out.print("enter x coord: ");
		x = kb.nextInt();
		System.out.print("enter y coord: ");
		y = kb.nextInt();
		*/

		r.setDest(x_dest,y_dest);

		r.buildMoves(new tNode(x_robot,y_robot));

		out.println(r.buildDirList());
//		out.println("aaaaa");
		out.close();
	}
}