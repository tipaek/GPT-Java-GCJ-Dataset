import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class Solution {

    public static void main(String[] args) {
        execute(Solution::resolveParentingPartnering);
        System.exit(0);
    }

    private static void execute(Function<Scanner, String> lineResolver) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();

            for (int i = 0; i < testCases; i++) {
                displaySolution(i + 1, lineResolver.apply(scanner));
            }
        }
    }

    private static String resolveParentingPartnering(Scanner scanner) {
        StringBuilder result = new StringBuilder();
        int n = scanner.nextInt();
        List<int[]> cSchedule = new ArrayList<>();
        List<int[]> jSchedule = new ArrayList<>();
        boolean isImpossible = false;

        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            if (isImpossible) {
                continue;
            }
            if (isAvailable(start, end, cSchedule)) {
                cSchedule.add(new int[]{start, end});
                result.append("C");
            } else if (isAvailable(start, end, jSchedule)) {
                jSchedule.add(new int[]{start, end});
                result.append("J");
            } else {
                result = new StringBuilder("IMPOSSIBLE");
                isImpossible = true;
            }
        }
        return result.toString();
    }

    private static boolean isAvailable(int start, int end, List<int[]> schedule) {
        for (int[] interval : schedule) {
            int intervalStart = interval[0];
            int intervalEnd = interval[1];
            if ((start < intervalEnd && end > intervalStart)) {
                return false;
            }
        }
        return true;
    }

    private static void displaySolution(long index, String output) {
        System.out.println("Case #" + index + ": " + output);
    }
}