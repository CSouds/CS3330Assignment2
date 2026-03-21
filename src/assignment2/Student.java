package assignment2;

import java.util.Objects;

public class Student {
	private String name;
	private int points;
	
	public Student(String name)
	{
		if(name == null || name.isEmpty())
		{
			throw new IllegalArgumentException("Invalid name");
		}
		this.name = name;
		
		this.points = 0;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getPoints()
	{
		return this.points;
	}
	
	public void addPoints(int amount)
	{
		if(getPoints() + amount < 0)
			throw new IllegalArgumentException("Points minus addition < 0");
		this.points += amount;
	}
	
	@Override
	public String toString()
	{
		return "Student [name=" + name + ", points=" + points + "]";
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Student))
			return false;
		Student s = (Student) obj;
		return getName().equals(s.getName());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
