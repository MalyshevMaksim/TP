import java.util.Scanner;

class Animals {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Введите количество куриц: ");
		int chikens = input.nextInt();
		System.out.println("Введите количество коров: ");
		int cows = input.nextInt();
		System.out.println("Введите количество свиней: ");
		int pigs = input.nextInt();
		System.out.printf("Количество ног: %d", animals(chikens, cows, pigs));
	}

	public static int animals(int chikens, int cows, int pigs) {
		return chikens * 2 + cows * 4 + pigs * 4;
	}
}