import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            System.out.print("Case #" + caseNumber + ": ");
            int n = scanner.nextInt();
            List<int[]> cIntervals = new ArrayList<>();
            List<int[]> jIntervals = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            boolean possible = true;

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean assigned = false;

                // Try to assign to C
                if (isNonOverlapping(cIntervals, start, end)) {
                    cIntervals.add(new int[]{start, end});
                    result.append("C");
                    assigned = true;
                } else if (isNonOverlapping(jIntervals, start, end)) {
                    // Try to assign to J
                    jIntervals.add(new int[]{start, end});
                    result.append("J");
                    assigned = true;
                }

                if (!assigned) {
                    possible = false;
                    // Skip the remaining intervals for this case
                    for (int j = i + 1; j < n; j++) {
                        scanner.nextInt();
                        scanner.nextInt();
                    }
                    break;
                }
            }

            if (!possible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result.toString());
            }
        }
    }

    private static boolean isNonOverlapping(List<int[]> intervals, int start, int end) {
        for (int[] interval : intervals) {
            if (start < interval[1] && end > interval[0]) {
                return false;
            }
        }
        return true;
    }
}