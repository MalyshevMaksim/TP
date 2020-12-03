import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;

public class FourthBlock {
    public static void main(String[] args) {
        System.out.println(toStarShorthand("77777geff"));
    }

    public static String essayFormated(int n, int k, String text) {
        int startWord = 0;
        int endWord = 0;
        int numberWordInRow = 0;
        String resultEssay = "";

        while(text.substring(startWord, text.length()).indexOf(" ") != -1) {
            endWord += text.substring(startWord, text.length()).indexOf(" ");
            numberWordInRow += text.substring(startWord, endWord).length() - 1;

            if (numberWordInRow >= k) {
                resultEssay += "\n" + text.substring(startWord, endWord) + " ";
                numberWordInRow = text.substring(startWord, endWord).length();
            }
            else {
                resultEssay += text.substring(startWord, endWord) + " ";
            }
            startWord = ++endWord;
        }

        endWord = text.length();
        numberWordInRow += text.substring(startWord, endWord).length() - 1;
        if (numberWordInRow >= k) {
            resultEssay += "\n" + text.substring(startWord, endWord);
        }
        else {
            resultEssay += text.substring(startWord, endWord);
        }
        return resultEssay;
    }

    public static ArrayList<String> split(String source) {
        Stack<Character> operationStack = new Stack<Character>();
        ArrayList<String> words = new ArrayList<String>();
        String s = "";

        for(int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == '(') {
                operationStack.push('(');
                s += '(';
            }
            else {
                if (operationStack.firstElement() == '(') {
                    operationStack.pop();
                    s += ')';

                    if (operationStack.empty()) {
                        words.add(s);
                        s = "";
                    }
                }
                else {
                    words.add(s);
                    s = "";
                }
            }
        }
        return words;
    }

    public static String toCamelCase(String str)
    {
        String result = "";

        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == '_')
            {
                result += (char)(str.charAt(i + 1)-32);
                ++i;   
            }
            else
            {
                result += str.charAt(i);
            }
        }
        return result;
    }
    
    public static String toSnakeCase(String str)
    {
        String result = "";

        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z')
            {
                result += '_';
                result += (char)(ch+32);
            }
            else
            {
                result += ch;
            }
        }
        return result;
    }

    public static String BMI(double w, double h)
    {
        double val = w / (h * h);
        String res = String.format("%.1f", val);

        if (val < 18.5)
        {
            res += "Underweight";
        }
        else if (val >= 18.5 && val < 25)
        {
            res += "Normal weight";
        }
        else
        {
            res += "Overweight";
        }
        return res;
    }

    public static int bugger(int n)
	{
		int count = 0;
		String str = Integer.toString(n);
		
		while (str.length() > 1)
		{
			count++;
            int val = 1;
            
			for (int i = 0; i < str.length(); i++)
			{
				val *= Integer.parseInt((str.substring(i, i+1)));
			}
			str = Integer.toString(val);
		}
		return count;
    }
    
    public static String toStarShorthand(String str)
	{
        HashMap<Character, Integer> symbols = new HashMap<Character, Integer>();
        String result = ""; 

        for(int i = 0; i < str.length(); i++) {
            if (symbols.get(str.charAt(i)) == null) {
                symbols.put(str.charAt(i), 1);
            }
            else {  
                symbols.put(str.charAt(i), symbols.get(str.charAt(i)) + 1);
            }
        }

        String keys = "";
        for (char c : str.toCharArray()) {
            if (keys.indexOf(c) == -1)
                keys += c;
        }  

        for (int i = 0; i < keys.length(); i++) {
            int countOfCharacter = symbols.get(keys.charAt(i));
            if(countOfCharacter > 1) {
                result += Character.toString(keys.charAt(i)) + "*" + Integer.toString(countOfCharacter);
            }
            else {
                result += Character.toString(keys.charAt(i));
            }
        }
        return result;
    }
    
    public static boolean trouble(int a, int b)
	{
		String str1 = Integer.toString(a);
		String str2 = Integer.toString(b);
		char number = '\0';
		int count = 0;
		
		for (int i = 0; i < str1.length(); i++)
		{
			char ch = str1.charAt(i);
			if (ch == number)
				count++;
			else
			{
				number = ch;
				count = 0;
			}
			if (count == 2)
				if (str2.indexOf(String.copyValueOf(new char[] { number, number })) != -1)
					return true;
				else
					count = 0;
		}
		return false;
	}
}