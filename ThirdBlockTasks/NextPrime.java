import java.util.Scanner;

class NextPrime {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Введите число: ");
		int num = input.nextInt();
		System.out.printf("Результат: %d", nextPrime(num));
	}

	public static int nextPrime(int num) {
		if(num < 2)
			num = 2;

		while(true) {
			boolean flag = false;
			for(int i = 2; i < num; i++) {
				if(num % i == 0)
				{
					flag = true;
					break;
				}
			}
			if(!flag)
				return num;
			else
				num++;
		}
	}
}