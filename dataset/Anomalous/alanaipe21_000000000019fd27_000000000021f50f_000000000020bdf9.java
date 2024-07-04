import java.util.Scanner;
import java.util.Arrays;

class Task {
    int id, start, end;
    String worker;

    public Task(int id, int start, int end) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.worker = null;
    }

    public void assignWorker(String workerId) {
        this.worker = workerId;
    }

    public void print() {
        System.out.println("Start: " + start + ", End: " + end);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            Task[] tasks = new Task[n];

            for (int j = 0; j < n; j++) {
                tasks[j] = new Task(j, scanner.nextInt(), scanner.nextInt());
            }

            Arrays.sort(tasks, (task1, task2) -> Integer.compare(task1.start, task2.start));

            boolean cWorking = false, jWorking = false;
            int cEndTime = -1, jEndTime = -1;
            StringBuilder output = new StringBuilder();

            for (Task task : tasks) {
                if (!cWorking && !jWorking) {
                    cWorking = true;
                    cEndTime = task.end;
                    task.assignWorker("C");
                } else if (cWorking && jWorking) {
                    if (cEndTime <= task.start) {
                        cEndTime = task.end;
                        task.assignWorker("C");
                    } else if (jEndTime <= task.start) {
                        jEndTime = task.end;
                        task.assignWorker("J");
                    } else {
                        output = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                } else if (cWorking) {
                    jWorking = true;
                    jEndTime = task.end;
                    task.assignWorker("J");
                } else {
                    cWorking = true;
                    cEndTime = task.end;
                    task.assignWorker("C");
                }
            }

            Arrays.sort(tasks, (task1, task2) -> Integer.compare(task1.id, task2.id));

            if (!output.toString().equals("IMPOSSIBLE")) {
                for (Task task : tasks) {
                    output.append(task.worker);
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + output);
        }

        scanner.close();
    }
}