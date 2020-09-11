import java.util.Scanner;

class Operation {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Введите N: ");
		double n = input.nextDouble();
		System.out.println("Введите число a: ");
		double a = input.nextDouble();
		System.out.println("Введите число b: ");
		double b = input.nextDouble();
		System.out.printf("Результат: %s", operation(n, a, b));
	}

	public static String operation(double n, double a, double b) {
		if (a + b == n) {
			return "added";
		}
		else if (a - b == n) {
			return "subtracted";
		}
		else if (a * b == n) {
			return "multiply";
		}
		else if (a / b == n) {
			return "split";
		}
		return "none";
	}
}