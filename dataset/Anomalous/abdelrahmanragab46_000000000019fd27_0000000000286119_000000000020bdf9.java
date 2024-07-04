import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt(); // number of test cases

        for (int i = 0; i < T; i++) {
            int caseNumber = i + 1;
            int N = input.nextInt(); // number of tasks

            char[] assignments = new char[N];
            int[] startTimes = new int[N];
            int[] endTimes = new int[N];

            Arrays.fill(assignments, 'x');

            for (int j = 0; j < N; j++) {
                startTimes[j] = input.nextInt();
                endTimes[j] = input.nextInt();
            }

            boolean isPossible = assignTasks(assignments, startTimes, endTimes, N);

            if (!isPossible) {
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
        assignments[0] = 'C'; // Assign 'C' to the first task

        for (int j = 1; j < N; j++) {
            if (!canAssign(assignments, startTimes, endTimes, j, 'C')) {
                assignments[j] = 'J';
            } else {
                assignments[j] = 'C';
            }
        }

        for (int j = 1; j < N; j++) {
            if (assignments[j] == 'x') {
                if (!canAssign(assignments, startTimes, endTimes, j, 'J')) {
                    return false;
                }
                assignments[j] = 'J';
            }
        }

        return true;
    }

    private static boolean canAssign(char[] assignments, int[] startTimes, int[] endTimes, int currentIndex, char person) {
        for (int k = 0; k < currentIndex; k++) {
            if (assignments[k] == person && conflicts(startTimes[k], endTimes[k], startTimes[currentIndex], endTimes[currentIndex])) {
                return false;
            }
        }
        return true;
    }

    private static boolean conflicts(int start1, int end1, int start2, int end2) {
        return (start2 < end1 && end2 > start1);
    }
}