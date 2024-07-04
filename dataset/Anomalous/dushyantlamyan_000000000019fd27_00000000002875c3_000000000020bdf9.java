import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt(); 

        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            StringBuilder result = new StringBuilder();
            int cameronEnd = 0, jamieEnd = 0;
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                if (intervals[i][0] >= cameronEnd) {
                    result.append('C');
                    cameronEnd = intervals[i][1];
                } else if (intervals[i][0] >= jamieEnd) {
                    result.append('J');
                    jamieEnd = intervals[i][1];
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + caseNumber + ": " + result.toString());
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }
}