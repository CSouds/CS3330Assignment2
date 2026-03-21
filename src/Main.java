import assignment2.*;

public class Main {

	public static void main(String[] args) {
		QuestBoard b = new QuestBoard(); // initializing board
		
		Student s1 = new Student("Connor"); // initializing students
		Student s2 = new Student("Chris");
		Student s3 = new Student("Connor");
		
		Quest sq1 = new StreakQuest(1, "quest one", 10, 3); // initializing quests and adding them to board
		b.addQuest(sq1);
		Quest sq2 = new StreakQuest(2, "quest two", 14, 5);
		b.addQuest(sq2);
		Quest vq1 = new VolunteerQuest(3, "quest three", 15, 6);
		b.addQuest(vq1);
		Quest vq2 = new VolunteerQuest(4, "quest four", 19, 8);
		b.addQuest(vq2);
		Quest eq1 = new EventCheckInQuest(5, "quest five", 5, "luncheon");
		b.addQuest(eq1);
		Quest eq2 = new EventCheckInQuest(6, "quest six", 6, "awards");
		b.addQuest(eq2);
		
		b.assignQuest(s3, sq1.getId()); // assigning quests
		b.assignQuest(s1, sq2.getId());
		b.assignQuest(s3, eq2.getId());
		b.assignQuest(s2, vq1.getId());
		
		b.printAssignmentsFor(s3); // print quests to view
		b.printAllQuests();
		
		b.completeQuest(s3, sq1.getId()); // complete some quests
		b.completeQuest(s3, eq2.getId());
		b.completeQuest(s2,  vq1.getId());
		
		b.printAllQuests(); // view new completions
		
		b.completeQuest(s1, eq1.getId()); // invalid behavior: completes quest student does not have
	}
}
