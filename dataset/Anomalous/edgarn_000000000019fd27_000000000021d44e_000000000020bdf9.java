import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tests = sc.nextInt();

        for (int test = 1; test <= tests; test++) {
            ArrayList<ArrayList<Integer>> cjobs = new ArrayList<>();
            ArrayList<ArrayList<Integer>> jjobs = new ArrayList<>();

            int n = sc.nextInt();
            StringBuilder result = new StringBuilder();

            ArrayList<Integer> testnums = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                testnums.add(start);
                testnums.add(end);
            }

            boolean possible = true;

            for (int i = 0; i < n; i++) {
                int start = testnums.get(2 * i);
                int end = testnums.get(2 * i + 1);

                ArrayList<Integer> currjob = new ArrayList<>();
                currjob.add(start);
                currjob.add(end);

                if (isValid(cjobs, currjob)) {
                    cjobs.add(currjob);
                    result.append("C");
                } else if (isValid(jjobs, currjob)) {
                    jjobs.add(currjob);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            System.out.println("Case #" + test + ": " + result);
        }
    }

    private static boolean isValid(ArrayList<ArrayList<Integer>> sched, ArrayList<Integer> job) {
        int start = job.get(0);
        int end = job.get(1);

        for (ArrayList<Integer> curr : sched) {
            int currstart = curr.get(0);
            int currend = curr.get(1);

            if ((currstart < end && currstart >= start) || (currend <= end && currend > start) || 
                (start >= currstart && end <= currend) || (currstart >= start && currend <= end)) {
                return false;
            }
        }
        return true;
    }
}