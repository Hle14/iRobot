import java.util.Scanner;
import java.io.*;

class IOTest
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

		int x = in.nextInt();
		int y = in.nextInt();

		System.out.println(x + "\n" + y);

		while(in.hasNextInt())
		{
			x = in.nextInt();
			y = in.nextInt();
			System.out.println(x + "\n" + y);
		}
	}
}