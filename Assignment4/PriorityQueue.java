import java.security.spec.DSAGenParameterSpec;

public class PriorityQueue extends Queue {
    public PriorityQueue(int limit) {
        super(limit + 1);
    }

    public boolean isFull() {
        return count == limit - 1;
    }

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