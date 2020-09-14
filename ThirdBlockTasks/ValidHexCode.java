import java.util.Scanner;

class ValidHexCode {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Введите строку: ");
		String str = input.nextLine();
		System.out.printf("Результат: %b", isValidHexCode(str));
	}

	public static boolean isValidHexCode(String str) {
		String hexKey = "0123456789ABCDEFabcdef";

		if(str.charAt(0) != '#')
			return false;
		if(str.length() != 7)
			return false;

		for(int i = 1; i < str.length(); i++)
			if(hexKey.indexOf(str.charAt(i)) == -1)
				return false;
		return true;
	}
}