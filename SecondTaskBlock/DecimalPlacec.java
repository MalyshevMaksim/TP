import java.util.Scanner;

class DecimalPlacec {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Введите число: ");
		String str = input.next();
		System.out.printf("Полученная строка: %d", getDecimalPlacec(str));
	}

	public static int getDecimalPlacec(String number) {
		if (number.contains(".")) {
			return number.length() - number.indexOf('.') - 1;
		}
		return 0;
	}
}