import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            
            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }

            String result = assignTasks(intervals, n);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static String assignTasks(int[][] intervals, int n) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        int lastEndC = 0;
        int lastEndJ = 0;
        StringBuilder schedule = new StringBuilder();

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (start >= lastEndC) {
                schedule.append("C");
                lastEndC = end;
            } else if (start >= lastEndJ) {
                schedule.append("J");
                lastEndJ = end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return schedule.toString();
    }
}