import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfCases = in.nextInt();

        for (int currentCase = 1; currentCase <= numOfCases; currentCase++) {
            int numOfActs = in.nextInt();
            boolean impossibleSwitch = false;
            char[] outChar = new char[numOfActs];

            List<Task> tasksList = new ArrayList<>();
            for (int i = 0; i < numOfActs; i++) {
                int startingTime = in.nextInt();
                int endTime = in.nextInt();
                tasksList.add(new Task(startingTime, endTime, i, 'u'));
            }

            tasksList.sort(Comparator.comparingInt(t -> t.startingTime));

            int jCurrentWorkEnding = 0;
            int cCurrentWorkEnding = 0;

            for (Task t : tasksList) {
                if (cCurrentWorkEnding <= t.startingTime) {
                    t.assigned = 'C';
                    cCurrentWorkEnding = t.endTime;
                } else if (jCurrentWorkEnding <= t.startingTime) {
                    t.assigned = 'J';
                    jCurrentWorkEnding = t.endTime;
                } else {
                    impossibleSwitch = true;
                    break;
                }
                outChar[t.taskNum] = t.assigned;
            }

            if (impossibleSwitch) {
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

    public Task(int startingTime, int endTime, int taskNum, char assigned) {
        this.startingTime = startingTime;
        this.endTime = endTime;
        this.taskNum = taskNum;
        this.assigned = assigned;
    }
}