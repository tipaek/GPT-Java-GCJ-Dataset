import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int numTasks = scanner.nextInt();
            char[] schedule = new char[1441];
            StringBuilder result = new StringBuilder();

            boolean isImpossible = false;
            char currentWorker = 'C';
            char alternateWorker = 'J';

            for (int taskIndex = 0; taskIndex < numTasks; taskIndex++) {
                boolean switchedWorker = false;
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                int switchPoint = -1;
                char assignedWorker = currentWorker;

                if (!isImpossible) {
                    for (int time = startTime; time < endTime; time++) {
                        if (schedule[time] == 'B') {
                            assignedWorker = 'I';
                            break;
                        } else if (schedule[time] == '\u0000') {
                            schedule[time] = currentWorker;
                        } else if (schedule[time] == currentWorker) {
                            schedule[time] = 'B';
                            if (switchedWorker) {
                                assignedWorker = 'I';
                                break;
                            }
                            if (switchPoint < 0) {
                                switchPoint = time;
                            }
                            char temp = currentWorker;
                            currentWorker = alternateWorker;
                            alternateWorker = temp;
                            assignedWorker = currentWorker;
                            switchedWorker = true;
                        } else if (schedule[time] == alternateWorker) {
                            schedule[time] = 'B';
                            assignedWorker = currentWorker;
                        }
                    }

                    if (assignedWorker == 'I') {
                        result = new StringBuilder("IMPOSSIBLE");
                        isImpossible = true;
                    } else {
                        result.append(assignedWorker);
                        for (int time = startTime; time < switchPoint; time++) {
                            schedule[time] = assignedWorker;
                        }
                    }
                }
            }
            System.out.println("Case #" + caseNum + ": " + result.toString());
        }
    }
}