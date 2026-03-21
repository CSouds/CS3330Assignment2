package assignment2;

import java.util.Objects;

public class Student {
	private String name;
	private int points;
	
	public Student(String name)
	{
		if(name == null || name.isEmpty()) // valid name check
		{
			throw new IllegalArgumentException("Invalid name");
		}
		this.name = name;
		
		this.points = 0; // start points at zero, invariant: cannot be < 0
	}
	
	public String getName() // getter for name
	{
		return this.name;
	}
	
	public int getPoints() // getter for points
	{
		return this.points;
	}
	
	public void addPoints(int amount) // adds points from completed quest
	{
		if(getPoints() + amount < 0)
			throw new IllegalArgumentException("Points minus addition < 0");
		this.points += amount;
	}
	
	@Override
	public String toString() // toString for printing
	{
		return "Student [name=" + name + ", points=" + points + "]";
	}
	
	@Override
	public boolean equals(Object obj) // equals for hashset
	{
		if(!(obj instanceof Student))
			return false;
		Student s = (Student) obj;
		return getName().equals(s.getName());
	}
	
	@Override
	public int hashCode() { // for hashset
		return Objects.hash(name);
	}
}
