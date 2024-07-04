import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // number of test cases

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] intervals = new int[n][2];
            for (int j = 0; j < n; j++) {
                intervals[j][0] = in.nextInt();
                intervals[j][1] = in.nextInt();
            }

            String result = assignTasks(intervals, n);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String assignTasks(int[][] intervals, int n) {
        StringBuilder answer = new StringBuilder("C");
        List<Integer> camTasks = new ArrayList<>();
        List<Integer> jamTasks = new ArrayList<>();
        camTasks.add(0);

        for (int x = 1; x < n; x++) {
            if (canAssign(camTasks, intervals, x)) {
                answer.append("C");
                camTasks.add(x);
            } else if (canAssign(jamTasks, intervals, x)) {
                answer.append("J");
                jamTasks.add(x);
            } else {
                return "IMPOSSIBLE";
            }
        }

        return answer.toString();
    }

    private static boolean canAssign(List<Integer> tasks, int[][] intervals, int currentIndex) {
        for (int taskIndex : tasks) {
            if (isOverlapping(intervals[taskIndex], intervals[currentIndex])) {
                return false;
            }
        }
        return true;
    }

    private static boolean isOverlapping(int[] interval1, int[] interval2) {
        return (interval1[0] < interval2[1] && interval2[0] < interval1[1]) ||
               (interval2[0] < interval1[1] && interval1[0] < interval2[1]);
    }
}