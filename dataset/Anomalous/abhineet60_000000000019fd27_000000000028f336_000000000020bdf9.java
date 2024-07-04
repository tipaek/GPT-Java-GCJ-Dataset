import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][3];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                intervals[i][2] = i;
            }
            
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] a1, int[] a2) {
                    return Integer.compare(a1[0], a2[0]);
                }
            });
            
            Set<Integer> cameron = new HashSet<>();
            Set<Integer> jamie = new HashSet<>();
            int lastCameronEnd = 0;
            int lastJamieEnd = 0;
            
            for (int i = 0; i < n; i++) {
                if (intervals[i][0] >= lastCameronEnd) {
                    cameron.add(intervals[i][2]);
                    lastCameronEnd = intervals[i][1];
                } else if (intervals[i][0] >= lastJamieEnd) {
                    jamie.add(intervals[i][2]);
                    lastJamieEnd = intervals[i][1];
                } else {
                    System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
                    continue;
                }
            }
            
            char[] result = new char[n];
            for (int i = 0; i < n; i++) {
                if (cameron.contains(i)) {
                    result[i] = 'C';
                } else {
                    result[i] = 'J';
                }
            }
            
            System.out.println("Case #" + caseNum + ": " + new String(result));
        }
    }
}