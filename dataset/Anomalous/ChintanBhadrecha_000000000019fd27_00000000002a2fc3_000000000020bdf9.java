import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfTest = sc.nextInt();
        String[] solution = new String[noOfTest];

        for (int t = 0; t < noOfTest; t++) {
            int n = sc.nextInt();
            ArrayList<int[]> intervals = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                intervals.add(new int[]{sc.nextInt(), sc.nextInt(), i});
            }
            solution[t] = assignTasks(intervals);
        }

        for (int i = 0; i < solution.length; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solution[i]);
        }
    }

    private static String assignTasks(ArrayList<int[]> intervals) {
        intervals.sort(Comparator.comparingInt(a -> a[0]));
        char[] result = new char[intervals.size()];
        int[] cEnd = null, jEnd = null;

        for (int[] interval : intervals) {
            if (cEnd == null || cEnd[1] <= interval[0]) {
                cEnd = interval;
                result[interval[2]] = 'C';
            } else if (jEnd == null || jEnd[1] <= interval[0]) {
                jEnd = interval;
                result[interval[2]] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(result);
    }
}