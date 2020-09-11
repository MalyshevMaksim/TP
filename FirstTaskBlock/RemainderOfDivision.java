import java.util.Scanner;

class RemainderOfDivision {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Введите первое число: ");
		int a = input.nextInt();
		System.out.println("Введите первое число: ");
		int b = input.nextInt();
		input.close();
		System.out.printf("Остаток от деления %d", remainder(a, b));
	}

	public static int remainder(int a, int b) {
		return a % b;
	}
}
