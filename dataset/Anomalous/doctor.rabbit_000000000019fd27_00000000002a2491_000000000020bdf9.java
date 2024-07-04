import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfCases = scanner.nextInt();

        for (int currentCase = 1; currentCase <= numOfCases; currentCase++) {
            int numOfActs = scanner.nextInt();
            Task[] tasks = new Task[numOfActs];
            
            for (int i = 0; i < numOfActs; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks[i] = new Task(start, end, i);
            }

            Arrays.sort(tasks, Comparator.comparingInt(task -> task.startTime));

            int cEndTime = 0, jEndTime = 0;
            char[] result = new char[numOfActs];
            boolean impossible = false;

            for (Task task : tasks) {
                if (task.startTime >= cEndTime) {
                    result[task.index] = 'C';
                    cEndTime = task.endTime;
                } else if (task.startTime >= jEndTime) {
                    result[task.index] = 'J';
                    jEndTime = task.endTime;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + currentCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + currentCase + ": " + new String(result));
            }
        }
    }
}

class Task {
    int startTime;
    int endTime;
    int index;

    public Task(int startTime, int endTime, int index) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.index = index;
    }
}