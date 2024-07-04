import java.util.*;
import java.util.function.Function;

public class Solution {

    public static void main(String[] args) {
        solve(Solution::solveParentingPartnering);
        System.exit(0);
    }

    private static void solve(Function<Scanner, String> solveLine) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solveLine.apply(scanner));
        }
    }

    private static String solveParentingPartnering(Scanner scanner) {
        StringBuilder result = new StringBuilder();
        int n = scanner.nextInt();
        List<int[]> cHours = new ArrayList<>();
        List<int[]> jHours = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            if (canDoWork(start, end, cHours)) {
                cHours.add(new int[]{start, end});
                result.append("C");
            } else if (canDoWork(start, end, jHours)) {
                jHours.add(new int[]{start, end});
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }

    private static boolean canDoWork(int start, int end, List<int[]> hours) {
        for (int[] hour : hours) {
            int wStart = hour[0];
            int wEnd = hour[1];
            if ((start < wEnd && end > wStart)) {
                return false;
            }
        }
        return true;
    }
}