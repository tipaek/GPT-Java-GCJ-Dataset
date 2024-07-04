import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt(); // number of test cases

        for (int i = 0; i < T; i++) {
            int caseNumber = i + 1;
            int N = input.nextInt(); // number of tasks

            int[] startTimes = new int[N];
            int[] endTimes = new int[N];
            char[] assignments = new char[N];

            for (int j = 0; j < N; j++) {
                startTimes[j] = input.nextInt();
                endTimes[j] = input.nextInt();
                assignments[j] = 'x'; // initialize assignments to 'x'
            }

            boolean isPossible = assignTasks(startTimes, endTimes, assignments, N);

            if (isPossible) {
                System.out.print("Case #" + caseNumber + ": ");
                for (char assignment : assignments) {
                    System.out.print(assignment);
                }
                System.out.println();
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean assignTasks(int[] startTimes, int[] endTimes, char[] assignments, int N) {
        assignments[0] = 'C'; // assign the first task to 'C'

        for (int j = 1; j < N; j++) {
            for (int k = 0; k < j; k++) {
                if (assignments[k] == 'C' && isOverlapping(startTimes[j], endTimes[j], startTimes[k], endTimes[k])) {
                    assignments[j] = 'x';
                } else {
                    assignments[j] = 'C';
                }
            }
        }

        for (int j = 1; j < N; j++) {
            if (assignments[j] == 'x') {
                assignments[j] = 'J';
                break;
            }
        }

        for (int j = 1; j < N; j++) {
            if (assignments[j] == 'x') {
                for (int k = 0; k < j; k++) {
                    if (assignments[k] == 'J' && isOverlapping(startTimes[j], endTimes[j], startTimes[k], endTimes[k])) {
                        assignments[j] = 'x';
                    } else {
                        assignments[j] = 'J';
                    }
                }
            }
        }

        for (int j = 0; j < N; j++) {
            if (assignments[j] == 'x') {
                return false;
            }
        }

        return true;
    }

    private static boolean isOverlapping(int start1, int end1, int start2, int end2) {
        return (start1 < end2 && end1 > start2);
    }
}