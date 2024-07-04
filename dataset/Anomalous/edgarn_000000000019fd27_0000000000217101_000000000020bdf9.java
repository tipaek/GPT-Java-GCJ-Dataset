import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tests = sc.nextInt();

        for (int test = 1; test <= tests; test++) {
            int n = sc.nextInt();

            ArrayList<ArrayList<Integer>> cJobs = new ArrayList<>();
            ArrayList<ArrayList<Integer>> jJobs = new ArrayList<>();

            StringBuilder result = new StringBuilder();

            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();

                ArrayList<Integer> currJob = new ArrayList<>();
                currJob.add(start);
                currJob.add(end);

                if (isValid(cJobs, currJob)) {
                    cJobs.add(currJob);
                    result.append("C");
                } else if (isValid(jJobs, currJob)) {
                    jJobs.add(currJob);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + test + ": " + result);
            } else {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean isValid(ArrayList<ArrayList<Integer>> schedule, ArrayList<Integer> job) {
        int start = job.get(0);
        int end = job.get(1);

        for (ArrayList<Integer> curr : schedule) {
            int currStart = curr.get(0);
            int currEnd = curr.get(1);

            if ((currStart < end && currStart >= start) || (currEnd > start && currEnd <= end) ||
                (start < currEnd && start >= currStart) || (end > currStart && end <= currEnd)) {
                return false;
            }
        }

        return true;
    }
}