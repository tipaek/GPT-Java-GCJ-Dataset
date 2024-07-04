import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            int countN = in.nextInt();
            int[][] intervals = new int[countN][2];
            for (int j = 0; j < countN; j++) {
                intervals[j][0] = in.nextInt();
                intervals[j][1] = in.nextInt();
            }

            String result = assignTasks(intervals);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String assignTasks(int[][] intervals) {
        StringBuilder output = new StringBuilder();
        int cEnd = 0, jEnd = 0;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (start >= cEnd) {
                output.append('C');
                cEnd = end;
            } else if (start >= jEnd) {
                output.append('J');
                jEnd = end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return output.toString();
    }
}