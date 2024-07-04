import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        solve(Solution::solveParentingPartnering);
        System.exit(0);
    }

    private static void solve(Function<Scanner, String> solveLine) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();

        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solveLine.apply(in));
        }
    }

    private static String solveParentingPartnering(Scanner in) {
        StringBuilder result = new StringBuilder();
        int n = in.nextInt();
        List<Hours> cHours = new LinkedList<>();
        List<Hours> jHours = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            if (canDoWork(start, end, cHours)) {
                cHours.add(new Hours(start, end));
                result.append("C");
            } else if (canDoWork(start, end, jHours)) {
                jHours.add(new Hours(start, end));
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }

    private static boolean canDoWork(int start, int end, List<Hours> works) {
        for (Hours hour : works) {
            if ((start < hour.end && end > hour.start)) {
                return false;
            }
        }
        return true;
    }

    private static class Hours {
        int start, end;

        Hours(int start, int end) {
            this.start = start;
            this.end = end;
        }
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
}