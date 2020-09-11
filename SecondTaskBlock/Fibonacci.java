import java.util.Scanner;

class Fibonacci {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Введите число: ");
		int number = input.nextInt();
		System.out.printf("Результат: %d", fibonacci(number + 2));
	}

	public static int fibonacci(int number) {
		int a = 0;
		int b = 1;
		int result = b;

		if (number == 1) {
			return 0;
		}
		if (number == 2) {
			return 1;
		}

		for(int i = 2; i < number; i++) {
			result = b;
			result += a;
			a = b;
			b = result;
		}
		return result;
	}
}