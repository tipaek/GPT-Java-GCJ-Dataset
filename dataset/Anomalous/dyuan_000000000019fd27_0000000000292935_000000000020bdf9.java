import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
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
        List<int[]> sortedIntervals = new ArrayList<>(intervals);
        sortedIntervals.sort((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        Set<int[]> duplicateIntervals = new HashSet<>();
        if (sortedIntervals.size() > 1 && Arrays.equals(sortedIntervals.get(0), sortedIntervals.get(1))) {
            duplicateIntervals.add(sortedIntervals.get(0));
        }

        StringBuilder schedule = new StringBuilder("C");
        int cEnd = sortedIntervals.get(0)[1];
        int jEnd = 0;

        for (int i = 1; i < sortedIntervals.size(); i++) {
            if (i != sortedIntervals.size() - 1 && Arrays.equals(sortedIntervals.get(i), sortedIntervals.get(i + 1))) {
                duplicateIntervals.add(sortedIntervals.get(i));
            }
            if (sortedIntervals.get(i)[0] >= cEnd) {
                schedule.append("C");
                cEnd = sortedIntervals.get(i)[1];
            } else if (sortedIntervals.get(i)[0] >= jEnd) {
                schedule.append("J");
                jEnd = sortedIntervals.get(i)[1];
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder finalSchedule = new StringBuilder();
        Set<int[]> viewedIntervals = new HashSet<>();

        for (int[] interval : intervals) {
            for (int j = 0; j < sortedIntervals.size(); j++) {
                if (Arrays.equals(interval, sortedIntervals.get(j))) {
                    if (duplicateIntervals.contains(sortedIntervals.get(j)) && viewedIntervals.contains(sortedIntervals.get(j))) {
                        continue;
                    }
                    viewedIntervals.add(sortedIntervals.get(j));
                    finalSchedule.append(schedule.charAt(j));
                    break;
                }
            }
        }

        return finalSchedule.toString();
    }
}