import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = in.nextInt();
            int[] arr = new int[100000];
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            boolean impossible = false;

            for (int j = 0; j < n; j++) {
                startTimes[j] = in.nextInt();
                endTimes[j] = in.nextInt();
                for (int k = startTimes[j]; k < endTimes[j]; k++) {
                    arr[k]++;
                    if (arr[k] > 2) {
                        impossible = true;
                    }
                }
            }

            if (impossible) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                int[] assignments = new int[n];
                assignments[0] = 0;

                for (int i = 1; i < n; i++) {
                    for (int j = i - 1; j >= 0; j--) {
                        if ((startTimes[i] >= startTimes[j] && startTimes[i] < endTimes[j]) ||
                            (endTimes[i] > startTimes[j] && endTimes[i] <= endTimes[j])) {
                            assignments[i] = 1 - assignments[j];
                            break;
                        }
                    }
                }

                System.out.print("Case #" + caseNum + ": ");
                for (int i = 0; i < assignments.length; i++) {
                    System.out.print(assignments[i] == 1 ? 'C' : 'J');
                }
                System.out.println();
            }
        }
    }
}