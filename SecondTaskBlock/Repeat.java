import java.util.Scanner;

class Repeat {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Введите строку: ");
		String str = input.next();
		System.out.println("Введите число: ");
		int repeat = input.nextInt();
		input.close();
		System.out.printf("Полученная строка: %s", repeat(str, repeat));
	}

	public static String repeat(String str, int repeat) {
		String result = "";
		for(int i = 0; i < str.length(); i++) 
			for(int j = 0; j < repeat; j++)
				result += str.charAt(i);

		return result;
	}
}