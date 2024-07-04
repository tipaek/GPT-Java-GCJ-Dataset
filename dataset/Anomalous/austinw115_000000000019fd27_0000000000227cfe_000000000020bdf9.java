import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 32768);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] intervals = new int[N][2];
            int[][] originalIntervals = new int[N][2];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                intervals[j][0] = start;
                intervals[j][1] = end;
                originalIntervals[j][0] = start;
                originalIntervals[j][1] = end;
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            intervals = secondarySort(intervals);

            List<String> assignments = new ArrayList<>();
            String currentPerson = "C";
            boolean isImpossible = false;
            assignments.add(currentPerson);

            for (int a = 0; a < N - 1; a++) {
                if (overlaps(intervals[a], intervals[a + 1])) {
                    if (hasTripleOverlap(intervals, a, a + 1, N)) {
                        isImpossible = true;
                        break;
                    }
                    currentPerson = currentPerson.equals("J") ? "C" : "J";
                }
                assignments.add(currentPerson);
            }

            StringBuilder sortedAssignments = new StringBuilder();
            for (String assignment : assignments) {
                sortedAssignments.append(assignment);
            }

            List<Character> finalAssignments = new ArrayList<>();
            for (int w = 0; w < N; w++) {
                for (int x = 0; x < N; x++) {
                    if (originalIntervals[w][0] == intervals[x][0] && originalIntervals[w][1] == intervals[x][1]) {
                        finalAssignments.add(sortedAssignments.charAt(x));
                    }
                }
            }

            StringBuilder finalResult = new StringBuilder();
            for (char assignment : finalAssignments) {
                finalResult.append(assignment);
            }

            if (isImpossible) {
                pw.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                pw.println("Case #" + i + ": " + finalResult.toString());
            }
        }
        pw.close();
    }

    private static boolean hasTripleOverlap(int[][] intervals, int i, int j, int N) {
        for (int s = 0; s < N; s++) {
            if (s != i && s != j) {
                if (overlaps(intervals[s], intervals[i]) && overlaps(intervals[s], intervals[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean overlaps(int[] interval1, int[] interval2) {
        return interval1[1] > interval2[0] && interval2[1] > interval1[0];
    }

    private static int[][] secondarySort(int[][] intervals) {
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