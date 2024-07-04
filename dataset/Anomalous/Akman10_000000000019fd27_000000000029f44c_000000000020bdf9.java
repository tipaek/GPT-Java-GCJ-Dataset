import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Number of test cases
        for (int testCase = 1; testCase <= t; ++testCase) {
            int n = in.nextInt(); // Number of intervals
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] assignments = new int[n];
            
            for (int i = 0; i < n; i++) {
                startTimes[i] = in.nextInt();
                endTimes[i] = in.nextInt();
            }
            
            boolean impossible = false;
            for (int i = 1; i < n && !impossible; i++) {
                boolean firstAssignment = true;
                for (int j = 0; j < n; j++) {
                    if (j != i && overlaps(startTimes[i], endTimes[i], startTimes[j], endTimes[j])) {
                        if (firstAssignment) {
                            assignments[i] = 1 - assignments[j];
                            firstAssignment = false;
                        } else if (assignments[i] == assignments[j]) {
                            impossible = true;
                            break;
                        }
                    }
                }
            }
            
            if (impossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    result.append(assignments[i] == 1 ? "J" : "C");
                }
                System.out.println("Case #" + testCase + ": " + result.toString());
            }
        }
    }

    private static boolean overlaps(int start1, int end1, int start2, int end2) {
        return (start1 < end2 && end1 > start2);
    }
}