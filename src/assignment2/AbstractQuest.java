package assignment2;

public abstract class AbstractQuest implements Quest
{
	private final int id;
	private final String title;
	private final int basePoints;
	private boolean completed;
	
	public AbstractQuest(int id, String title, int basePoints)
	{
		if(id <= 0) // validate id
		{
			throw new IllegalArgumentException("Quest id must be > 0.");
		}
		if(title == null || title.isBlank()) // title must be not null
		{
			throw new IllegalArgumentException("Quest title must not be null or blank.");
		}
		if(basePoints <= 0) // points must always be 0
		{
			throw new IllegalArgumentException("Quest base points must be > 0.");
		}
		this.id = id;
		this.title = title;
		this.basePoints = basePoints;
		this.completed = false;
	}
	
	@Override
	public int getId() // id getter
	{
		return id;
	}
	
	@Override
	public String getTitle() // title getter
	{
		return title;
	}
	
	@Override
	public int getBasePoints() // points getter
	{
		return basePoints;
	}
	
	@Override
	public boolean isCompleted() // check completed
	{
		return completed;
	}
	
	void markCompleted() // mark as completed
	{
		if(completed == false)
			this.completed = true;
		else
			throw new IllegalStateException("Quest already marked complete.");
	}
	
	@Override
	public String toString() // to string for printing
	{
		return "Quest{id=" + id +
				", title = '" + title + '\'' +
				", basePoints =" + basePoints +
				", completed=" + completed + "}";
	}
}
