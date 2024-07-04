import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            HashMap<String, ArrayList<Integer>> scheduleMap = new HashMap<>();
            scheduleMap.put("J", new ArrayList<>());
            scheduleMap.put("C", new ArrayList<>());

            boolean possible = true;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];

                if (canAssign(scheduleMap.get("J"), intervals, start, end)) {
                    scheduleMap.get("J").add(i);
                    result.append("J");
                } else if (canAssign(scheduleMap.get("C"), intervals, start, end)) {
                    scheduleMap.get("C").add(i);
                    result.append("C");
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                char[] output = new char[n];
                Arrays.fill(output, ' ');
                for (int i : scheduleMap.get("J")) {
                    output[i] = 'J';
                }
                for (int i : scheduleMap.get("C")) {
                    output[i] = 'C';
                }
                System.out.println("Case #" + testCase + ": " + new String(output));
            }
        }
    }

    private static boolean canAssign(ArrayList<Integer> assigned, int[][] intervals, int start, int end) {
        for (int index : assigned) {
            if (start < intervals[index][1] && end > intervals[index][0]) {
                return false;
            }
        }
        return true;
    }
}