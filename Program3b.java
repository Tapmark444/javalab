// Abstract Task Class
abstract class Task extends Thread {
public Task(String name, int priority) {
super(name);
setPriority(priority);
}
public abstract void execute();
@Override public void run() { execute(); }
}
// High-Priority Task
class HighPriorityTask extends Task {
public HighPriorityTask(String name) { super(name, Thread.MAX_PRIORITY); }
public void execute() {
System.out.println(getName() + " (High Priority) started.");
for (int i = 1; i <= 5; i++) {
System.out.println(getName() + " executing step " + i);
try { Thread.sleep(500); } catch (InterruptedException e) {}
}
System.out.println(getName() + " (High Priority) completed.");
}
}
// Low-Priority Task
class LowPriorityTask extends Task {
public LowPriorityTask(String name) { super(name, Thread.MIN_PRIORITY); }
public void execute() {
System.out.println(getName() + " (Low Priority) started.");
for (int i = 1; i <= 5; i++) {
System.out.println(getName() + " executing step " + i);
try { Thread.sleep(500); } catch (InterruptedException e) {}
}
System.out.println(getName() + " (Low Priority) completed.");
}
}
// Task Scheduler Main Class
public class TaskScheduler {
public static void main(String[] args) throws InterruptedException {
Task[] tasks = {
new HighPriorityTask("HighPriorityTask-1"),
new HighPriorityTask("HighPriorityTask-2"),
new LowPriorityTask("LowPriorityTask-1"),
new LowPriorityTask("LowPriorityTask-2")
};
for (Task task : tasks) task.start();
for (Task task : tasks) task.join();
System.out.println("All tasks completed.");
}
}
