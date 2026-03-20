package assignment2;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class QuestBoard {
	Map<Integer, Quest> questById;
	Map<Student, List<Quest>> assignments;
	
	public QuestBoard()
	{
		questById = new HashMap<>();
		assignments = new HashMap<>();
	}
	
	public void addQuest(Quest q)
	{
		int qId = q.getId();
		if(questById.containsKey(qId))
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
		
		if(!(assignments.containsKey(s)))
			assignments.put(s, new ArrayList<Quest>());
		
		List<Quest> list= assignments.get(s);
		list.add(q);
	}
	
	public void printAllQuests()
	{
		for(Map.Entry<Integer, Quest> entry : questById.entrySet())
		{
			System.out.println("ID: " + entry.getKey() + ", Quest");
		}
	}
	
	public void printAssignmentsFor(Student s)
	{
		for(Quest q : assignments.get(s))
		{
			System.out.println(q.toString());
		}
	}
}
