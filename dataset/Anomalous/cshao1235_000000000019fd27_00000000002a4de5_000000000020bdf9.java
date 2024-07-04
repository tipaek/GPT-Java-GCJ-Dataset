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
        int t = Integer.parseInt(reader.readLine());
        
        for (int testCase = 1; testCase <= t; testCase++) {
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
            int cEnd = -1;
            int jEnd = -1;
            
            for (int i = 0; i < n; i++) {
                if (intervals[i][0] > cEnd) {
                    assignments[intervals[i][2]] = 'C';
                    cEnd = intervals[i][1];
                } else if (intervals[i][0] > jEnd) {
                    assignments[intervals[i][2]] = 'J';
                    jEnd = intervals[i][1];
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            String result = isPossible ? new String(assignments) : "IMPOSSIBLE";
            System.out.println("Case #" + testCase + ": " + result);
        }
        
        reader.close();
    }
}