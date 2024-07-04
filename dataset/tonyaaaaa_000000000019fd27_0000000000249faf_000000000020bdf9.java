import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scan.nextInt();
        for (int test = 1; test <= tests; test++) {
            int n = scan.nextInt();
            List<int[]> activities = new ArrayList<>();
            List<int[]> cameron = new ArrayList<>();
            List<int[]> jamie = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            boolean impossible = false;
            for (int i = 0; i < n; i++) {
                int from = scan.nextInt();
                int to = scan.nextInt();
                activities.add(new int[] {from, to, i});
            }
            activities.sort((a1, a2) -> a2[1] - a1[1]);
            char[] assignments = new char[n];
            for (int[] activity : activities) {
                int from = activity[0];
                int to = activity[1];
                if (!impossible && isFree(cameron, from, to)) {
                    cameron.add(new int[] {from, to});
                    assignments[activity[2]] = 'C';
                } else if (!impossible && isFree(jamie, from, to)) {
                    jamie.add(new int[] {from, to});
                    assignments[activity[2]] = 'J';
                } else {
                    impossible = true;
                }

            }
            System.out.println("Case #" + test + ": " + (impossible ? "IMPOSSIBLE" : new String(assignments)));
        }
    }

    private static boolean isFree(List<int[]> schedule, int from, int to) {
        return schedule.isEmpty() || schedule.get(schedule.size() - 1)[0] >= to;
    }
}
