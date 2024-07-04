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
        try (Scanner in = new Scanner(System.in)) {
            long testCases = in.nextLong();
            for (int i = 0; i < testCases; i++) {
                writeSolutionLine(i + 1, solveLine.apply(in));
            }
        }
    }

    private static String solveParentingPartnering(Scanner in) {
        StringBuilder result = new StringBuilder();
        int n = in.nextInt();
        List<int[]> cHours = new ArrayList<>();
        List<int[]> jHours = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
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

    private static boolean canDoWork(int start, int end, List<int[]> works) {
        for (int[] work : works) {
            int wStart = work[0];
            int wEnd = work[1];
            if (start < wEnd && end > wStart) {
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
            int n = Character.getNumericValue(charN);
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
}