import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    private static final String CASE_OUTPUT = "Case #%d: %s";
    private static final String IMPOSSIBLE_OUTPUT = "Case #%d: IMPOSSIBLE";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
                new Solution().processCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processCase(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        int[][] intervals = new int[n][4];
        
        for (int i = 0; i < n; ++i) {
            intervals[i][0] = i;
            intervals[i][1] = scanner.nextInt();
            intervals[i][2] = scanner.nextInt();
        }

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));

        int cEnd = 0, jEnd = 0;
        for (int[] interval : intervals) {
            if (cEnd <= interval[1]) {
                interval[3] = 0; // C
                cEnd = interval[2];
            } else if (jEnd <= interval[1]) {
                interval[3] = 1; // J
                jEnd = interval[2];
            } else {
                System.out.println(String.format(IMPOSSIBLE_OUTPUT, caseNum));
                return;
            }
        }

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        StringBuilder result = new StringBuilder();
        for (int[] interval : intervals) {
            result.append(interval[3] == 0 ? 'C' : 'J');
        }

        System.out.println(String.format(CASE_OUTPUT, caseNum, result.toString()));
    }
}