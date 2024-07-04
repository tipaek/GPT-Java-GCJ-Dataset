import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tests = sc.nextInt();

        for (int test = 1; test <= tests; test++) {
            List<List<Integer>> cjobs = new ArrayList<>();
            List<List<Integer>> jjobs = new ArrayList<>();

            int n = sc.nextInt();
            StringBuilder result = new StringBuilder();

            List<Integer> testnums = new ArrayList<>();

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

                List<Integer> currjob = Arrays.asList(start, end);

                if (valid(cjobs, currjob)) {
                    cjobs.add(currjob);
                    result.append("C");
                } else if (valid(jjobs, currjob)) {
                    jjobs.add(currjob);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + test + ": " + result);
            } else {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            }
        }
        sc.close();
    }

    private static boolean valid(List<List<Integer>> sched, List<Integer> job) {
        int start = job.get(0);
        int end = job.get(1);

        for (List<Integer> curr : sched) {
            int currstart = curr.get(0);
            int currend = curr.get(1);

            if (currstart == start || (start < currend && end > currstart)) {
                return false;
            }
        }
        return true;
    }
}