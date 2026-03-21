package assignment2;

public class VolunteerQuest extends AbstractQuest{

	private final int hours;
	
	public VolunteerQuest(int id, String title, int basePoints, int hours)
	{
		super( id, title, basePoints);
		
		if(hours <= 0)
		{
			throw new IllegalArgumentException("Hours must be > 0");
		}
		
		this.hours = hours;
	}
	
	public int getHours()
	{
		return hours;
	}
	
	@Override
	public int completeFor(Student s)
	{
		if(s == null)
		{
			throw new IllegalArgumentException("Student must not be null.");
		}
		if(isCompleted())
		{
			throw new IllegalStateException("Quest is already completed");
		}
		
		int awarded = getBasePoints() * hours;
		s.addPoints(awarded);
		markCompleted();
		return awarded;
	}
	@Override
	public String toString()
	{
		return "VolunteerQuest{id=" + getId() +
				", title = '" + getTitle() + '\'' +
				", basePoints = " + getBasePoints() +
				", completed = " + isCompleted() +
				", hours = '" + hours +
				"}";
	}
	
}
