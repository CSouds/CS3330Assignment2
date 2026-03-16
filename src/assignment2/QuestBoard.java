import java.util.HashSet;
import java.util.List;

public class QuestBoard {
	Map<Integer, Quest> questById; = new Map<>;
	Map<Student, List<Quest>> assignments; = new Map<>;
	
	public QuestBoard()
	{
		questById = new Map<>;
		assignments = new Map<>;
	}
	
	public void addQuest(Quest q)
	{
		qId = q.getId();
		if(questById.containsValue(qId))
			throw new IllegalArgumentException("Id taken by other quest.");
		questById.put(qId, q);
	}
	
	public Quest findQuest(int id)
	{
		return questById.get(id); // returns null if missing
	}
	
	public assignQuest(Student s, int questId)
	{
		q = findQuest(questId);
		
		if(!(assignments.containsValue(s)))
			assignments.put(s, new ArrayList<Quest>);
		
	}
}
