package Collections.QueueInterfaceExamples;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

// DelayQueue:
// Thread safe unbounded blocking queue
// Elements can only be taken from queue when their delay has expired
// Useful scheduling tasks to be executed after a certain delay
// Internally uses Priority Queue, same concept but uses time to compare
public class DelayQueueExample {
    public static void main(String[] args) {
        BlockingQueue<DelayedTask> tasks = new DelayQueue<>();
        try {
            tasks.put(new DelayedTask("Task 1", 3, TimeUnit.SECONDS));
            tasks.put(new DelayedTask("Task 2", 4, TimeUnit.SECONDS));
            tasks.put(new DelayedTask("Task 3", 2, TimeUnit.SECONDS));
        } catch(InterruptedException e) {
            System.out.println(e);
        }

        while(!tasks.isEmpty()) {
            try {
                DelayedTask task = tasks.take();
                System.out.println("Executed: " + task.getTaskName() + " at " + System.currentTimeMillis());
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class DelayedTask implements Delayed {
    private final String taskName;
    private final long startTime;

    public DelayedTask(String taskName, long delay, TimeUnit unit) {
        this.taskName = taskName;
//        startTime indicates after how many milliseconds task will start
        this.startTime = System.currentTimeMillis() + unit.toMillis(delay);
    }

    @Override
    public long getDelay(TimeUnit timeUnit) {
//        if subtract current time from startTime we will get how much time left
        long remaining = startTime - System.currentTimeMillis();
//        and convert that into milliseconds
        return timeUnit.convert(remaining, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.compare(startTime, ((DelayedTask) o).startTime);
    }

    public String getTaskName() {
        return taskName;
    }
}
