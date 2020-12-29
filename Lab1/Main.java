import java.util.Random;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Random rand = new Random();
		Cube cube = new Cube();
		Square square = new Square();
		
		cube.start();
		square.start();
		
		while (true)
		{
			int n = rand.nextInt(100);
			System.out.println("First:\t" + Integer.toString(n));
			
			if (n % 2 == 0)
				square.printRes(n);
			else
				cube.printRes(n);
			
			System.out.println();
			Thread.sleep(1000);
		}
	}
}

public class Cube extends Thread
{
	public void printRes(int n)
	{
		System.out.println("Third:\t" + Integer.toString(((int)Math.pow(n, 3))));
	}
}

public class Square extends Thread
{
	public void printRes(int n)
	{
		System.out.println("Second:\t" + Integer.toString((int)Math.pow(n, 2)));
	}
}
