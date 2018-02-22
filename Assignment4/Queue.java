public class Queue {
    protected Task[] tasks;
    protected int front = 0, back = 0, count = 0;
    protected final int limit;

    public Queue(int limit) {
        this.limit = limit;
        this.front = 0;
        this.back = 0;
        this.count = 0;
        this.tasks = new Task[limit];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == limit;
    }

    public void enqueue(Task task) {
        if (!isFull()) {
            tasks[back] = task;
            back = (back + 1) % limit;
            count++;
        }
    }

    public void dequeue() {
        if (!isEmpty()) {
            tasks[front] = null;
            front = (front + 1) % limit;
            count--;
        }
    }

    public void display() {
        System.out.println(this);
    }

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
