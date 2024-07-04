import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            String[] assignments = new String[n];
            boolean[] cOccupied = new boolean[1440];
            boolean[] jOccupied = new boolean[1440];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            boolean possible = true;

            for (int i = 0; i < n; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];

                boolean canAssignC = true;
                boolean canAssignJ = true;

                for (int k = start; k < end; k++) {
                    if (cOccupied[k]) {
                        canAssignC = false;
                    }
                    if (jOccupied[k]) {
                        canAssignJ = false;
                    }
                }

                if (canAssignC) {
                    Arrays.fill(cOccupied, start, end, true);
                    assignments[i] = "C";
                } else if (canAssignJ) {
                    Arrays.fill(jOccupied, start, end, true);
                    assignments[i] = "J";
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.print("Case #" + t + ": ");
                for (String assignment : assignments) {
                    System.out.print(assignment);
                }
                System.out.println();
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}