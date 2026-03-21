package assignment2;

public interface Quest { // interface to be implemented in AbstractQuest
	int getId();
	String getTitle();
	int getBasePoints();
	boolean isCompleted();
	int completeFor(Student s);
}
