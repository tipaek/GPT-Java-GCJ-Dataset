import java.io.*;
import java.util.*;

public class Solution {
    static class ArrayComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] != o2[0]) {
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[1], o2[1]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] intervals = new int[n][3];
            char[] assignments = new char[n];

            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                intervals[i][0] = 2 * Integer.parseInt(tokenizer.nextToken()) + 1;
                intervals[i][1] = 2 * Integer.parseInt(tokenizer.nextToken());
                intervals[i][2] = i;
            }

            Arrays.sort(intervals, new ArrayComparator());

            boolean isPossible = true;
            int index = 0;

            while (index < n) {
                if (!isPossible) {
                    break;
                }

                int endTime = intervals[index][1];
                assignments[intervals[index][2]] = 'C';
                index++;

                int overlapCount = 0;
                while (index < n && intervals[index][0] < endTime) {
                    assignments[intervals[index][2]] = 'J';

                    overlapCount++;
                    if (overlapCount > 1 && intervals[index][0] < intervals[index - 1][1]) {
                        isPossible = false;
                        break;
                    }

                    index++;
                }
            }

            String result = "IMPOSSIBLE";
            if (isPossible) {
                StringBuilder output = new StringBuilder();
                for (char assignment : assignments) {
                    output.append(assignment);
                }
                result = output.toString();
            }

            System.out.println("Case #" + testCase + ": " + result);
        }

        reader.close();
    }
}