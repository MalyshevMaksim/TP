import java.util.Scanner;

class BoxSequence {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Введите число: ");
		int n = input.nextInt();
		System.out.printf("Результат: %d", boxSeq(n));
	}

	public static int boxSeq(int n) {
		return n % 2 == 0 ? n : n + 2;
	}
}