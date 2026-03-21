package assignment2;

public class EventCheckInQuest extends AbstractQuest {
	private final String eventName;
	
	public EventCheckInQuest(int id, String title, int basePoints, String eventName)
	{
		super(id, title, basePoints); // super constructor for shared values
		
		if(eventName == null || eventName.isBlank()) // check valid name
		{
			throw new IllegalArgumentException("Event name must not be null or blank.");
		}
		
		this.eventName = eventName;
	}

	public String getEventName() // get event name
	{
		return eventName;
	}
	
	@Override
	public int completeFor(Student s) // complete quest and add points
	{
		if(s == null)
		{
			throw new IllegalArgumentException("Student must not be null.");
		}
		if(isCompleted())
		{
			throw new IllegalStateException("Quest is already completed.");
		}
		
		int awarded = getBasePoints(); // completes and points are added
		s.addPoints(awarded);
		markCompleted();
		return awarded;
	}
	
	@Override
	public String toString() // toString for printing
	{
		return "EventCheckInQuest{id=" + getId() +
				", title = '" + getTitle() + '\'' +
				", basePoints = " + getBasePoints() +
				", completed = " + isCompleted() +
				", eventName = '" + eventName + '\'' +
				"}";
	}
}
