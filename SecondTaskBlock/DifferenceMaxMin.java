import java.util.Scanner;
import java.util.Arrays;

class DifferenceMaxMin {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Укажите размер массива: ");
    	int size = input.nextInt();
    	int array[] = new int[size];
    	System.out.println("Введите массив чисел:");
    
    	for (int i = 0; i < size; i++) {
        	array[i] = input.nextInt();
    	}
		System.out.printf("Разница между максимальным и минимальным: %s", differenceMaxMin(array));
	}

	public static int differenceMaxMin(int[] array) {
		Arrays.sort(array);
		return array[array.length - 1] - array[0];
	}
}