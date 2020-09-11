import java.util.Scanner;

class NextEdge {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Введите первую сторону: ");
		int a = input.nextInt();
		System.out.println("Введите вторую сторону: ");
		int b = input.nextInt();
		System.out.printf("Третье ребро: %d", nextEdge(a, b));
	}

	public static int nextEdge(int a, int b) {
		return a + b - 1;
	}
}