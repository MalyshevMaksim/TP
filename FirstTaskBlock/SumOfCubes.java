import java.util.Scanner;

class SumOfCubes {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Укажите размер массива: ");
    	int size = input.nextInt();
    	int array[] = new int[size];
    	System.out.println("Введите массив чисел:");
    
    	for (int i = 0; i < size; i++) {
        	array[i] = input.nextInt();
    	}
		System.out.printf("Сумма кубов: %d", sumOfCubes(array));
	}

	public static int sumOfCubes(int[] array) {
		int sum = 0;
		for(int i = 0; i < array.length; i++)
			sum += Math.pow(array[i], 3);
		return sum;
	}
}