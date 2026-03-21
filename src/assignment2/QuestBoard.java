package assignment2;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class QuestBoard {
	private Map<Integer, Quest> questById; // maps to store data
	private Map<Student, List<Quest>> assignments;
	
	public QuestBoard()
	{
		questById = new HashMap<>();
		assignments = new HashMap<>();
	}
	
	public void addQuest(Quest q)
	{
		int qId = q.getId(); // validate id
		if(questById.containsKey(qId))
			throw new IllegalArgumentException("ID taken by other quest.");
		questById.put(qId, q); // add quest if valid id
	}
	
	public Quest findQuest(int id)
	{
		return questById.get(id); // returns null if missing
	}
	
	public void assignQuest(Student s, int questId)
	{
		Quest q = findQuest(questId); // get quest
		if(q == null)
			throw new IllegalArgumentException("Quest does not exist");
		
		if(!(assignments.containsKey(s))) // check if student has been assigned quest
			assignments.put(s, new ArrayList<Quest>());
		
		List<Quest> list = assignments.get(s); // get student list
		
		if(!list.contains(q)) // design choice: same quest ID cannot be assigned to student twice
		{
			list.add(q);
		} // acts as if quest was still added if it is double added in case user was unsure of state
	}
	
	public int completeQuest(Student s, int questId)
	{
		List<Quest> list= assignments.get(s); // get list
		if(list == null)
			throw new IllegalStateException("Student assigned no quests");
		
		Quest q = findQuest(questId);
		if(q == null)
		    throw new IllegalArgumentException("Quest does not exist: " + questId);
		
		if(list.contains(q)) // check that student has been assigned quest
			return q.completeFor(s); // complete and add points
		else
			throw new IllegalStateException("Student not assigned quest");
	}
	
	public void printAllQuests()
	{
		for(Quest q : questById.values()) // iterate through all quests
		{
			System.out.println(q.toString());
		}
	}
	
	public void printAssignmentsFor(Student s)
	{
		List<Quest>  list = assignments.get(s);
		if(list == null)
			throw new IllegalStateException("Student assigned no quests");
		
		for(Quest q : list) // iterate through all quests in student
		{
			System.out.println(q.toString());
		}
	}
}
