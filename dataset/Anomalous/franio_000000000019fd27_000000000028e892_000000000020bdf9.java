import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int taskCount = scanner.nextInt();
            Task[] tasks = new Task[taskCount];
            for (int i = 0; i < taskCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks[i] = new Task(start, end, i);
            }

            String result = "";
            for (int j = 0; j < (1 << taskCount); j++) {
                result = "";
                List<Task> cTasks = new LinkedList<>();
                List<Task> jTasks = new LinkedList<>();

                int temp = j;
                for (int k = 0; k < taskCount; k++) {
                    if (temp % 2 == 0) {
                        if (cTasks.stream().anyMatch(task -> tasks[k].overlaps(task))) {
                            break;
                        } else {
                            cTasks.add(tasks[k]);
                            result += "C";
                        }
                    } else {
                        if (jTasks.stream().anyMatch(task -> tasks[k].overlaps(task))) {
                            break;
                        } else {
                            jTasks.add(tasks[k]);
                            result += "J";
                        }
                    }
                    temp /= 2;
                }
                if (result.length() == taskCount) {
                    break;
                }
            }

            printResult(t + 1, result.length() == taskCount ? result : "IMPOSSIBLE");
        }
        scanner.close();
    }

    private static void printResult(int caseNumber, String result) {
        System.out.println("Case #" + caseNumber + ": " + result);
    }
}

class Task {
    int start;
    int end;
    int index;

    public Task(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    public boolean overlaps(Task other) {
        return (this.start < other.end && this.end > other.start);
    }
}