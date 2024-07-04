import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();

        for (int test = 1; test <= tests; test++) {
            int n = sc.nextInt();
            String result = assignJobs(sc, n);
            System.out.println("Case #" + test + ": " + result);
        }
    }

    private static String assignJobs(Scanner sc, int n) {
        List<int[]> cJobs = new ArrayList<>();
        List<int[]> jJobs = new ArrayList<>();
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
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }

    private static boolean isValid(List<int[]> schedule, int[] job) {
        int start = job[0];
        int end = job[1];

        for (int[] currentJob : schedule) {
            int currStart = currentJob[0];
            int currEnd = currentJob[1];

            if ((currStart < end && currStart >= start) || (start < currEnd && start >= currStart)) {
                return false;
            }
        }
        return true;
    }
}