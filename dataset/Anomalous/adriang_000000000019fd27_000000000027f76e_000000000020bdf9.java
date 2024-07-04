import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            char[] schedule = new char[1441];
            StringBuilder result = new StringBuilder();

            boolean isImpossible = false;
            int firstConflictIndex = -1;
            char currentWorker = 'C';
            char alternateWorker = 'J';

            for (int j = 0; j < n; j++) {
                boolean conflictDetected = false;
                char assignedWorker = currentWorker;
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (!isImpossible) {
                    for (int k = start; k < end; k++) {
                        if (schedule[k] == 'B') {
                            assignedWorker = 'I';
                            break;
                        }
                        if (schedule[k] == currentWorker) {
                            schedule[k] = 'B';
                            if (firstConflictIndex < 0) {
                                firstConflictIndex = k;
                            }
                            assignedWorker = alternateWorker;
                            conflictDetected = true;
                        } else {
                            schedule[k] = currentWorker;
                        }
                    }

                    for (int l = start; l < firstConflictIndex; l++) {
                        schedule[l] = alternateWorker;
                    }

                    if (conflictDetected) {
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
            }
            System.out.println("Case #" + i + ": " + result.toString());
        }

        scanner.close();
    }
}