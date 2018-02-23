
/* 
 * This program shows the capabilities of a Queue and
 * Priority Queue
 * 
 * CPSC 224-02, Spring 2018
 * Programming Assignment #4
 * 
 * @author Maxwell Chehab 
 *
 * @version v1.0 2/22/18 
 */

public class Test {
    /*
    * main thourougly test the enqueue and dequeue functionality
    * of Queue and PriorityQueue
    * 
    * @param String[] args, optional command line arguments.
    * @returns void
    * @throw null
    */
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(6);
        priorityQueue.enqueue(new Task("Task 1.", 1));
        priorityQueue.enqueue(new Task("Task 2.", 40));
        priorityQueue.display();
        priorityQueue.enqueue(new Task("Task 3.", 20));
        priorityQueue.display();
        priorityQueue.enqueue(new Task("Task 4.", 4));
        priorityQueue.display();
        priorityQueue.enqueue(new Task("Task 5.", 3));
        priorityQueue.enqueue(new Task("Task 6.", 20));
        priorityQueue.dequeue();
        priorityQueue.enqueue(new Task("Task 7.", 20));
        priorityQueue.enqueue(new Task("Task 8.", 4));
        priorityQueue.enqueue(new Task("Task 9.", 3));
        priorityQueue.display();

        Queue queue = new Queue(10);
        queue.enqueue(new Task("Task 1."));
        queue.enqueue(new Task("Task 2."));
        queue.display();
        queue.enqueue(new Task("Task 3."));
        queue.display();
        queue.enqueue(new Task("Task 4."));
        queue.display();
        queue.enqueue(new Task("Task 5."));
        queue.enqueue(new Task("Task 6."));
        queue.dequeue();
        queue.enqueue(new Task("Task 7."));
        queue.enqueue(new Task("Task 8."));
        queue.display();
    }
}