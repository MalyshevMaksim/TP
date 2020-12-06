import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;
import java.util.HashSet;

public class FiveBlock {

    public static void main(String[] args) {
        String[] array = new String[] {"toe", "ocelot", "maniac"};
        System.out.println(sameVowelGroup(array));
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
}
