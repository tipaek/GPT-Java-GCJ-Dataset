import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int n = scanner.nextInt();
            char[] schedule = new char[1441];
            StringBuilder result = new StringBuilder();

            boolean isImpossible = false;
            char currentHandler = 'C';
            char alternateHandler = 'J';

            for (int j = 0; j < n; j++) {
                boolean switchedHandler = false;
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                int switchPoint = -1;
                char assignedHandler = currentHandler;

                if (!isImpossible) {
                    for (int k = start; k < end; k++) {
                        if (schedule[k] == 'B') {
                            assignedHandler = 'I';
                            break;
                        } else if (schedule[k] == '\u0000') {
                            schedule[k] = currentHandler;
                            assignedHandler = currentHandler;
                        } else if (schedule[k] == currentHandler) {
                            schedule[k] = 'B';
                            if (switchedHandler) {
                                assignedHandler = 'I';
                                break;
                            }
                            if (switchPoint < 0) {
                                switchPoint = k;
                            }
                            char temp = currentHandler;
                            currentHandler = alternateHandler;
                            alternateHandler = temp;
                            assignedHandler = currentHandler;
                            switchedHandler = true;
                        } else if (schedule[k] == alternateHandler) {
                            schedule[k] = 'B';
                            assignedHandler = currentHandler;
                        }
                    }

                    if (assignedHandler == 'I') {
                        result = new StringBuilder("IMPOSSIBLE");
                        isImpossible = true;
                    } else {
                        result.append(assignedHandler);
                        for (int l = start; l < switchPoint; l++) {
                            schedule[l] = assignedHandler;
                        }
                    }
                }
            }
            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }
}