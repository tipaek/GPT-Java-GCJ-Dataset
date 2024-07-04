import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int k = 1; k <= t; k++) {
            int n = Integer.parseInt(sc.nextLine());
            List<int[]> allIntervals = new ArrayList<>();
            List<int[]> cIntervals = new ArrayList<>();
            List<int[]> jIntervals = new ArrayList<>();
            StringBuilder output = new StringBuilder();

            for (int i = 0; i < n; i++) {
                String[] line = sc.nextLine().split(" ");
                int s = Integer.parseInt(line[0]);
                int e = Integer.parseInt(line[1]);
                allIntervals.add(new int[]{s, e});
            }

            boolean isPossible = true;
            for (int[] interval : allIntervals) {
                if (!hasOverlappingIntervals(cIntervals, interval)) {
                    cIntervals.add(interval);
                    output.append("C");
                } else if (!hasOverlappingIntervals(jIntervals, interval)) {
                    jIntervals.add(interval);
                    output.append("J");
                } else {
                    output = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible && output.length() != n) {
                throw new IllegalStateException();
            }
            System.out.println("Case #" + k + ": " + output);
        }
    }

    private static boolean activitiesNotOverlap(int s1, int e1, int s2, int e2) {
        return e1 <= s2 || e2 <= s1;
    }

    private static boolean hasOverlappingIntervals(List<int[]> intervals, int[] interval) {
        for (int[] currInterval : intervals) {
            if (!activitiesNotOverlap(currInterval[0], currInterval[1], interval[0], interval[1])) {
                return true;
            }
        }
        return false;
    }
}