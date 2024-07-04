import java.io.*;
import java.util.*;

public class Solution {
    static class ArrayComparator implements Comparator<int[]> {
        public int compare(int[] o1, int[] o2) {
            if (o1[1] != o2[1]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
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
            int currentIndex = 0;

            while (currentIndex < n) {
                if (!isPossible) {
                    break;
                }

                int endTime = intervals[currentIndex][1];
                assignments[intervals[currentIndex][2]] = 'C';
                currentIndex++;

                int overlapCount = 0;
                while (currentIndex < n && intervals[currentIndex][0] < endTime) {
                    assignments[intervals[currentIndex][2]] = 'J';
                    overlapCount++;
                    if (overlapCount > 1 && intervals[currentIndex][0] < intervals[currentIndex - 1][1]) {
                        isPossible = false;
                        break;
                    }
                    currentIndex++;
                }
            }

            String result = isPossible ? new String(assignments) : "IMPOSSIBLE";
            System.out.println("Case #" + testCase + ": " + result);
        }

        reader.close();
    }
}