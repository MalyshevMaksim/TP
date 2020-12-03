import java.util.Scanner;

class ProfitableGamble {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Введите prob: ");
		double prob = input.nextDouble();
		System.out.println("Введите prize: ");
		double prize = input.nextDouble();
		System.out.println("Введите pay: ");
		double pay = input.nextDouble();
		System.out.printf("Результат: %b", profitableGamble(prob, prize, pay));
	}

	public static boolean profitableGamble(double prob, double prize, double pay) {
		return prob * prize > pay;
	}
}