import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();

        for (int test = 1; test <= tests; test++) {
            ArrayList<int[]> cjobs = new ArrayList<>();
            ArrayList<int[]> jjobs = new ArrayList<>();
            int n = sc.nextInt();
            StringBuilder result = new StringBuilder();
            int[] testnums = new int[2 * n];

            for (int j = 0; j < 2 * n; j++) {
                testnums[j] = sc.nextInt();
            }

            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                int start = testnums[2 * i];
                int end = testnums[2 * i + 1];
                int[] currjob = {start, end};

                if (isValid(cjobs, currjob)) {
                    cjobs.add(currjob);
                    result.append("C");
                } else if (isValid(jjobs, currjob)) {
                    jjobs.add(currjob);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            System.out.println("Case #" + test + ": " + result.toString());
        }
    }

    private static boolean isValid(ArrayList<int[]> sched, int[] job) {
        int start = job[0];
        int end = job[1];

        for (int[] curr : sched) {
            int currstart = curr[0];
            int currend = curr[1];

            if ((currstart < end && currend > start)) {
                return false;
            }
        }
        return true;
    }
}