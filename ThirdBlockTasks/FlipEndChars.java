import java.util.Scanner;

class FlipEndChars {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Введите строку: ");
		String str = input.nextLine();
		System.out.printf("Результат: %s", flipEndChars(str));
	}

	public static String flipEndChars(String str) {
		if(str.length() < 2)
			return "Incompatible.";
		if(str.charAt(0) == str.charAt(str.length() - 1))
			return "Two's a pair.";
		else 
			return swap(str, 0, str.length() - 1);
	}

	private static String swap(String str , int i , int j ) {
      StringBuilder strB = new StringBuilder(str);
      char l = strB.charAt(i) , r = strB.charAt(j);
      strB.setCharAt(i,r);
      strB.setCharAt(j,l);
      return strB.toString();
   }
}