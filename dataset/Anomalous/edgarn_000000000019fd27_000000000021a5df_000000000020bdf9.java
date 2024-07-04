import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();

        for (int test = 1; test <= tests; test++) {
            int n = sc.nextInt();
            ArrayList<Integer> testnums = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                testnums.add(sc.nextInt());
                testnums.add(sc.nextInt());
            }

            String result = scheduleJobs(n, testnums);
            System.out.println("Case #" + test + ": " + result);
        }
    }

    private static String scheduleJobs(int n, ArrayList<Integer> testnums) {
        ArrayList<ArrayList<Integer>> cjobs = new ArrayList<>();
        ArrayList<ArrayList<Integer>> jjobs = new ArrayList<>();
        StringBuilder result = new StringBuilder();

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
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }

    private static boolean isValid(ArrayList<ArrayList<Integer>> sched, ArrayList<Integer> job) {
        int start = job.get(0);
        int end = job.get(1);

        for (ArrayList<Integer> curr : sched) {
            int currstart = curr.get(0);
            int currend = curr.get(1);

            if ((currstart < end && currstart >= start) || (start < currend && start >= currstart)) {
                return false;
            }
        }
        return true;
    }
}