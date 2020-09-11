import java.util.Scanner;

class Valid {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Введите индекс: ");
		String index = input.next();
		System.out.printf("Результат: %b", isValid(index));
	}

	public static boolean isValid(String index) {
		for(int i = 0; i < index.length(); i++)
			if((int)index.charAt(i) < 48 || (int)index.charAt(i) > 57)
				return false;
		return index.length() == 5 ? true : false;
	}
}