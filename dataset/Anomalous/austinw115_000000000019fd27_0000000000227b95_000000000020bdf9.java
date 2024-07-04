import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("solution.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("solution.out")));
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

            String[] assignment = new String[N];
            boolean impossible = false;
            String currentAssignee = "C";
            assignment[0] = currentAssignee;

            for (int j = 1; j < N; j++) {
                if (isOverlapping(intervals[j - 1], intervals[j])) {
                    if (hasTripleOverlap(intervals, j - 1, j, N)) {
                        impossible = true;
                        break;
                    }
                    currentAssignee = currentAssignee.equals("C") ? "J" : "C";
                }
                assignment[j] = currentAssignee;
            }

            StringBuilder result = new StringBuilder();
            if (impossible) {
                result.append("IMPOSSIBLE");
            } else {
                HashMap<int[], String> map = new HashMap<>();
                for (int j = 0; j < N; j++) {
                    map.put(intervals[j], assignment[j]);
                }
                for (int[] interval : originalIntervals) {
                    result.append(map.get(interval));
                }
            }

            pw.println("Case #" + i + ": " + result.toString());
        }
        pw.close();
    }

    private static boolean isOverlapping(int[] interval1, int[] interval2) {
        return interval1[1] > interval2[0];
    }

    private static boolean hasTripleOverlap(int[][] intervals, int index1, int index2, int N) {
        for (int i = 0; i < N; i++) {
            if (i != index1 && i != index2) {
                if (isOverlapping(intervals[i], intervals[index1]) && isOverlapping(intervals[i], intervals[index2])) {
                    return true;
                }
            }
        }
        return false;
    }
}