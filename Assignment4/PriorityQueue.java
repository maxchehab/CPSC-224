
/* 
 * PriorityQueue extends Queue and allows for priority queuing
 * 
 * CPSC 224-02, Spring 2018
 * Programming Assignment #4
 * 
 * @author Maxwell Chehab 
 *
 * @version v1.0 2/22/18 
 */
public class PriorityQueue extends Queue {
    /*
    * Queue constructor creates a queue of size (int limit)
    * 
    * @param int limit, size of queue
    * @returns a new Queue
    * @throw null
    */
    public PriorityQueue(int limit) {
        super(limit + 1);
    }

    /*
    * isFull checks if queue is full.
    * 
    * @param void
    * @returns boolean representing if queue is full
    * @throw null
    */
    public boolean isFull() {
        return count == limit - 1;
    }

    /*
    * enqueue adds a task to the end of a queue 
    * and sorts by priority
    * 
    * @param Task task
    * @returns void
    * @throw null
    */
    public void enqueue(Task task) {
        super.enqueue(task);
        int i = front;

        do {
            int k = front;
            while (k != back) {
                if (tasks[(k + 1) % limit] != null && tasks[k].getPriority() < tasks[(k + 1) % limit].getPriority()) {
                    Task tempTask = new Task(tasks[k]);
                    tasks[k] = new Task(tasks[(k + 1) % limit]);
                    tasks[(k + 1) % limit] = tempTask;
                    k = front;
                }
                k = (k + 1) % limit;
            }
            i = (i + 1) % limit;

        } while (i != back);

    }

    /*
    * toString overrrides the `toString` method for this class
    * 
    * @param
    * @returns String representation of the Queue class
    * @throw null
    */
    @Override
    public String toString() {
        String output = "";
        int i = front;

        do {
            output += tasks[i].getDescription() + " : " + tasks[i].getPriority() + "\n";
            i = (i + 1) % limit;
        } while (i != back);

        return output;
    }
}