import java.util.*;

public class Solution {

    private static Map<Integer, Integer> c = new HashMap<>();
    private static Map<Integer, Integer> j = new HashMap<>();
    private static Map<Integer, Integer> se = new HashMap<>();
    private static Map<Integer, Integer> index = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int test = 0; test < testCases; test++) {
            int n = sc.nextInt();
            se = new HashMap<>();
            index = new HashMap<>();
            int[] start = new int[n];

            for (int i = 0; i < n; i++) {
                start[i] = sc.nextInt();
                se.put(start[i], sc.nextInt());
                index.put(start[i], i);
            }

            Arrays.sort(start);
            System.out.print("Case #" + (test + 1) + ": ");
            boolean[] ans = assignTasks(start);

            if (ans[ans.length - 1]) {
                System.out.println("IMPOSSIBLE");
            } else {
                StringBuilder solution = new StringBuilder();
                for (int x = 0; x < ans.length - 1; x++) {
                    solution.append(ans[x] ? "J" : "C");
                }
                System.out.println(solution.toString());
            }
        }
    }

    private static boolean[] assignTasks(int[] start) {
        boolean[] ans = new boolean[start.length + 1];

        for (int i = 0; i < start.length; i++) {
            int currentStart = start[i];
            int currentEnd = se.get(currentStart);

            if (canAssignToC(currentStart, currentEnd)) {
                ans[index.get(currentStart)] = false;
            } else if (canAssignToJ(currentStart, currentEnd)) {
                ans[index.get(currentStart)] = true;
            } else {
                resetMaps();
                ans[ans.length - 1] = true;
                return ans;
            }
        }

        resetMaps();
        return ans;
    }

    private static boolean canAssignToC(int start, int end) {
        for (Map.Entry<Integer, Integer> entry : c.entrySet()) {
            int existingStart = entry.getKey();
            int existingEnd = entry.getValue();

            if ((start < existingStart && end > existingStart) ||
                (start >= existingStart && start < existingEnd)) {
                return false;
            }
        }
        c.put(start, end);
        return true;
    }

    private static boolean canAssignToJ(int start, int end) {
        for (Map.Entry<Integer, Integer> entry : j.entrySet()) {
            int existingStart = entry.getKey();
            int existingEnd = entry.getValue();

            if ((start < existingStart && end > existingStart) ||
                (start >= existingStart && start < existingEnd)) {
                return false;
            }
        }
        j.put(start, end);
        return true;
    }

    private static void resetMaps() {
        c = new HashMap<>();
        j = new HashMap<>();
    }
}