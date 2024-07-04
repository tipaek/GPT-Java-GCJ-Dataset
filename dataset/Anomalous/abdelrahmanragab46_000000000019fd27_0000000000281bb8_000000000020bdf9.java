import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();  // Number of test cases

        for (int i = 0; i < T; i++) {
            int caseNumber = i + 1;
            int N = input.nextInt();

            char[] assignments = new char[N];
            int[] startTimes = new int[N];
            int[] endTimes = new int[N];

            for (int j = 0; j < N; j++) {
                startTimes[j] = input.nextInt();
                endTimes[j] = input.nextInt();
                assignments[j] = 'x';
            }

            boolean impossible = assignTasks(assignments, startTimes, endTimes, N);

            if (impossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + caseNumber + ": ");
                for (char assignment : assignments) {
                    System.out.print(assignment);
                }
                System.out.println();
            }
        }
    }

    private static boolean assignTasks(char[] assignments, int[] startTimes, int[] endTimes, int N) {
        assignments[0] = 'C';  // Assign 'C' to the first task

        for (int j = 1; j < N; j++) {  // Assign 'C' to as many tasks as possible
            if (!isConflict(assignments, startTimes, endTimes, j, 'C')) {
                assignments[j] = 'C';
            }
        }

        for (int j = 1; j < N; j++) {  // Assign 'J' to remaining tasks
            if (assignments[j] == 'x' && !isConflict(assignments, startTimes, endTimes, j, 'J')) {
                assignments[j] = 'J';
            }
        }

        for (int j = 0; j < N; j++) {  // Check if there is any task that couldn't be assigned
            if (assignments[j] == 'x') {
                return true;
            }
        }

        return false;
    }

    private static boolean isConflict(char[] assignments, int[] startTimes, int[] endTimes, int currentTask, char person) {
        for (int k = 0; k < currentTask; k++) {
            if (assignments[k] == person) {
                if ((startTimes[currentTask] < endTimes[k] && endTimes[currentTask] > startTimes[k])) {
                    return true;
                }
            }
        }
        return false;
    }
}