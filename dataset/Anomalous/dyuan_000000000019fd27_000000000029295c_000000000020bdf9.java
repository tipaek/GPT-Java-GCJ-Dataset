import java.util.*;
import java.io.*;

public class Returns {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            List<int[]> intervals = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new int[]{start, end});
            }
            System.out.println("Case #" + i + ": " + getSchedule(intervals));
        }
    }

    static String getSchedule(List<int[]> intervals) {
        List<int[]> originalIntervals = new ArrayList<>(intervals);
        intervals.sort((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        
        Set<int[]> duplicateIntervals = new HashSet<>();
        if (intervals.size() > 1 && Arrays.equals(intervals.get(0), intervals.get(1))) {
            duplicateIntervals.add(intervals.get(0));
        }

        StringBuilder result = new StringBuilder("C");
        int cEnd = intervals.get(0)[1];
        int jEnd = 0;

        for (int i = 1; i < intervals.size(); i++) {
            if (i < intervals.size() - 1 && Arrays.equals(intervals.get(i), intervals.get(i + 1))) {
                duplicateIntervals.add(intervals.get(i));
            }
            if (intervals.get(i)[0] >= cEnd) {
                result.append("C");
                cEnd = intervals.get(i)[1];
            } else if (intervals.get(i)[0] >= jEnd) {
                result.append("J");
                jEnd = intervals.get(i)[1];
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder finalResult = new StringBuilder();
        Set<int[]> viewedIntervals = new HashSet<>();
        for (int[] originalInterval : originalIntervals) {
            for (int j = 0; j < intervals.size(); j++) {
                if (Arrays.equals(originalInterval, intervals.get(j))) {
                    if (duplicateIntervals.contains(intervals.get(j)) && viewedIntervals.contains(intervals.get(j))) {
                        continue;
                    }
                    viewedIntervals.add(intervals.get(j));
                    finalResult.append(result.charAt(j));
                    break;
                }
            }
        }
        return finalResult.toString();
    }
}