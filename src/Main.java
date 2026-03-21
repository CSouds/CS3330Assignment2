import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import assignment2.*;

public class Main {

	public static void main(String[] args) {
		QuestBoard b = new QuestBoard(); // initializing board
		Set<Student> s = new HashSet<>();
		
		Student s1 = new Student("Connor"); // initializing students
		s.add(s1);
		Student s2 = new Student("Chris");
		s.add(s2);
		Student s3 = new Student("Bobby");
		s.add(s3);
		Student s4 = new Student("Bobby");
		s.add(s4);
		System.out.println("Student set size: " + s.size());
		
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
		
		System.out.println("Student assignments:");
		System.out.println("Student 1:");
		b.printAssignmentsFor(s1); // print quests to view
		System.out.println("Student 2:");
		b.printAssignmentsFor(s2);
		System.out.println("Student 3:");
		b.printAssignmentsFor(s3);
		
		System.out.println("All incomplete quests:");
		b.printAllQuests();
		
		b.completeQuest(s3, sq1.getId()); // complete some quests
		b.completeQuest(s3, eq2.getId());
		b.completeQuest(s2,  vq1.getId());
		
		System.out.println("All completed quests:");
		b.printAllQuests();
		
		System.out.println("s1 points: " + s1.getPoints()); // print all points
		System.out.println("s2 points: " + s2.getPoints());
		System.out.println("s3 points: " + s3.getPoints());
		System.out.println("Total points: " + RewardUtil.sumPoints(new ArrayList<>(s)));
		
		b.completeQuest(s1, eq1.getId()); // invalid behavior: completes quest student does not have
	}
}
