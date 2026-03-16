
public class EventCheckInQuest extends AbstractQuest {
	private final String eventName;
	
	public EventCheckInQuest(int id, String title. int basePoints, String eventName)
	{
		super(id,title,basePoints);
		
		if(eventName == null || eventName.isBlank())
		{
			throw new IllegalArgumentException("Event name must not be null or blank.");
		}
		
		this.eventName = eventName;
	}

	public String getEventName()
	{
		return eventName;
	}
	
	@Override public int completeFor(Student s)
	{
		if(s == null)
		{
			throw new IllegalArgumentException("Student must not be null.");
		}
		if(isCompleted())
		{
			throw new IllegalStateException("Quest is already completed.");
		}
		
		int awarded = getBasePoints();
		s.addPoints(awarded);
		markCompleted();
		return awarded;
	}
	
	@Override String toString()
	{
		return "EventCheckInQuest{id=" + getId() +
				", title = '" + getTitle() + '\'' +
				", basePoints = " + getBasePoints() +
				", completed = " + is Completed() +
				", eventName = '" + eventName + '\'' +
				"}";
	}
}
