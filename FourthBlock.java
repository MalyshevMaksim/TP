import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;
import java.util.HashSet;
//import java.util.Integer;

public class FourthBlock {
    public static void main(String[] args) {
        System.out.println();
        Scanner in = new Scanner(System.in);

        // Первая задача
        System.out.println("Первая задача");
        System.out.println(essayFormated(10, 7, "hello my name is Bessie and this is my essay"));
        System.out.println();

        // Вторая задача
        System.out.println("Вторая задача");
        System.out.println(split("()()()(())"));
        System.out.println();

        // Третья задача
        System.out.println("Третья задача");
        System.out.println(toCamelCase("to_cammel_case"));
        System.out.println(toSnakeCase("toSnakeCase"));
        System.out.println();

        // Четвертая задача
        System.out.println("Четвертая задача");
        double[] arr = new double[] {9, 17, 30, 1.5};
        System.out.println(overTime(arr));
        System.out.println();

        // Пятая задача
        System.out.println("Пятая задача");
        System.out.println(BMI(55, 1.65));
        System.out.println();

        // Шестая задача
        System.out.println("Шестая задача");
        System.out.println(bugger(999));
        System.out.println();

        // Седьмая задача
        System.out.println("Седьмая задача");
        System.out.println(toStarShorthand("abbccc"));
        System.out.println();

        // Восьмая задача
        System.out.println("Восьмая задача");
        System.out.println(doesRhyme("Sam I am!", "Green eggs and HAM"));
        System.out.println();

        // Девятая задача
        System.out.println("Девятая задача");
        System.out.println(trouble(666789, 12345667));
        System.out.println();

        // Десятая задача
        System.out.println("Десятая задача");
        System.out.println(countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
        System.out.println();
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
            res += " Underweight";
        else if (val >= 18.5 && val < 25)
            res += " Normal weight";
        else
            res += " Overweight";
        return res;
    }

    public static String overTime(double[] array)
	{
        double standartBegin = 9;
        double standartEnd = 17;

        double begin = array[0];
        double end = array[1];
        double workingRate = array[2];
        double multiplier = array[3];
        double overTime = 0;
        double reg = 1;

        if (begin < standartBegin && end < standartBegin)
			overTime = end - begin;
		else if (begin < standartBegin && end >= standartBegin && end <= standartEnd)
		{
			overTime = standartBegin - begin;
			reg = end - standartBegin;
		}
		else if (begin < standartBegin && end > standartEnd)
		{
			overTime = standartBegin - begin + end - standartEnd;
			reg = standartBegin + standartEnd;
		}
		else if (begin >= standartBegin && begin <= standartEnd && end >= standartBegin && end <= standartEnd)
		{
			reg = end - begin;
		}
		else if (begin >= standartBegin && begin <= standartEnd && end > standartEnd)
		{
			reg = standartEnd - begin;
			overTime = end - standartEnd;
		}
		else
            overTime = end - begin;

        return "$" + Double.toString(reg * workingRate + overTime * workingRate * multiplier);
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
				val *= Integer.parseInt((str.substring(i, i+1)));
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

    public static boolean doesRhyme(String a, String b) {
        String vowels = "EYUUOA";

        String firstLastWord = a.substring(a.lastIndexOf(" ") + 1);
        String secondLastWord = b.substring(b.lastIndexOf(" ") + 1);

        ArrayList<String> firstVowels = new ArrayList<String>();
        ArrayList<String> secondVowels = new ArrayList<String>();

        for(int i = 0; i < firstLastWord.length(); i++) {
            if(vowels.contains(Character.toString(firstLastWord.charAt(i))) || vowels.contains(Character.toString(firstLastWord.charAt(i)).toUpperCase())) {
                String k = Character.toString(firstLastWord.charAt(i)).toUpperCase();
                firstVowels.add(k);
            }
        }
        for(int i = 0; i < secondLastWord.length(); i++) {
            if(vowels.contains(Character.toString(secondLastWord.charAt(i))) || vowels.contains(Character.toString(secondLastWord.charAt(i)).toUpperCase())) {
                String k = Character.toString(secondLastWord.charAt(i)).toUpperCase();
                secondVowels.add(k);
            }
        }

        if(secondVowels.size() != firstVowels.size()) {
            return false;
        }

        for(int i = 0; i < firstVowels.size(); i++) {
            if(!secondVowels.contains(firstVowels.get(i)))
                return false;
            else 
                secondVowels.remove(firstVowels.get(i));
        }
        return true;
    }

    public static boolean trouble(int a, int b)
	{
		String str1 = Integer.toString(a);
		String str2 = Integer.toString(b);
		int counter = 0;
		
		for (int i = 0; i < str1.length() - 1; i++)
		{
            if(str1.charAt(i) == str1.charAt(i + 1)) 
                ++counter;
            else
            {   
                if(counter == 2) {
                    counter = 0;
                    for(int j = 0; j < str2.length() - 1; j++) {
                        if(str1.charAt(i) == str2.charAt(j) && str2.charAt(j) == str2.charAt(j + 1))
                            return true;
                        else
                            counter = 0;
                    }
                }
                else {
                    counter = 0;
                }
            }
		}
		return false;
    }
    
    public static int countUniqueBooks(String a, Character b) {

        ArrayList<String> substrings = new ArrayList<String>();

        int firstIndex = 0;
        int lastIndex = 0;
        int iterator = 0;
        int count = 0;

        while(true) {
            firstIndex = a.substring(iterator, a.length()).indexOf(Character.toString(b));
            lastIndex = a.substring(iterator + firstIndex + 1, a.length()).indexOf(Character.toString(b));

            if(lastIndex == -1)
                break;

            String substr = a.substring(iterator + firstIndex + 1, iterator + firstIndex + lastIndex + 1);
            substrings.add(substr);
            iterator += firstIndex + lastIndex + 2;
        }

        HashSet<Character> characrers = new HashSet<Character>();

        for(String subs: substrings) {
            for(int i = 0; i < subs.length(); i++)
                characrers.add(subs.charAt(i));
            count += characrers.size();
            characrers.clear();
        }
        return count;
    }
}
