package assignment2;


public class StreakQuest extends AbstractQuest {
    private final int days;

    public StreakQuest(int id, String title, int basePoints, int days) {
        super(id, title, basePoints); // super for shared values

        if (days <= 0) { // invariant: days must be positive
            throw new IllegalArgumentException("Days must be positive.");
        }

        this.days = days;
    }

    public int getDays() { // getter for days
        return days;
    }

    @Override
    public int completeFor(Student s) { // completes a quest and adds the points to user
        if (s == null) {
            throw new IllegalArgumentException("Student must not be null.");
        }
        if (isCompleted()) {
            throw new IllegalStateException("Quest is already completed.");
        }

        // Design choice: linear streak bonus = basePoints + (days * 2)
        int awarded = getBasePoints() + (days * 2);
        s.addPoints(awarded);
        markCompleted();
        return awarded;
    }

    @Override
    public String toString() { // toString for printing
        return "StreakQuest{id=" + getId() +
               ", title='" + getTitle() + '\'' +
               ", basePoints=" + getBasePoints() +
               ", completed=" + isCompleted() +
               ", days=" + days +
               "}";
    }
}