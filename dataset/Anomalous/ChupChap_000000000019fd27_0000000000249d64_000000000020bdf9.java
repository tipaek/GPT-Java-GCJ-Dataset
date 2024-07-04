import java.util.*;
import java.io.*;

public class Solution {

    public static String sequence(int[][] intervals, int n) {
        int[] assignment = new int[n];
        assignment[0] = 1;

        for (int i = 1; i < n; i++) {
            int canBeC = 1;
            int canBeJ = 1;

            for (int j = 0; j < i; j++) {
                if ((intervals[i][0] > intervals[j][0] && intervals[i][0] < intervals[j][1]) || 
                    (intervals[i][1] > intervals[j][0] && intervals[i][1] < intervals[j][1]) || 
                    (intervals[i][0] < intervals[j][0] && intervals[i][1] > intervals[j][1])) {
                    
                    if (assignment[j] == 1) {
                        canBeC = 0;
                    } else {
                        canBeJ = 0;
                    }
                }
            }

            if (canBeC == 1) {
                assignment[i] = 1;
            } else if (canBeJ == 1) {
                assignment[i] = 0;
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder result = new StringBuilder("C");
        for (int i = 1; i < n; i++) {
            if (assignment[i] == 1) {
                result.append("C");
            } else {
                result.append("J");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            String result = sequence(intervals, n);
            System.out.println("Case #" + t + ": " + result);
        }
    }
}