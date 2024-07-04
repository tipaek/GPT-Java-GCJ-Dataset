import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][3];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                intervals[i][2] = i;
            }
            
            Arrays.sort(intervals, new Comparator<int[]>() {
                public int compare(int[] interval1, int[] interval2) {
                    return Integer.compare(interval1[1], interval2[1]);
                }
            });
            
            HashSet<Integer> cameron = new HashSet<>();
            HashSet<Integer> jamie = new HashSet<>();
            int lastCameronEnd = -1;
            int lastJamieEnd = -1;
            
            for (int[] interval : intervals) {
                if (interval[0] >= lastCameronEnd) {
                    cameron.add(interval[2]);
                    lastCameronEnd = interval[1];
                } else if (interval[0] >= lastJamieEnd) {
                    jamie.add(interval[2]);
                    lastJamieEnd = interval[1];
                } else {
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                    continue;
                }
            }
            
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (cameron.contains(i)) {
                    result.append('C');
                } else if (jamie.contains(i)) {
                    result.append('J');
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
        
        scanner.close();
    }
}