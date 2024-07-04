import java.io.*;
import java.util.*;

public class Solution {

    static class ArrayComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return Integer.compare(a[1], b[1]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] intervals = new int[n][3];
            char[] assignments = new char[n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                intervals[i][0] = 2 * Integer.parseInt(st.nextToken()) + 1;
                intervals[i][1] = 2 * Integer.parseInt(st.nextToken());
                intervals[i][2] = i;
            }

            Arrays.sort(intervals, new ArrayComparator());

            boolean isPossible = true;
            int index = 0;

            while (index < n) {
                if (!isPossible) break;

                int currentEnd = intervals[index][1];
                assignments[intervals[index][2]] = 'C';
                index++;

                int overlapCount = 0;
                while (index < n && intervals[index][0] < currentEnd) {
                    assignments[intervals[index][2]] = 'J';
                    overlapCount++;
                    if (overlapCount > 1 && intervals[index][0] < intervals[index - 1][1]) {
                        isPossible = false;
                        break;
                    }
                    index++;
                }
            }

            String result = isPossible ? new String(assignments) : "IMPOSSIBLE";
            System.out.println("Case #" + t + ": " + result);
        }

        reader.close();
    }
}