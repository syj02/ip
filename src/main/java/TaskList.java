public class TaskList {
    protected Task[] list;
    protected int count;

    public TaskList() {
        this(new Task[100], 0);
    }

    public TaskList(Task[] list, int count) {
        this.list = list;
        this.count = count;
    }

    public void addTask(Task task) {
        this.list[count] = task;
        this.count = count + 1;
        task.sequence = count;
    }

    public int getCount() {
        return count;
    }

    public void printList() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < this.count; i++) {
            System.out.println(this.list[i].getSequence() + "." + this.list[i]);
        }
    }

    public void markAsDone(int sequence) {
        Task task = this.list[sequence];
        task.isDone(true);
        System.out.println("Nice! I've marked this task as done:\n" + task);

    }

    public void markAsUndone(int sequence) {
        Task task = this.list[sequence];
        task.isDone(false);
        System.out.println("OK, I've marked this task as not done yet:\n" + task);
    }

    public void processTodo(String input) {
        Todo todo = new Todo(input);
        this.addTask(todo);
        System.out.println("Got it. I've added this task:\n"
                + todo
                + "\n"
                + "Now you have "
                + this.getCount()
                + " tasks in the list.");
    }

    public void processDeadline(String input) {
        String[] deadlineInput = input.split("/", 2);
        Deadline deadline = new Deadline(deadlineInput[0],
                deadlineInput[1].replace("/", "").replace("by ", ""));
        this.addTask(deadline);
        System.out.println("Got it. I've added this task:\n"
                + deadline
                + "\n"
                + "Now you have "
                + this.getCount()
                + " tasks in the list.");
    }

    public void processEvent(String input) {
        String[] eventInput = input.split("/", 3);
        Event event = new Event(eventInput[0],
                eventInput[1].replace("/", "").replace("from ", ""),
                eventInput[2].replace("/to", "").replace("to ", ""));
        this.addTask(event);
        System.out.println("Got it. I've added this task:\n"
                + event
                + "\n"
                + "Now you have "
                + this.getCount()
                + " tasks in the list.");
    }
}
