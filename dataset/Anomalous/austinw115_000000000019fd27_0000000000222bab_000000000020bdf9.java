import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 32768);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[][] intervals = new int[N][2];

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                intervals[j][0] = Integer.parseInt(st.nextToken());
                intervals[j][1] = Integer.parseInt(st.nextToken());
            }

            int[][] sortedIntervals = sortByColumn(intervals, 0);
            int[][] rearrangedIntervals = rearrangeIntervals(sortedIntervals);

            StringBuilder schedule = new StringBuilder();
            String currentPerson = "C";
            schedule.append(currentPerson);

            boolean impossible = false;
            for (int k = 1; k < N; k++) {
                if (overlaps(rearrangedIntervals[k - 1], rearrangedIntervals[k])) {
                    currentPerson = currentPerson.equals("C") ? "J" : "C";
                }
                schedule.append(currentPerson);

                if (currentPerson.equals(schedule.charAt(k - 1))) {
                    impossible = true;
                }
            }

            String result = schedule.toString();
            if (impossible) {
                pw.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                pw.println("Case #" + i + ": " + result);
            }
        }
        pw.close();
    }

    public static boolean overlaps(int[] interval1, int[] interval2) {
        return interval1[1] > interval2[0];
    }

    public static int[][] sortByColumn(int[][] array, int column) {
        Arrays.sort(array, Comparator.comparingInt(o -> o[column]));
        return array;
    }

    public static int[][] rearrangeIntervals(int[][] intervals) {
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] == intervals[i - 1][0] && intervals[i][1] < intervals[i - 1][1]) {
                int temp = intervals[i][1];
                intervals[i][1] = intervals[i - 1][1];
                intervals[i - 1][1] = temp;
            }
        }
        return intervals;
    }
}