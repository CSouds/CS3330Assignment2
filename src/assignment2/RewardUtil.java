package assignment2;

import java.util.ArrayList;

public class RewardUtil {
	public static <T> void printAll(ArrayList<T> items)
	{
		for(T item : items)
			System.out.println(item.toString());
	}
	
	public static int sumPoints(ArrayList<? extends Student> students)
	{
		int total = 0;
		
		for(Student student : students)
		{
			total += student.getPoints();
		}
		
		return total;
	}
}
