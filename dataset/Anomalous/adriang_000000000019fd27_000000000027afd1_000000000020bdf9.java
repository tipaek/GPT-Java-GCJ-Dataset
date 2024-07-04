import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numTasks = scanner.nextInt();
            StringBuilder schedule = new StringBuilder("0".repeat(1440));
            StringBuilder result = new StringBuilder();

            int firstConflict = -1;
            char currentWorker = 'C';
            char alternateWorker = 'J';

            for (int taskIndex = 0; taskIndex < numTasks; taskIndex++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                char assignedWorker = currentWorker;
                boolean switchWorker = false;

                for (int time = startTime; time < endTime; time++) {
                    if (schedule.charAt(time) == 'B') {
                        assignedWorker = 'I';
                        break;
                    }
                    if (schedule.charAt(time) == currentWorker) {
                        schedule.setCharAt(time, 'B');
                        if (firstConflict < 0) {
                            firstConflict = time;
                        }
                        assignedWorker = alternateWorker;
                        switchWorker = true;
                    } else {
                        schedule.setCharAt(time, currentWorker);
                    }
                }

                if (firstConflict > startTime) {
                    for (int time = startTime; time < firstConflict; time++) {
                        schedule.setCharAt(time, alternateWorker);
                    }
                }

                if (switchWorker) {
                    char temp = currentWorker;
                    currentWorker = alternateWorker;
                    alternateWorker = temp;
                }

                if (assignedWorker == 'I') {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                } else {
                    result.append(assignedWorker);
                }
            }

            System.out.println("Case #" + caseNum + ": " + result);
        }
    }
}