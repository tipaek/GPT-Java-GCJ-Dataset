import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[] schedule = new int[100000];
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            boolean impossible = false;

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
                for (int time = startTimes[i]; time < endTimes[i]; time++) {
                    schedule[time]++;
                    if (schedule[time] > 2) {
                        impossible = true;
                    }
                }
            }

            if (impossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                int[] assignments = new int[n];
                assignments[0] = 0;

                for (int i = 1; i < n; i++) {
                    for (int j = i - 1; j >= 0; j--) {
                        if ((startTimes[i] >= startTimes[j] && startTimes[i] < endTimes[j]) || 
                            (endTimes[i] > startTimes[j] && endTimes[i] <= endTimes[j])) {
                            assignments[i] = 1 - assignments[j];
                        }
                    }
                }

                System.out.print("Case #" + caseNumber + ": ");
                for (int assignment : assignments) {
                    System.out.print(assignment == 1 ? 'C' : 'J');
                }
                System.out.println();
            }
        }
    }
}