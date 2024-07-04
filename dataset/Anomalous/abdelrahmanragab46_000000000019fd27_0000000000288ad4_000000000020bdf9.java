import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        // Scanner for input
        Scanner input = new Scanner(System.in);

        int T = input.nextInt(); // number of test cases

        for (int i = 0; i < T; i++) {
            int caseNumber = i + 1;
            int N = input.nextInt();

            char[] assignments = new char[N]; // to store assignments of C or J
            int[] startTimes = new int[N];    // start times of tasks
            int[] endTimes = new int[N];      // end times of tasks

            Arrays.fill(assignments, 'x'); // initialize assignments array with 'x'

            for (int j = 0; j < N; j++) {
                startTimes[j] = input.nextInt();
                endTimes[j] = input.nextInt();
            }

            assignments[0] = 'C'; // assign first task to C

            // Assign tasks to C where possible
            for (int j = 1; j < N; j++) {
                for (int k = 0; k < j; k++) {
                    if (assignments[k] == 'C') {
                        if ((startTimes[j] < startTimes[k] && endTimes[j] <= startTimes[k]) || 
                            (startTimes[j] >= endTimes[k] && endTimes[j] > endTimes[k])) {
                            assignments[j] = 'C';
                        } else {
                            assignments[j] = 'x';
                        }
                    }
                }
            }

            // Assign the first remaining task to J
            for (int j = 1; j < N; j++) {
                if (assignments[j] == 'x') {
                    assignments[j] = 'J';
                    break;
                }
            }

            // Assign tasks to J where possible
            for (int j = 1; j < N; j++) {
                if (assignments[j] == 'x') {
                    for (int k = 0; k < j; k++) {
                        if (assignments[k] == 'J') {
                            if ((startTimes[j] < startTimes[k] && endTimes[j] <= startTimes[k]) || 
                                (startTimes[j] >= endTimes[k] && endTimes[j] > endTimes[k])) {
                                assignments[j] = 'J';
                            } else {
                                assignments[j] = 'x';
                            }
                        }
                    }
                }
            }

            boolean isImpossible = false;
            for (char c : assignments) {
                if (c == 'x') {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + caseNumber + ": ");
                for (char c : assignments) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }

        input.close();
    }
}