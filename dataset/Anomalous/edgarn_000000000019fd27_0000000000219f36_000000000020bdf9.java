import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tests = sc.nextInt();

        for (int test = 1; test <= tests; test++) {
            int n = sc.nextInt();
            String result = "";
            ArrayList<int[]> jobs = new ArrayList<>();

            // Reading input
            for (int j = 0; j < n; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                jobs.add(new int[]{start, end});
            }

            ArrayList<int[]> cJobs = new ArrayList<>();
            ArrayList<int[]> jJobs = new ArrayList<>();

            for (int[] job : jobs) {
                if (isValid(cJobs, job)) {
                    cJobs.add(job);
                    result += "C";
                } else if (isValid(jJobs, job)) {
                    jJobs.add(job);
                    result += "J";
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            System.out.println("Case #" + test + ": " + result);
        }
    }

    private static boolean isValid(ArrayList<int[]> schedule, int[] job) {
        int start = job[0];
        int end = job[1];

        for (int[] curr : schedule) {
            int currStart = curr[0];
            int currEnd = curr[1];

            if ((start < currEnd && end > currStart)) {
                return false;
            }
        }

        return true;
    }
}