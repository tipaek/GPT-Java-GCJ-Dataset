import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];

            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }

            String result = assignTasks(intervals, n);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String assignTasks(int[][] intervals, int n) {
        List<Integer> cameronStart = new ArrayList<>();
        List<Integer> cameronEnd = new ArrayList<>();
        List<Integer> jamesStart = new ArrayList<>();
        List<Integer> jamesEnd = new ArrayList<>();

        cameronStart.add(intervals[0][0]);
        cameronEnd.add(intervals[0][1]);
        StringBuilder assignment = new StringBuilder("C");

        for (int j = 1; j < n; j++) {
            if (canAssign(intervals[j], cameronStart, cameronEnd)) {
                cameronStart.add(intervals[j][0]);
                cameronEnd.add(intervals[j][1]);
                assignment.append("C");
            } else if (canAssign(intervals[j], jamesStart, jamesEnd)) {
                jamesStart.add(intervals[j][0]);
                jamesEnd.add(intervals[j][1]);
                assignment.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return assignment.toString();
    }

    private static boolean canAssign(int[] interval, List<Integer> startList, List<Integer> endList) {
        for (int k = 0; k < startList.size(); k++) {
            if ((interval[0] >= startList.get(k) && interval[0] < endList.get(k)) ||
                (interval[1] > startList.get(k) && interval[1] <= endList.get(k))) {
                return false;
            }
        }
        return true;
    }
}