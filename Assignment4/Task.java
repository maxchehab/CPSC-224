
/* 
 * Task class is a data structure that contains a description 
 * priority.
 * 
 * CPSC 224-02, Spring 2018
 * Programming Assignment #4
 * 
 * @author Maxwell Chehab 
 *
 * @version v1.0 2/22/18 
 */
public class Task {
    private String description;
    private int priority;

    /*
    * Task constructor creates task with description and priority
    * 
    * @param int description, int priority
    * @returns a new Task
    * @throw null
    */
    public Task(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }

    /*
    * Task constructor creates task with description
    * 
    * @param int description
    * @returns a new Task
    * @throw null
    */
    public Task(String description) {
        this.description = description;
        this.priority = 0;
    }

    /*
    * Task constructor that copies from Task
    * 
    * @param Task task
    * @returns a new Task
    * @throw null
    */
    public Task(Task task) {
        this.description = task.getDescription();
        this.priority = task.getPriority();
    }

    /*
    * Task constructor creates an empty task
    * 
    * @param void
    * @returns a new Task
    * @throw null
    */
    public Task() {
        this.description = "";
        this.priority = 0;
    }

    /*
    * getDescription returns description
    * 
    * @param void
    * @returns String description
    * @throw null
    */
    public String getDescription() {
        return this.description;
    }

    /*
    * setDescription sets the description
    * 
    * @param int description
    * @returns void
    * @throw null
    */
    public void setDescription(String description) {
        this.description = description;
    }

    /*
    * getPriority returns priority
    * 
    * @param void
    * @returns int priority
    * @throw null
    */
    public int getPriority() {
        return priority;
    }

    /*
    * setPriority sets the priority
    * 
    * @param int priority
    * @returns void
    * @throw null
    */
    public void setPriority(int priority) {
        this.priority = priority;
    }
}