import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (caseNumber <= testCases) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            Arrays.sort(intervals, new Comparator<int[]>() {
                public int compare(int[] interval1, int[] interval2) {
                    return Integer.compare(interval2[1], interval1[1]);
                }
            });

            HashSet<Integer> cameron = new HashSet<>();
            HashSet<Integer> jamie = new HashSet<>();
            int lastCameronIndex = 0;
            cameron.add(0);

            for (int i = 1; i < n; i++) {
                if (intervals[i][0] >= intervals[lastCameronIndex][1]) {
                    cameron.add(i);
                    lastCameronIndex = i;
                }
            }

            int lastJamieIndex = -1;
            for (int i = 1; i < n; i++) {
                if (!cameron.contains(i)) {
                    jamie.add(i);
                    lastJamieIndex = i;
                    break;
                }
            }

            for (int i = 1; i < n; i++) {
                if (!cameron.contains(i) && intervals[i][0] >= intervals[lastJamieIndex][1]) {
                    jamie.add(i);
                    lastJamieIndex = i;
                }
            }

            StringBuilder result = new StringBuilder();
            if (cameron.size() + jamie.size() < intervals.length) {
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
            caseNumber++;
        }
    }
}