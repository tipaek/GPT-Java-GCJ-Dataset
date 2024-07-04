import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numOfCases = in.nextInt();

        for (int currentCase = 1; currentCase <= numOfCases; currentCase++) {
            int numOfActs = in.nextInt();

            Task[] tasks = new Task[numOfActs];
            for (int i = 0; i < numOfActs; i++) {
                int startingTime = in.nextInt();
                int endTime = in.nextInt();
                tasks[i] = new Task(startingTime, endTime, i);
            }

            Arrays.sort(tasks, Comparator.comparingInt(t -> t.startingTime));

            int jEnd = 0, cEnd = 0;
            char[] result = new char[numOfActs];
            boolean possible = true;

            for (Task task : tasks) {
                if (task.startingTime >= jEnd) {
                    task.assigned = 'J';
                    jEnd = task.endTime;
                } else if (task.startingTime >= cEnd) {
                    task.assigned = 'C';
                    cEnd = task.endTime;
                } else {
                    possible = false;
                    break;
                }
                result[task.taskNum] = task.assigned;
            }

            if (possible) {
                System.out.println("Case #" + currentCase + ": " + new String(result));
            } else {
                System.out.println("Case #" + currentCase + ": IMPOSSIBLE");
            }
        }
    }
}

class Task {
    int startingTime;
    int endTime;
    int taskNum;
    char assigned;

    public Task(int startingTime, int endTime, int taskNum) {
        this.startingTime = startingTime;
        this.endTime = endTime;
        this.taskNum = taskNum;
        this.assigned = 'U'; // 'U' for unassigned
    }
}