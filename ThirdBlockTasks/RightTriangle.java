import java.util.Scanner;
import java.util.Arrays; 

class RightTriangle {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Введите a: ");
		int a = input.nextInt();
		System.out.println("Введите b: ");
		int b = input.nextInt();
		System.out.println("Введите c: ");
		int c = input.nextInt();

		System.out.printf("Результат: %b", rightTriangle(a, b, c));
	}

	public static boolean rightTriangle(int a, int b, int c) {
		int[] array = {a, b ,c};
		Arrays.sort(array); 
		return Math.pow(array[0], 2) + Math.pow(array[1], 2) == Math.pow(array[2], 2); 
	}
}