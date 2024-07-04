import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        List<String> results = new ArrayList<>();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            List<int[]> intervals = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                intervals.add(new int[]{scanner.nextInt(), scanner.nextInt()});
            }
            results.add(assignTasks(intervals));
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }

    private static String assignTasks(List<int[]> intervals) {
        char[] assignments = new char[intervals.size()];
        Map<int[], Integer> originalIndices = new HashMap<>();
        for (int i = 0; i < intervals.size(); i++) {
            originalIndices.put(intervals.get(i), i);
        }

        intervals.sort(Comparator.comparingInt(a -> a[0]));

        int endC = -1, endJ = -1;
        for (int[] interval : intervals) {
            if (interval[0] >= endC) {
                assignments[originalIndices.get(interval)] = 'C';
                endC = interval[1];
            } else if (interval[0] >= endJ) {
                assignments[originalIndices.get(interval)] = 'J';
                endJ = interval[1];
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(assignments);
    }
}