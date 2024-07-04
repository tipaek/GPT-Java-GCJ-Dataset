import java.util.Arrays;
import java.util.Scanner;

class Task implements Comparable<Task> {
    final int startTime;
    final int endTime;
    final int index;

    public Task(int startTime, int endTime, int index) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.index = index;
    }

    @Override
    public int compareTo(Task other) {
        int result = Integer.compare(this.startTime, other.startTime);
        if (result == 0) {
            result = Integer.compare(this.endTime, other.endTime);
        }
        return result;
    }
}

public class Scheduler {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int numTasks = scanner.nextInt();
            Task[] tasks = new Task[numTasks];
            for (int i = 0; i < numTasks; i++) {
                tasks[i] = new Task(scanner.nextInt(), scanner.nextInt(), i);
            }
            Arrays.sort(tasks);
            char[] schedule = new char[numTasks];
            boolean isImpossible = false;
            int cameronEndTime = 0;
            int jamieEndTime = 0;
            for (Task task : tasks) {
                if (task.startTime >= cameronEndTime) {
                    schedule[task.index] = 'C';
                    cameronEndTime = task.endTime;
                } else if (task.startTime >= jamieEndTime) {
                    schedule[task.index] = 'J';
                    jamieEndTime = task.endTime;
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + t + ": ");
                System.out.println(new String(schedule));
            }
        }
        scanner.close();
    }
}