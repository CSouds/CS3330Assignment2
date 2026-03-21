package assignment2;

import java.util.List;

public class RewardUtil {
	public static <T> void printAll(List<T> items) // print all wildcard method
	{
		for(T item : items)
			System.out.println(item.toString());
	}
	
	public static int sumPoints(List<? extends Student> students) // adds points across all students and returns
	{
		int total = 0;
		
		for(Student student : students)
		{
			total += student.getPoints();
		}
		
		return total;
	}
}
