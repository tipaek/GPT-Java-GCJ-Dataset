import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();

        for (int test = 1; test <= tests; test++) {
            int n = sc.nextInt();
            ArrayList<int[]> cJobs = new ArrayList<>();
            ArrayList<int[]> jJobs = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            int[][] jobs = new int[n][2];
            for (int i = 0; i < n; i++) {
                jobs[i][0] = sc.nextInt();
                jobs[i][1] = sc.nextInt();
            }

            boolean isPossible = true;
            for (int i = 0; i < n; i++) {
                int[] job = jobs[i];
                if (isValid(cJobs, job)) {
                    cJobs.add(job);
                    result.append("C");
                } else if (isValid(jJobs, job)) {
                    jJobs.add(job);
                    result.append("J");
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + test + ": " + result);
        }

        sc.close();
    }

    private static boolean isValid(ArrayList<int[]> schedule, int[] job) {
        int start = job[0];
        int end = job[1];

        for (int[] currentJob : schedule) {
            int currentStart = currentJob[0];
            int currentEnd = currentJob[1];

            if ((currentStart < end && currentStart >= start) || (start < currentEnd && start >= currentStart)) {
                return false;
            }
        }

        return true;
    }
}