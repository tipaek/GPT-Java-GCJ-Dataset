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

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();

                int[] currentJob = new int[]{start, end};

                if (isValid(cJobs, currentJob)) {
                    cJobs.add(currentJob);
                    result.append("C");
                } else if (isValid(jJobs, currentJob)) {
                    jJobs.add(currentJob);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + test + ": " + result);
        }
    }

    private static boolean isValid(ArrayList<int[]> schedule, int[] job) {
        int start = job[0];
        int end = job[1];

        for (int[] current : schedule) {
            int currStart = current[0];
            int currEnd = current[1];

            if ((currStart < end && currStart >= start) || (start < currEnd && start >= currStart)) {
                return false;
            }
        }

        return true;
    }
}