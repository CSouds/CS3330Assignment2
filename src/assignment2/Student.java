import java.util.Objects;

public class Student {
	private String name;
	private int points;
	
	public Student(String name)
	{
		if(!name)
		{
			throw new IllegalArgumentException("Invalid name");
		}
		this.name = name;
		
		this.points = 0;
	}
	
	public getName()
	{
		return this.name;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Student))
			return false;
		Student s = (Student) obj;
		if(getName() == s.getName())
		{
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.name.intValue());
	}
	
}
