import java.util.Scanner;

class FindZip {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Введите строку: ");
		String str = input.nextLine();
		System.out.printf("Результат: %d", findZip(str));
	}

	public static int findZip(String str) {
		return str.indexOf("zip", str.indexOf("zip") + 1);
	}
}