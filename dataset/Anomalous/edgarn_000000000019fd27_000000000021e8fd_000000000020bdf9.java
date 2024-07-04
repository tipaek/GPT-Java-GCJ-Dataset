import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();

        for (int test = 1; test <= tests; test++) {
            int n = sc.nextInt();
            int[][] jobs = new int[n][2];
            for (int i = 0; i < n; i++) {
                jobs[i][0] = sc.nextInt();
                jobs[i][1] = sc.nextInt();
            }

            String result = scheduleJobs(jobs);
            System.out.println("Case #" + test + ": " + result);
        }
    }

    private static String scheduleJobs(int[][] jobs) {
        ArrayList<int[]> cJobs = new ArrayList<>();
        ArrayList<int[]> jJobs = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        for (int[] job : jobs) {
            if (isValid(cJobs, job)) {
                cJobs.add(job);
                result.append('C');
            } else if (isValid(jJobs, job)) {
                jJobs.add(job);
                result.append('J');
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

            if ((start >= currStart && start < currEnd) || (end > currStart && end <= currEnd) ||
                (currStart >= start && currStart < end) || (currEnd > start && currEnd <= end)) {
                return false;
            }
        }

        return true;
    }
}