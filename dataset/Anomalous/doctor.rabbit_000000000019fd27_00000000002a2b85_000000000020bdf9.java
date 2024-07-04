import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfCases = in.nextInt();

        for (int currentCase = 1; currentCase <= numOfCases; currentCase++) {
            int numOfActs = in.nextInt();
            List<Task> tasksList = new ArrayList<>();
            char[] outChar = new char[numOfActs];

            // Read tasks
            for (int i = 0; i < numOfActs; i++) {
                int startingTime = in.nextInt();
                int endTime = in.nextInt();
                tasksList.add(new Task(startingTime, endTime, i));
            }

            // Sort tasks by starting time
            tasksList.sort(Comparator.comparingInt(task -> task.startingTime));

            int cEndTime = 0, jEndTime = 0;
            boolean impossible = false;

            // Assign tasks
            for (Task task : tasksList) {
                if (cEndTime <= task.startingTime) {
                    task.assigned = 'C';
                    cEndTime = task.endTime;
                } else if (jEndTime <= task.startingTime) {
                    task.assigned = 'J';
                    jEndTime = task.endTime;
                } else {
                    impossible = true;
                    break;
                }
                outChar[task.taskNum] = task.assigned;
            }

            // Output result
            if (impossible) {
                System.out.println("Case #" + currentCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + currentCase + ": " + new String(outChar));
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
        this.assigned = 'U'; // unassigned
    }
}