import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Введите a: ");
		int a = input.nextInt();
		System.out.println("Введите b: ");
		int b = input.nextInt();
		System.out.println("Введите c: ");
		int c = input.nextInt();
		System.out.printf("Результат: %d", solutions(a, b, c));
	}

	public static int solutions(int a, int b, int c) {
		int d = b * b - 4 * a * c;

		if(d == 0)
			return 1;
		if(d > 0)
			return 2;
		else
			return 0;
	}
}