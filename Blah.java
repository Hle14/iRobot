import java.util.Scanner;
import java.io.*;

class Blah
{
	public static void main(String args[])
	{
		Scanner kb = null;

		try
		{
			kb = new Scanner(new File("test.txt"));
		} catch (Exception e)
		{
			System.out.println(e);
		}

		int x,y,z;

		x = kb.nextInt();
		y = kb.nextInt();
		z = kb.nextInt();

		System.out.println(x + "," + y + "," + z);
	}
}