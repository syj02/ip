/**
 * Represents a specific type of task called "Deadline" in the Jane task management application.
 * It extends the base Task class and includes additional information about the deadline.
 */
public class Deadline extends Task {
    /** The deadline associated of the task. */
    protected String by;

    /**
     * Constructs a Deadline object with the specified description and deadline.
     *
     * @param description The description of the deadline task.
     * @param by The deadline information associated with the task.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Retrieves the deadline information associated with the task.
     *
     * @return The deadline information.
     */
    public String getBy() {
        return by;
    }

    /**
     * Generates a string representation of the Deadline task, including its specialized status icon and deadline information.
     *
     * @return A formatted string representing the Deadline task.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + getBy() + ")";
    }
}