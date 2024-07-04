import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int caseCount = input.nextInt();
        for (int caseIndex = 1; caseIndex <= caseCount; caseIndex++) {
            System.out.println(String.format("Case #%d: %s", caseIndex, new Solution().solve(input)));
        }
    }

    public String solve(Scanner scanner) {
        int N = scanner.nextInt();
        int[][] intervals = new int[N][2];
        for (int i = 0; i < N; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
        }

        List<Integer> cAssignments = new ArrayList<>();
        List<Integer> jAssignments = new ArrayList<>();
        StringBuilder result = new StringBuilder("C");
        cAssignments.add(0);

        for (int i = 1; i < N; i++) {
            boolean cConflict = hasOverlap(intervals[i], cAssignments, intervals);
            boolean jConflict = hasOverlap(intervals[i], jAssignments, intervals);
            if (cConflict && jConflict) return "IMPOSSIBLE";
            if (cConflict) {
                result.append("J");
                jAssignments.add(i);
            } else {
                result.append("C");
                cAssignments.add(i);
            }
        }

        return result.toString();
    }

    private boolean hasOverlap(int[] interval, List<Integer> assignments, int[][] intervals) {
        for (int index : assignments) {
            if (hasOverlap(interval, intervals[index])) return true;
        }
        return false;
    }

    private boolean hasOverlap(int[] interval1, int[] interval2) {
        if (interval2[0] < interval1[0]) return hasOverlap(interval2, interval1);
        return interval1[1] > interval2[0];
    }
}