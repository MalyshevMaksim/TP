import java.util.Scanner;

class Same {
	public static void main(String[] args) {
		int[] firstArray = fillArray();
		int[] secondArray = fillArray();
		System.out.printf("Результат: %b", same(firstArray, secondArray));
	}

	private static int[] fillArray() {
		Scanner input = new Scanner(System.in);
		System.out.println("Укажите размер массива: ");
		int size = input.nextInt();
		System.out.println("Заполните массив: ");
		int[] array = new int[size];

		for(int i = 0; i < size; i++)
			array[i] = input.nextInt();
		return array;
	}

	public static boolean same(int[] first, int[] second) {
		return countOfUnique(first) == countOfUnique(second);
	}

	private static int countOfUnique(int[] array) {
    	int count = 0;
    	for (int i = 0; i < array.length; i++) {
        	for (int j = i+1; j < array.length; j++) 
			{
   				if (array[j] == array[i])
   				{ 
     				count++; 
     				break;
   				}
			}
    	}
    	return array.length - count;
	}
}