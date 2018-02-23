
/* 
 * Queue class is a data structure that stores Tasks in a 
 * queue data structure.
 * 
 * CPSC 224-02, Spring 2018
 * Programming Assignment #4
 * 
 * @author Maxwell Chehab 
 *
 * @version v1.0 2/22/18 
 */
public class Queue {
    protected Task[] tasks;
    protected int front = 0, back = 0, count = 0;
    protected final int limit;

    /*
    * Queue constructor creates a queue of size (int limit)
    * 
    * @param int limit, size of queue
    * @returns a new Queue
    * @throw null
    */
    public Queue(int limit) {
        this.limit = limit;
        this.front = 0;
        this.back = 0;
        this.count = 0;
        this.tasks = new Task[limit];
    }

    /*
    * isEmpty checks if queue is empty.
    * 
    * @param void
    * @returns boolean representing if queue is empty
    * @throw null
    */
    public boolean isEmpty() {
        return count == 0;
    }

    /*
    * isFull checks if queue is full.
    * 
    * @param void
    * @returns boolean representing if queue is full
    * @throw null
    */
    public boolean isFull() {
        return count == limit;
    }

    /*
    * enqueue adds a task to the end of a queue
    * 
    * @param Task task
    * @returns void
    * @throw null
    */
    public void enqueue(Task task) {
        if (!isFull()) {
            tasks[back] = task;
            back = (back + 1) % limit;
            count++;
        }
    }

    /*
    * dequeue removes a Task from the front of a queue
    * 
    * @param void
    * @returns void
    * @throw null
    */

    public void dequeue() {
        if (!isEmpty()) {
            tasks[front] = null;
            front = (front + 1) % limit;
            count--;
        }
    }

    /*
    * display prints out the queue
    * 
    * @param void
    * @returns void
    * @throw null
    */
    public void display() {
        System.out.println(this);
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
            output += tasks[i].getDescription() + "\n";
            i = (i + 1) % limit;
        } while (i != back);

        return output;
    }
}
