public class Test {
    public static void main(String[] args) {

        PriorityQueue queue = new PriorityQueue(6);
        queue.enqueue(new Task("First task.", 1));
        queue.enqueue(new Task("Second task.", 40));
        queue.enqueue(new Task("Second task.", 20));
        queue.enqueue(new Task("Second task.", 4));
        queue.enqueue(new Task("Second task.", 3));
        queue.enqueue(new Task("Second task.", 20));
        queue.dequeue();
        queue.enqueue(new Task("Second task.", 20));

        queue.display();
    }
}