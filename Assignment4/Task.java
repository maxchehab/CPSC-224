public class Task {
    private String description;
    private int priority;

    public Task(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }

    public Task(String description) {
        this.description = description;
        this.priority = 0;
    }

    public Task(Task task) {
        this.description = task.getDescription();
        this.priority = task.getPriority();
    }

    public Task() {
        this.description = "";
        this.priority = 0;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}