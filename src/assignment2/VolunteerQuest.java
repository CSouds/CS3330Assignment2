package assignment2;

public class VolunteerQuest extends AbstractQuest{

	private final int hours;
	
	public VolunteerQuest(int id, String title, int basePoints, int hours)
	{
		super(id, title, basePoints); // call super constructor for shared methods
		
		if(hours <= 0) // hours must be positive
		{
			throw new IllegalArgumentException("Hours must be > 0");
		}
		
		this.hours = hours;
	}
	
	public int getHours() // getter for hours
	{
		return hours;
	}
	
	@Override
	public int completeFor(Student s) // complete a quest and add the points to the students
	{
		if(s == null)
		{
			throw new IllegalArgumentException("Student must not be null.");
		}
		if(isCompleted())
		{
			throw new IllegalStateException("Quest is already completed");
		}
		
		int awarded = getBasePoints() * hours; // add the points and mark complete
		s.addPoints(awarded);
		markCompleted();
		return awarded;
	}
	@Override
	public String toString() // toString for printing
	{
		return "VolunteerQuest{id=" + getId() +
				", title = '" + getTitle() + '\'' +
				", basePoints = " + getBasePoints() +
				", completed = " + isCompleted() +
				", hours = '" + hours +
				"}";
	}
	
}
