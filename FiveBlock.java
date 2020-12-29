import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;
import java.math.BigInteger;  
import java.nio.charset.StandardCharsets; 
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;  
import java.io.InputStream;

public class FiveBlock {

    public static void main(String[] args) {
	
		int[] decryptArray = new int[] {72, 33, -73, 84, -12, -3, 13, -13, -68};

		System.out.println("");
		System.out.println("ПЕРВАЯ ЗАДАЧА");
		System.out.print("encrypt: ");
		for(int i : encrypt("Hello"))
			System.out.print(i + ", ");

		System.out.println("");
		System.out.print("Decrypt: ");
		System.out.println(decrypt(decryptArray));
		
		System.out.println("");
		System.out.println("ВТОРАЯ ЗАДАЧА");
		System.out.println(canMove("Rook", "A8", "H8"));
		System.out.println(canMove("Bishop", "A7", "G1"));
		System.out.println(canMove("Queen", "C4", "D6"));

		System.out.println("");
		System.out.println("ТРЕТЬЯ ЗАДАЧА");
		System.out.println(canComplete("butl", "beautiful"));
		System.out.println(canComplete("butlz", "beautiful"));
		System.out.println(canComplete("tulb", "beautiful"));
		System.out.println(canComplete("bbutl", "beautiful"));

		int[] array1 = new int[] {16, 28};
		int[] array2 = new int[] {0};
		int[] array3 = new int[] {1, 2, 3, 4, 5, 6};
		
		System.out.println("");
		System.out.println("ЧЕТВЕРТАЯ ЗАДАЧА");
		System.out.println(sumDigProd(array1));
		System.out.println(sumDigProd(array2));
		System.out.println(sumDigProd(array3));

		String[] array4 = new String[] {"toe", "ocelot", "maniac"};
		String[] array5 = new String[] {"many", "carriage", "emit", "apricot", "animal"};
		String[] array6 = new String[] {"hoops", "chuff", "bot", "bottom"};
		
		System.out.println("");
		System.out.println("ПЯТАЯ ЗАДАЧА");
		System.out.println(sameVowelGroup(array4));
		System.out.println(sameVowelGroup(array5));
		System.out.println(sameVowelGroup(array6));

		System.out.println("");
		System.out.println("ШЕСТАЯ ЗАДАЧА");
		System.out.println(validateCard("1234567890123456"));
		System.out.println(validateCard("1234567890123452"));

		System.out.println("");
		System.out.println("СЕДЬМАЯ ЗАДАЧА");
		System.out.println(numToEng(0));
		System.out.println(numToEng(18));
		System.out.println(numToEng(126));
		System.out.println(numToEng(909));

		System.out.println(numToRus(0));
		System.out.println(numToRus(18));
		System.out.println(numToRus(126));
		System.out.println(numToRus(909));

		System.out.println("");
		System.out.println("ВОСЬМАЯ ЗАДАЧА");
		System.out.println(getSHA256("password123"));
		System.out.println(getSHA256("Fluffy@home"));
		System.out.println(getSHA256("Hey dude!"));

		System.out.println("");
		System.out.println("ДЕВЯТАЯ ЗАДАЧА");
		System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));
		System.out.println(correctTitle("sansa stark, lady of winterfell."));
		System.out.println(correctTitle("TYRION LANNISTER, HAND OF THE QUEEN."));

		System.out.println("");
		System.out.println("ДЕСЯТАЯ ЗАДАЧА");
		System.out.println(hexLattice(1));
		System.out.println(hexLattice(7));
		System.out.println(hexLattice(19));
		System.out.println(hexLattice(21));
	}

    public static int[] encrypt(String str)
	{
        int[] result = new int[str.length()];
        result[0] = str.charAt(0);
        for (int i = 1; i < str.length(); i++) 
            result[i] = (str.charAt(i) - str.charAt(i - 1));
		return result;
	}
	
	public static String decrypt(int[] array)
	{
		String result = "";
		int symbol = array[0];
		result += (char)symbol;
		
		for (int i = 1; i < array.length; i++)
		{
			symbol += array[i];
			result += (char)(symbol);
		}
		return result;
    }
    
    public static boolean canMove(String figure, String position, String destination)
	{
		if(figure == "Pawn")
			if (position.charAt(0) == destination.charAt(0) && (position.charAt(1) == destination.charAt(1) - 1 || (position.charAt(1) == '2' && position.charAt(1) == destination.charAt(1) - 2)))
				return true;
			else
				return false;
        else if(figure == "Knight")
			if ((Math.abs(position.charAt(0) - destination.charAt(0)) == 2 && Math.abs(position.charAt(1) - destination.charAt(1)) == 1) || (Math.abs(position.charAt(0) - destination.charAt(0)) == 1 && Math.abs(position.charAt(1) - destination.charAt(1)) == 2))
				return true;
			else
				return false;
        else if(figure == "Rook")
			if (position.charAt(0) == destination.charAt(0) || position.charAt(1) == destination.charAt(1))
				return true;
			else
				return false;
        else if(figure == "Bishop")
			if (Math.abs(position.charAt(0) - destination.charAt(0)) == Math.abs(position.charAt(1) - destination.charAt(1)))
				return true;
			else
				return false;
        else if(figure == "Queen")
			if ((position.charAt(0) == destination.charAt(0) || position.charAt(1) == destination.charAt(1)) || (Math.abs(position.charAt(0) - position.charAt(1)) == Math.abs(destination.charAt(0) - destination.charAt(1))))
				return true;
			else
				return false;
		else
			if ((position.charAt(0) == destination.charAt(0) && Math.abs(position.charAt(1) - destination.charAt(1)) == 1) || (position.charAt(1) == destination.charAt(1) && Math.abs(position.charAt(0) - destination.charAt(0)) == 1) || (Math.abs(position.charAt(0) - destination.charAt(0)) == 1 && Math.abs(position.charAt(1) - destination.charAt(1)) == 1))
				return true;
			else
				return false;
    }

    public static Boolean canComplete(String str1, String str2) {
        int j = 0;
		for (int i = 0; i < str2.length(); i++)
		{
			if (j >= str1.length())
				return true;
			char ch = str2.charAt(i);
			if (ch == str1.charAt(j))
				j++;
		}
		if (j == str1.length())
			return true;
		else
			return false;
    }

    public static int sumDigProd(int[] array) {
		int sum = 0;
		for(int i = 0; i < array.length; i++)
			sum += array[i];

		while(sum > 9) {
			int buf = sum;
			sum = 1;
			while(buf > 1){	
				sum *= buf % 10;
				buf /= 10;
			}
		}
		return sum;
    }
    
    public static ArrayList<String> sameVowelGroup(String[] array) {
        String vowels = "euoya";
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(array[0]);

        String vowelsInFirstWord = "";

        for(int i = 0; i < array[0].length(); i++)
            if(vowels.contains(Character.toString(array[0].charAt(i))))
                vowelsInFirstWord += array[0].charAt(i);

        for(int i = 1; i < array.length; i++) {
            String current = array[i];
            int counter = 0;

            for(int j = 0; j < vowelsInFirstWord.length(); j++)
                for(int k = 0; k < current.length(); k++)
                    if(vowelsInFirstWord.charAt(j) == current.charAt(k)) {
                        counter++;
                        break;
                    }

            if(counter == vowelsInFirstWord.length())
                arrayList.add(current);
        }
        return arrayList;
	}

	public static boolean validateCard(String a) {
		String result = a;
		result = result.substring(0, result.length() - 1);
		result = new StringBuffer(result).toString();
		
		int sum = 0;
		for(int i = 0; i < result.length(); i++){
			int buf = Character.getNumericValue(result.charAt(i));
			if(i % 2 == 0)
			{
				buf *= 2;
				if(buf > 9)
					buf = buf % 10 + buf / 10;
			}
			sum += buf;
		}

		int checkSum = Character.getNumericValue(a.charAt(a.length() - 1));
		if((10 - (sum % 10)) == checkSum)
			return true;
		else
			return false;
	}

	public static String numToEng(int a) {

		if(a == 0) return "zero";

		String s = Integer.toString(a);
		int b = a;
		String result = "";

		String[] dictZeroToNineteen = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",  "sixteen", "seventeen", "eighteen", "nineteen" };
		String[] dictTens = {"", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};

		if(s.length() > 2){	 
			result += dictZeroToNineteen[Character.getNumericValue(s.charAt(0))] + " hundred ";
			b = b % 100;
		}

		// Если остаток больше 19
		if(b > 19)
		{
			result += dictTens[b / 10] + " ";
			if(b % 10 != 0)	// Чтобы не было one hundred twenty zero
				result += dictZeroToNineteen[b % 10];
		}
		// Остаток меньше 20
		else if(b > 0) 
			result += dictZeroToNineteen[b];

		return result;
	}

	public static String numToRus(int a){
		if(a == 0) return "ноль";

		String s = Integer.toString(a);
		int b = a;
		String result = "";

		String[] dictZeroToNineteen = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь",  "девять", "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать" };
		String[] dictTens = {"", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто" };

		String[] dictHundreds = {"", "сто", "двести", "триста", "четыреста", "пятьсот",  "шестьсот", "семьсот", "восемьсот", "девятьсот" };

		if(s.length() > 2) {	 
			result += dictHundreds[Character.getNumericValue(s.charAt(0))] + " ";
			b = b % 100;
		}

		// Если остаток больше 19
		if(b > 19)
		{
			result += dictTens[b / 10] + " ";
			if(b % 10 != 0)	
				result += dictZeroToNineteen[b % 10] + " ";
		}
		// Остаток меньше 20
		else if(b > 0) 
			result += dictZeroToNineteen[b] + " ";
		return result;
	}
	
	public static String getSHA256(String input){
		String toReturn = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.reset();
			digest.update(input.getBytes("utf8"));
			toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return toReturn;
	}

	
	public static String correctTitle(String a) {
		a = a.toLowerCase();
		String result = "";
		Vector<String> arr = new Vector<>();
		int lastWord = 0;

		for(int i = 0; i < a.length(); i++){
			if( a.charAt(i) == ' ' || a.charAt(i) == '-'){
				i++;
				String word = a.substring(lastWord, i);
				arr.addElement(word);
				lastWord = i;
			}
		}

		arr.addElement(a.substring(lastWord, a.length()));

		for(String word : arr) {
			if( word.equals("and ") || word.equals("the ") || word.equals("of ") || word.equals("in "))
				result += word;
			else{
				String capital = Character.toString(word.charAt(0)).toUpperCase();
				result += capital + word.substring(1, word.length());
			}
		}
		return result;
	}

	public static String hexLattice(int a) {

		// Условие таково, что число должно быть суммой таблицы умножения шестерок
		int b = a - 1;
		for(int i = 1; b > 0; i++){
			b -= i * 6;
		}
		if(b < 0)
			return "Invalid";
		
		int mainHorizontal = 1;
		int numOfLines = 0;
		if(((a - 1) / 6) % 2 == 0){
			mainHorizontal = (a - 1) / 6 + 1;	// Четное частное
			numOfLines = (mainHorizontal - 1) / 2;
		}
		else{
			mainHorizontal = (a - 1) / 6 + 2;	// Нечетное
			numOfLines = (mainHorizontal - 1) / 2;
		}

		String upperHalf = "";
		String bottomHalf = "";
		String middlePart = "";

		int summ = a - mainHorizontal;

		// Средняя линия

		for(int i = 0; i < mainHorizontal; i++)
			middlePart += "o ";
		middlePart += "\n";

		// Нижние линии

		int increment = mainHorizontal - 1;
		for(int i = 1; i <= numOfLines; i++){
			for(int j = 0; j < i; j++)
				bottomHalf += " ";
			for(int j = 0; j < increment; j++)
				bottomHalf += "o ";
			increment--;
			bottomHalf += "\n";
		}

		// Верхние линии

		increment = mainHorizontal - numOfLines;
		for(int i = numOfLines; i > 0; i--){
			for(int j = 0; j < i; j++)
				upperHalf += " ";
			for(int j = 0; j < increment; j++)
				upperHalf += "o ";
			increment++;
			upperHalf += "\n";
		}
		return (upperHalf + middlePart + bottomHalf);
	}
}
