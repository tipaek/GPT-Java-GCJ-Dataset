import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; ++t) {
            int countN = scanner.nextInt();
            int[][] intervals = new int[countN][2];
            
            for (int i = 0; i < countN; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            StringBuilder result = new StringBuilder();
            boolean isPossible = true;
            int cEnd = 0, jEnd = 0;

            for (int i = 0; i < countN; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];

                if (start >= cEnd) {
                    result.append('C');
                    cEnd = end;
                } else if (start >= jEnd) {
                    result.append('J');
                    jEnd = end;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + result.toString());
            }
        }
    }
}