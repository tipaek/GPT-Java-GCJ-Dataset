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
            int[][] intervals = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }
            
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] interval1, int[] interval2) {
                    return Integer.compare(interval1[1], interval2[1]);
                }
            });
            
            HashSet<Integer> cameron = new HashSet<>();
            HashSet<Integer> jamie = new HashSet<>();
            int lastEndTime = 0;
            cameron.add(0);
            
            for (int i = 1; i < n; i++) {
                if (intervals[i][0] >= intervals[lastEndTime][1]) {
                    cameron.add(i);
                    lastEndTime = i;
                }
            }
            
            for (int i = 1; i < n; i++) {
                if (!cameron.contains(i)) {
                    jamie.add(i);
                    lastEndTime = i;
                    break;
                }
            }
            
            for (int i = 1; i < n; i++) {
                if (!cameron.contains(i) && intervals[i][0] >= intervals[lastEndTime][1]) {
                    jamie.add(i);
                    lastEndTime = i;
                }
            }
            
            StringBuilder result = new StringBuilder();
            if (cameron.size() + jamie.size() < n) {
                result.append("IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    if (cameron.contains(i)) {
                        result.append("C");
                    } else {
                        result.append("J");
                    }
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
        
        scanner.close();
    }
}