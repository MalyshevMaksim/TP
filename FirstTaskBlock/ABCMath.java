import java.util.Scanner;

class ABCMath {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Введите а: ");
    	int a = input.nextInt();
    	System.out.println("Введите b: ");
    	int b = input.nextInt();
    	System.out.println("Введите c: ");
    	int c = input.nextInt();
		System.out.printf("Сумма кубов: %b", abcmath(a, b, c));
	}

	public static boolean abcmath(int a, int b, int c) {
		int sum = a;
		for(int i = 0; i < b; i++) {
			sum += sum + a;
		}
		return sum % c == 0;
	}
}