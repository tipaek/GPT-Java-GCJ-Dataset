import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int[][] intervals = readIntervals(scanner);
            String[] result = assignTasks(intervals);

            System.out.println("Case #" + testCase + ": " + String.join(" ", result));
        }
    }

    static String[] assignTasks(int[][] intervals) {
        final int START = 0;
        final int END = 1;
        final int INDEX = 2;
        final int ASSIGNED = 3;

        List<String> assignments = new ArrayList<>(intervals.length);

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[START]));

        int lastEndC = -1;
        int lastEndJ = -1;
        for (int[] interval : intervals) {
            if (lastEndC == -1 || lastEndC <= interval[START]) {
                lastEndC = interval[END];
                interval[ASSIGNED] = 0; // Assigned to C
            } else if (lastEndJ == -1 || lastEndJ <= interval[START]) {
                lastEndJ = interval[END];
                interval[ASSIGNED] = 1; // Assigned to J
            } else {
                return new String[]{"IMPOSSIBLE"};
            }
        }

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[INDEX]));

        for (int[] interval : intervals) {
            assignments.add(interval[ASSIGNED] == 0 ? "C" : "J");
        }

        return new String[]{String.join("", assignments)};
    }

    private static int[][] readIntervals(Scanner scanner) {
        int n = scanner.nextInt();
        scanner.nextLine();
        int[][] intervals = new int[n][4];
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            intervals[i][0] = Integer.parseInt(input[0]);
            intervals[i][1] = Integer.parseInt(input[1]);
            intervals[i][2] = i; // original index
            intervals[i][3] = 0; // person assignment placeholder
        }
        return intervals;
    }
}