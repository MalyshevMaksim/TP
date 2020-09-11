import java.util.Scanner;

class Ctoa {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Введите символ: ");
		char symbol = input.next().charAt(0);
		System.out.printf("Код символа: %d", ctoa(symbol));
	}

	public static int ctoa(char symbol) {
		return (int)symbol;
	}
}