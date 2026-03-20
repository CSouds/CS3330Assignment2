package assignment2;

public abstract class AbstractQuest implements Quest
{
	private final int id;
	private final String title;
	private final int basePoints;
	private boolean completed;
	
	public AbstractQuest(int id, String title, int basePoints)
	{
		if(id <= 0)
		{
			throw new IllegalArgumentException("Quest id must be > 0.");
		}
		if(title == null || title.isBlank())
		{
			throw new IllegalArgumentException("Quest title must not be null or blank.");
		}
		if(basePoints <= 0)
		{
			throw new IllegalArgumentException("Quest base points must be > 0.")
		}
		this.id = id;
		this.title = title;
		this.basePoints = basePoints;
		this.completed = false;
	}
	
	@Override
	public int getId()
	{
		return id;
	}
	
	@Override
	public String getTitle()
	{
		return title;
	}
	
	@Override
	public int getBasePoints()
	{
		return basePoints;
	}
	
	@Override
	public boolean isCompleted()
	{
		return completed;
	}
	
	void markCompleted()
	{
		this.completed = true;
	}
	
	@Override
	public String toString()
	{
		return "Quest{id=" + id +
				", title = '" + title + '\'' +
				", basePoints =" + basePoints +
				", completed=" + completed + "}";
				
	}
	
	
}
