import java.util.Scanner;

class CulumativeSum {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Укажите размер массива: ");
    	int size = input.nextInt();
    	int array[] = new int[size];
    	System.out.println("Введите массив чисел:");
    
    	for (int i = 0; i < size; i++) {
        	array[i] = input.nextInt();
    	}

		System.out.printf("Результат: ");
		int[] newArray = culumativeSum(array);

		for (int element: newArray) {
        	System.out.print(element);
        	System.out.print(" ");
      	}
	}

	public static int[] culumativeSum(int[] array) {
		int[] resultArray = new int[array.length];

		for(int i = 0; i < array.length; i++) {
			int sum = 0;
			for(int j = i; j >= 0; j--) {
				sum += array[j];
			}
			resultArray[i] = sum;
		}
		return resultArray;
	}
}