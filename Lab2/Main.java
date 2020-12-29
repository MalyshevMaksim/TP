import java.util.Collections;
import java.util.LinkedList;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		LinkedList<Country> countries = new LinkedList<>();
		String buff = "";
		
		try (FileReader in = new FileReader("/Users/maksim/Desktop/TP/Lab2/countries.txt"))
		{
			int val;
			while ((val = in.read()) != -1)
			{
				if ((char)val == ',')
				{
					continue;
				}
				buff += (char)val;
			}
		}
		catch(IOException ex)
		{
			System.out.println(ex.getMessage());
		}
		
		String[] line = buff.split("\n");
		for (int i = 0; i < line.length; i++)
		{
			String[] cell = line[i].split("\t");
			if (cell.length != 4)
				continue;
			
			String name = cell[0];
			int num = Integer.parseInt(cell[1]);
			float total = Float.parseFloat(cell[2]);
			float national = Float.parseFloat(cell[3]);
			
			Country country = new Country(name, num, total, national);
			countries.add(country);
		}
		
		Collections.sort(countries);
		
		int val1 = 0;
		float val2 = 0;
		ArrayList<Integer> totalNum = new ArrayList<>(countries.size());
		
		System.out.printf("%-25s%-20s%-15s%-15s%n", "Название", "Число иммигрантов", "Общий процент", "Процент от населения");
		for (Country country : countries)
		{
			System.out.printf("%-25s%-20s%-15s%-15s%n", country.getName(), country.getNum(), country.getTotal(), country.getNational());
			int num = country.getNum();
			float total = country.getTotal();
			float national = country.getNational();
			
			val1 += num;
			val2 += total;
			totalNum.add((int)Math.round(num * 100.0 / national));
		}
		
		System.out.println();
		System.out.println("Общее количество иммигрантов: " + Integer.toString(val1));
		System.out.println("Общий процент иммигрантов: " + Float.toString(val2));
		System.out.println("Страна с самым большим процентом иммигрантов: " + countries.get(0).getName());
		System.out.println("Страна с самым маленьким процентом иммигрантов: " + countries.get(countries.size()-1).getName());

		System.out.println("");
		System.out.println("Общая численность населения:");
		for (int i = 0; i < countries.size(); i++)
		{
			System.out.println(countries.get(i).getName() + ": " + Integer.toString(totalNum.get(i)));
		}
	}
}

public class Country implements Comparable<Country> {
	private String name = "";
	private int num = 0;
	private float total = 0;
	private float national = 0;
	
	public Country() { }
	
	public Country(String name, int num, float total, float national)
	{
		this.name = name;
		this.num = num;
		this.total = total;
		this.national = national;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setNum(int num)
	{
		this.num = num;
	}
	
	public void setTotal(float total)
	{
		this.total = total;
	}
	
	public void setNational(float national)
	{
		this.national = national;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getNum()
	{
		return num;
	}
	
	public float getTotal()
	{
		return total;
	}
	
	public float getNational()
	{
		return national;
	}
	
	@Override
	public int compareTo(Country other)
	{
		float res = other.national - this.national;
		if (res < 0)
		{
			return -1;
		}
		else if(res > 0)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
}