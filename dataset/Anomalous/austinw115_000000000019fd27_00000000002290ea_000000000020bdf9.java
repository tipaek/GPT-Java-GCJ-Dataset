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
            int[][] originalIntervals = new int[N][2];

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                intervals[j][0] = originalIntervals[j][0] = Integer.parseInt(st.nextToken());
                intervals[j][1] = originalIntervals[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            adjustIntervals(intervals);

            List<String> schedule = new ArrayList<>();
            schedule.add("C");
            String currentPerson = "C";
            boolean impossible = false;

            for (int a = 0; a < N - 1; a++) {
                if (overlaps(intervals[a], intervals[a + 1])) {
                    currentPerson = currentPerson.equals("C") ? "J" : "C";
                }
                schedule.add(currentPerson);
            }

            StringBuilder result = new StringBuilder();
            for (String s : schedule) {
                result.append(s);
            }

            String sortedSchedule = result.toString();
            List<Character> finalSchedule = new ArrayList<>();

            for (int w = 0; w < N; w++) {
                for (int x = 0; x < N; x++) {
                    if (Arrays.equals(originalIntervals[w], intervals[x])) {
                        finalSchedule.add(sortedSchedule.charAt(x));
                    }
                }
            }

            for (int k = 0; k < N - 1; k++) {
                for (int l = k + 1; l < N; l++) {
                    if (overlaps(intervals[k], intervals[l]) && hasTripleOverlap(intervals, k, l, N)) {
                        impossible = true;
                    }
                }
            }

            StringBuilder finalResult = new StringBuilder();
            for (char c : finalSchedule) {
                finalResult.append(c);
            }

            if (impossible) {
                pw.println("Case #" + i + ": IMPOSSIBLE");
            } else if (sortedSchedule.length() <= 2) {
                pw.println("Case #" + i + ": " + sortedSchedule);
            } else {
                pw.println("Case #" + i + ": " + finalResult.toString());
            }
        }
        pw.close();
    }

    private static boolean hasTripleOverlap(int[][] intervals, int i, int j, int N) {
        for (int s = 0; s < N; s++) {
            if (s != i && s != j && overlaps(intervals[s], intervals[i]) && overlaps(intervals[s], intervals[j])) {
                return true;
            }
        }
        return false;
    }

    private static boolean overlaps(int[] a, int[] b) {
        return a[0] < b[0] ? a[1] > b[0] : b[1] > a[0];
    }

    private static void adjustIntervals(int[][] intervals) {
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] == intervals[i - 1][0] && intervals[i - 1][1] > intervals[i][1]) {
                int temp = intervals[i][1];
                intervals[i][1] = intervals[i - 1][1];
                intervals[i - 1][1] = temp;
            }
        }
    }
}