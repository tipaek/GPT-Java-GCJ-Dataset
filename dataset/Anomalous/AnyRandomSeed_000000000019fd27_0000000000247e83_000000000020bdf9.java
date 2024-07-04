import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static final boolean TEST_MODE = false;

    public static void main(String[] args) {
        if (TEST_MODE) {
            try {
                System.setIn(new FileInputStream(
                        System.getProperty("user.dir") + "/src/solution/jam2020_q3.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int i = 1; i <= testCases; i++) {
                int n = scanner.nextInt();
                int[][] intervals = new int[n][3];
                for (int j = 0; j < n; j++) {
                    intervals[j][0] = scanner.nextInt();
                    intervals[j][1] = scanner.nextInt();
                    intervals[j][2] = j;
                }
                System.out.println("Case #" + i + ": " + solve(intervals));
            }
        }
    }

    private static String solve(int[][] intervals) {
        Arrays.parallelSort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        char[] result = new char[intervals.length];
        int endJ = -1, endC = -1;

        for (int[] interval : intervals) {
            int start = interval[0];
            if (endJ <= start) {
                endJ = interval[1];
                result[interval[2]] = 'J';
            } else if (endC <= start) {
                endC = interval[1];
                result[interval[2]] = 'C';
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(result);
    }
}