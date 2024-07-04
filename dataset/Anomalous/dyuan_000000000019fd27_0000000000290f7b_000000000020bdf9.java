import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            List<int[]> intervals = new ArrayList<>();
            
            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new int[]{start, end});
            }
            
            String result = solve(intervals);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    static String solve(List<int[]> intervals) {
        List<int[]> originalIntervals = new ArrayList<>(intervals);
        intervals.sort(Comparator.comparingInt((int[] interval) -> interval[0])
                                 .thenComparingInt(interval -> interval[1]));

        StringBuilder assignment = new StringBuilder("C");
        int cEnd = intervals.get(0)[1];
        int jEnd = 0;

        for (int i = 1; i < intervals.size(); i++) {
            int start = intervals.get(i)[0];
            int end = intervals.get(i)[1];

            if (start >= cEnd) {
                assignment.append("C");
                cEnd = end;
            } else if (start >= jEnd) {
                assignment.append("J");
                jEnd = end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder result = new StringBuilder();
        for (int[] originalInterval : originalIntervals) {
            for (int i = 0; i < intervals.size(); i++) {
                if (Arrays.equals(originalInterval, intervals.get(i))) {
                    result.append(assignment.charAt(i));
                    break;
                }
            }
        }

        return result.toString();
    }
}