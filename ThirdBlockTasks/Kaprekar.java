import java.util.Scanner;

class Kaprekar {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Введите число: ");
		int num = input.nextInt();
		System.out.printf("Результат: %b", isKaprekar(num));
	}

	public static boolean isKaprekar(int number) {
		String str = String.valueOf(number * number);
		String left;
		String right;

		if(str.length() == 1) 
		{
			right = str;
			left = "0";
		}
		else 
		{
			left = str.substring(0, str.length() / 2);
			right = str.substring(str.length() / 2, str.length());
		}

		int letftToNumber = Integer.parseInt(left);
		int rightToNumber = Integer.parseInt(right);

		return (letftToNumber + rightToNumber) == number;
	}
}