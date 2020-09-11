import java.util.Scanner;

class Prefix {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Введите первую строку: ");
		String firstStr = input.next();
		System.out.println("Введите вторую строку: ");
		String secondStr = input.next();

		if (secondStr.charAt(0) == '-')
			System.out.printf("Результат Suffix: %b", isSuffix(firstStr, secondStr));
		else if (secondStr.charAt(secondStr.length() - 1) == '-') {
			System.out.printf("Результат Prefix: %b", isPrefix(firstStr, secondStr));
		}
		else {
			System.out.printf("false");
		}
	}

	public static boolean isPrefix(String str, String prefix) {
		return str.substring(0, prefix.length() - 1).equals(prefix.substring(0, prefix.length() - 1));
	}

	public static boolean isSuffix(String str, String suffix) {
		return str.substring(str.length() - suffix.length() + 1, str.length()).equals(suffix.substring(1, suffix.length()));
	}
}