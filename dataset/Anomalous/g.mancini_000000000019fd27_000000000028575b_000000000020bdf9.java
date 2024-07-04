import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        // Uncomment the following line to solve the Nesting Depth problem
        // solve(Solution::solveNestingDepthLine);
        solve(Solution::solveParentingPartnering);
        System.exit(0);
    }

    private static void solve(Function<Scanner, String> solveLine) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();

        for (int i = 0; i < testCases; i++) {
            writeSolutionLine(i + 1, solveLine.apply(in));
        }
    }

    private static String solveParentingPartnering(Scanner in) {
        int n = in.nextInt();
        List<Activity> cHours = new LinkedList<>();
        List<Activity> jHours = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            if (canDoWork(start, end, cHours)) {
                cHours.add(new Activity(start, end));
                result.append("C");
            } else if (canDoWork(start, end, jHours)) {
                jHours.add(new Activity(start, end));
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }

    private static boolean canDoWork(int start, int end, List<Activity> activities) {
        for (Activity activity : activities) {
            if ((start >= activity.start && start < activity.end) || (end > activity.start && end <= activity.end)) {
                return false;
            }
        }
        return true;
    }

    private static String solveNestingDepthLine(Scanner in) {
        String input = in.next();
        StringBuilder result = new StringBuilder();
        int parenthesis = 0;

        for (char charN : input.toCharArray()) {
            int n = charN - '0';
            while (parenthesis < n) {
                result.append('(');
                parenthesis++;
            }
            while (parenthesis > n) {
                result.append(')');
                parenthesis--;
            }
            result.append(n);
        }
        while (parenthesis > 0) {
            result.append(')');
            parenthesis--;
        }
        return result.toString();
    }

    private static void writeSolutionLine(long index, String output) {
        System.out.println("Case #" + index + ": " + output);
    }

    private static class Activity {
        int start;
        int end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}