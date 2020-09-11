import java.util.Scanner;

class StrangePair {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Введите первую строку: ");
		String firstStr = input.next();
		System.out.println("Введите вторую строку: ");
		String secondStr = input.next();
		System.out.printf("Результат: %b", isStrangePair(firstStr, secondStr));
	}

	public static boolean isStrangePair(String first, String second) {
		return first.charAt(0) == second.charAt(second.length() - 1) && first.charAt(first.length() - 1) == second.charAt(0); 
	}
}