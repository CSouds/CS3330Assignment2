package assignment2;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class QuestBoard {
	private Map<Integer, Quest> questById;
	private Map<Student, List<Quest>> assignments;
	
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
		
		if(!list.contains(q)) // design choice: same quest ID cannot be assigned to student twice
		{
			list.add(q);
		} // acts as if quest was still added if it is double added in case user was unsure of state
	}
	
	public void completeQuest(Student s, int questId)
	{
		List<Quest> list= assignments.get(s);
		
		Quest q = findQuest(questId);
		
		if(list.contains(q))
			q.completeFor(s);
		else
			throw new IllegalStateException();
	}
	
	public void printAllQuests()
	{
		for(Quest q : questById.values())
		{
			System.out.println(q.toString());
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
