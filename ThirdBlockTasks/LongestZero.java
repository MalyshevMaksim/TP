import java.util.Scanner;

class LongestZero {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Введите строку: ");
		String str = input.next();
		System.out.printf("Результат: %s", longestZero(str));
	}

	public static String longestZero(String str) {
		int maxZero = 0;
		for(int i = 0; i < str.length(); i++) 
		{
			if(str.charAt(i) == '0') 
			{
				int countOfZero = 1;
				while((i + 1) < str.length() && str.charAt(i + 1) == '0' ) 
				{
					countOfZero++;
					i++;
				}
				if(countOfZero > maxZero)
					maxZero = countOfZero;
			}
		}

		String result = "";
		for(int i = 0; i < maxZero; i++) {
			result += "0";
		}
		return result;
	}
}