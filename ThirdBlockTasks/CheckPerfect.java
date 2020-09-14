import java.util.Scanner;

class CheckPerfect {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Введите число: ");
		int num = input.nextInt();
		System.out.printf("Результат: %b", checkPerfect(num));
	}

	public static boolean checkPerfect(int num) {
		int sum = 0;

		for(int i = 1; i < num; i++) {
			if(num % i == 0)
				sum += i;
		}
		return sum == num;
	}
}