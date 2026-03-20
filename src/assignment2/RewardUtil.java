
public class RewardUtil {
	public static <T> void printAll(List<T> items)
	{
		for(T item : items)
			System.out.println(item.toString());
	}
	
	public static int sumPoints(List<? extends Student> students)
	{
		int total = 0;
		
		for(Student student : students)
		{
			total += student.getPoints()
		}
	}
	
	return total;
}
