import java.util.Scanner;

class AvgWhole {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Укажите размер массива: ");
    	int size = input.nextInt();
    	int array[] = new int[size];
    	System.out.println("Введите массив чисел:");
    
    	for (int i = 0; i < size; i++) {
        	array[i] = input.nextInt();
    	}
		System.out.printf("Результат: %b", isAwgWhole(array));
	}

	public static boolean isAwgWhole(int[] array) {
		double sum = 0;
		for(int i = 0; i < array.length; i++)
			sum += array[i];
		double avg = sum / array.length;
		return avg % 1 == 0;
	}
}