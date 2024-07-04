import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();

        for (int test = 1; test <= tests; test++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
            }

            String result = assignJobs(n, intervals);
            System.out.println("Case #" + test + ": " + result);
        }
    }

    private static String assignJobs(int n, int[][] intervals) {
        ArrayList<int[]> cJobs = new ArrayList<>();
        ArrayList<int[]> jJobs = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int[] currJob = intervals[i];
            if (isValid(cJobs, currJob)) {
                cJobs.add(currJob);
                result.append("C");
            } else if (isValid(jJobs, currJob)) {
                jJobs.add(currJob);
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }

    private static boolean isValid(ArrayList<int[]> schedule, int[] job) {
        int start = job[0];
        int end = job[1];

        for (int[] curr : schedule) {
            int currStart = curr[0];
            int currEnd = curr[1];

            if ((start < currEnd && end > currStart) || (currStart < end && currEnd > start)) {
                return false;
            }
        }
        return true;
    }
}