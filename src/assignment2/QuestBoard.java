import java.util.HashSet;
import java.util.List;

public class QuestBoard {
	Map<Integer, Quest> questById;
	Map<Student, List<Quest>> assignments;
	
	public QuestBoard()
	{
		questById = new Map<>;
		assignments = new Map<>;
	}
	
	public void addQuest(Quest q)
	{
		qId = q.getId();
		if(questById.containsValue(qId))
			throw new IllegalArgumentException("ID taken by other quest.");
		questById.put(qId, q);
	}
	
	public Quest findQuest(int id)
	{
		return questById.get(id); // returns null if missing
	}
	
	public void assignQuest(Student s, int questId) // design choice: allows duplicate quest for student
	{
		Quest q = findQuest(questId);
		
		if(!(assignments.containsValue(s)))
			assignments.put(s, new ArrayList<Quest>);
		
		list = assignments.get(s);
		list.add(q);
	}
	
	public void printAllQuests()
	{
		for(Map.entry<Integer, Quest> entry : map.entrySet())
		{
			System.out.println("ID: " + entry.getKey() + ", Quest");
		}
	}
	
	public void printAssignmentsFor(Student s)
	{
		for(Quest q : assignments.get(s))
		{
			q.print();
		}
	}
}
