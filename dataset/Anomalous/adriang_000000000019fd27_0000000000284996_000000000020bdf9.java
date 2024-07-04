import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            char[] schedule = new char[1441];
            StringBuilder result = new StringBuilder();

            boolean isImpossible = false;
            char currentWorker = 'C';
            char alternateWorker = 'J';

            for (int j = 0; j < n; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                if (isImpossible) {
                    continue;
                }

                boolean switchWorker = false;
                char assignedWorker = currentWorker;
                int conflictStart = -1;

                for (int k = startTime; k < endTime; k++) {
                    if (schedule[k] == 'X') {
                        assignedWorker = 'I';
                        break;
                    }

                    if (schedule[k] == currentWorker) {
                        schedule[k] = 'X';
                        if (conflictStart < 0) {
                            conflictStart = k;
                        }
                        assignedWorker = alternateWorker;
                        switchWorker = true;
                    } else if (schedule[k] == alternateWorker) {
                        schedule[k] = 'X';
                        assignedWorker = currentWorker;
                    } else {
                        schedule[k] = assignedWorker;
                    }
                }

                for (int l = startTime; l < conflictStart; l++) {
                    schedule[l] = alternateWorker;
                }

                if (switchWorker) {
                    char temp = currentWorker;
                    currentWorker = alternateWorker;
                    alternateWorker = temp;
                }

                if (assignedWorker == 'I') {
                    result = new StringBuilder("IMPOSSIBLE");
                    isImpossible = true;
                } else {
                    result.append(assignedWorker);
                }
            }
            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}