import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt(); // Number of test cases

        for (int k = 1; k <= t; k++) {
            int activities = scanner.nextInt();

            List<int[]> slots = new ArrayList<>();
            for (int i = 0; i < activities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                slots.add(new int[]{start, end});
            }

            StringBuilder outputStr = new StringBuilder();
            List<int[]> C = new ArrayList<>();
            List<int[]> J = new ArrayList<>();

            boolean possible = true;

            for (int i = 0; i < activities && possible; i++) {
                int[] current = slots.get(i);
                int currentStart = current[0];
                int currentEnd = current[1];
                boolean assigned = false;

                if (C.isEmpty() || canAssign(C, currentStart, currentEnd)) {
                    C.add(current);
                    outputStr.append("C");
                    assigned = true;
                } else if (J.isEmpty() || canAssign(J, currentStart, currentEnd)) {
                    J.add(current);
                    outputStr.append("J");
                    assigned = true;
                }

                if (!assigned) {
                    outputStr = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                }
            }

            System.out.println("Case #" + k + ": " + outputStr);
        }
    }

    private static boolean canAssign(List<int[]> list, int start, int end) {
        for (int[] slot : list) {
            if (!(end <= slot[0] || start >= slot[1])) {
                return false;
            }
        }
        return true;
    }
}