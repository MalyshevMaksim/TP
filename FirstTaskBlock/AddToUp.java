import java.util.Scanner;

class AddUpTo {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Введите число: ");
		int number = input.nextInt();
		System.out.printf("Сумма чисел до заданного числа: %d", addUpTo(number));
	}

	public static int addUpTo(int number) {
		int sum = 0;
		for(int i = 0; i <= number; i++)
			sum += i;
		return sum;
	}
}