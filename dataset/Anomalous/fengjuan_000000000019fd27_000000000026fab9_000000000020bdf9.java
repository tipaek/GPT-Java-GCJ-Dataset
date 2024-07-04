import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            Integer[] indices = new Integer[n];

            for (int i = 0; i < n; i++) {
                indices[i] = i;
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            Arrays.sort(indices, Comparator.comparingInt(i -> intervals[i][0]));

            int endC = 0, endJ = 0;
            boolean impossible = false;
            char[] assignments = new char[n];

            for (int i = 0; i < n; i++) {
                int start = intervals[indices[i]][0];
                int end = intervals[indices[i]][1];

                if (start >= endC) {
                    endC = end;
                    assignments[indices[i]] = 'C';
                } else if (start >= endJ) {
                    endJ = end;
                    assignments[indices[i]] = 'J';
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + new String(assignments));
            }
        }
    }
}