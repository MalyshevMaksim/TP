import java.util.Scanner;

class TriArea {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Введите основание треугольника: ");
		int base = input.nextInt();
		System.out.println("Введите высоту треугольника: ");
		int height = input.nextInt();
		input.close();
		System.out.printf("Площадь: %f", triArea(base, height));
	}

	public static double triArea(int base, int height) {
		return base * height * 0.5;
	}
}
