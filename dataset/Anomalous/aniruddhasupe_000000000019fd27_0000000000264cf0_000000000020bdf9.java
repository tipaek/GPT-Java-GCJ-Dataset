import java.io.*;
import java.util.*;

public class Solution {

    public static boolean checkExists(List<int[]> intervals, int start, int end, int index) {
        intervals.sort(Comparator.comparingInt(o -> o[0]));

        for (int i = index; i < intervals.size(); i++) {
            int[] interval = intervals.get(i);
            if ((interval[1] <= start && interval[1] <= end) || (interval[0] >= start && interval[0] >= end)) {
                if (i != intervals.size() - 1) {
                    return checkExists(intervals, start, end, i + 1);
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= t; caseNumber++) {
            int work = scanner.nextInt();
            List<int[]> jamie = new ArrayList<>();
            List<int[]> cameron = new ArrayList<>();
            StringBuilder schedule = new StringBuilder();

            jamie.add(new int[]{scanner.nextInt(), scanner.nextInt()});
            schedule.append("J");

            for (int i = 1; i < work; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (checkExists(jamie, start, end, 0)) {
                    jamie.add(new int[]{start, end});
                    schedule.append("J");
                } else if (cameron.isEmpty()) {
                    cameron.add(new int[]{start, end});
                    schedule.append("C");
                } else {
                    if (checkExists(cameron, start, end, 0)) {
                        cameron.add(new int[]{start, end});
                        schedule.append("C");
                    } else {
                        schedule.setLength(0);
                        schedule.append("IMPOSSIBLE");
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + schedule);
        }
    }
}