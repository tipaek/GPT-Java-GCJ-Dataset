import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt(); // number of test cases

        for (int i = 0; i < T; i++) {
            int testCaseNumber = i + 1;
            int N = input.nextInt(); // number of tasks

            char[] assignedTasks = new char[N];
            int[] startTimes = new int[N];
            int[] endTimes = new int[N];

            final char C = 'C';
            final char J = 'J';
            boolean isImpossible = false;

            Arrays.fill(assignedTasks, 'x'); // initialize all tasks as unassigned

            for (int j = 0; j < N; j++) {
                startTimes[j] = input.nextInt();
                endTimes[j] = input.nextInt();
            }

            assignedTasks[0] = C; // assign first task to C

            for (int j = 1; j < N; j++) {
                for (int k = 0; k < j; k++) {
                    if (assignedTasks[k] == C) {
                        if ((startTimes[j] < startTimes[k] && endTimes[j] <= startTimes[k]) ||
                            (startTimes[j] >= endTimes[k] && endTimes[j] > endTimes[k])) {
                            assignedTasks[j] = C;
                        } else {
                            assignedTasks[j] = 'x';
                        }
                    }
                }
            }

            for (int j = 1; j < N; j++) {
                if (assignedTasks[j] == 'x') {
                    assignedTasks[j] = J;
                    break;
                }
            }

            for (int j = 1; j < N; j++) {
                if (assignedTasks[j] == 'x') {
                    for (int k = 0; k < j; k++) {
                        if (assignedTasks[k] == J) {
                            if ((startTimes[j] < startTimes[k] && endTimes[j] <= startTimes[k]) ||
                                (startTimes[j] >= endTimes[k] && endTimes[j] > endTimes[k])) {
                                assignedTasks[j] = J;
                            } else {
                                assignedTasks[j] = 'x';
                            }
                        }
                    }
                }
            }

            for (int j = 0; j < N; j++) {
                if (assignedTasks[j] == 'x') {
                    isImpossible = true;
                    break;
                }
            }

            String result = isImpossible ? "IMPOSSIBLE" : new String(assignedTasks);
            System.out.println("Case #" + testCaseNumber + ": " + result);
        }
    }
}