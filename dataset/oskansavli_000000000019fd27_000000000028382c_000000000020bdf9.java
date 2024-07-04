
import java.util.*;
import java.io.*;

public class Solution {
    // Sort by start
    static Comparator comp = new Comparator<int[]>() {
        public int compare(int[] a, int[] b) {
            return Double.compare(a[0], b[0]);
        }
    };
    // Sort back to original order
    static Comparator comp2 = new Comparator<int[]>() {
        public int compare(int[] a, int[] b) {
            return Double.compare(a[3], b[3]);
        }
    };

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int ti = 1; ti <= t; ++ti) {
            int n = in.nextInt();
            int c = 0;
            int j = 0;
            int[][] activities = new int[n][4]; // activities[i][2] is the assignment, 0 for Cameron, 1 for Jaime. activities[i][3] is the original activity index.
            String result = "";
            for (int i=0; i<n; i++) {
                activities[i][0] = in.nextInt();
                activities[i][1] = in.nextInt();
                activities[i][3] = i;
            }
            Arrays.sort(activities, comp);

            for (int i=0; i<n; i++) {
                int start = activities[i][0];
                int end = activities[i][1];
                if (c <= start) {
                    activities[i][2] = 0; // assign to Cameron
                    c = end;
                } else if (j <= start) {
                    activities[i][2] = 1; // assign to Jamie
                    j = end;
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }
            if (result.isEmpty()) {
                Arrays.sort(activities, comp2);
                for (int i=0; i<n; i++) {
                    result += activities[i][2] == 0 ? "C" : "J";
                }
            }

            System.out.println("Case #" + ti + ": " + result);
        }
    }
}