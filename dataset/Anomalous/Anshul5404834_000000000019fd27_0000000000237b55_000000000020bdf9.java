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
            se.clear();
            index.clear();
            int[] startTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = sc.nextInt();
                se.put(startTimes[i], sc.nextInt());
                index.put(startTimes[i], i);
            }

            Arrays.sort(startTimes);
            System.out.print("Case #" + (test + 1) + ": ");
            boolean[] assignments = assignTasks(startTimes);
            printResult(assignments);
        }
    }

    private static boolean[] assignTasks(int[] startTimes) {
        boolean[] assignments = new boolean[startTimes.length + 1];

        for (int i = 0; i < startTimes.length; i++) {
            int start = startTimes[i];
            int end = se.get(start);

            if (canAssignToC(start, end)) {
                assignments[index.get(start)] = false;
            } else if (canAssignToJ(start, end)) {
                assignments[index.get(start)] = true;
            } else {
                resetMaps();
                assignments[assignments.length - 1] = true;
                return assignments;
            }
        }

        resetMaps();
        return assignments;
    }

    private static boolean canAssignToC(int start, int end) {
        for (Map.Entry<Integer, Integer> entry : c.entrySet()) {
            int cStart = entry.getKey();
            int cEnd = entry.getValue();

            if ((start < cStart && end > cStart) || (start >= cStart && start < cEnd)) {
                return false;
            }
        }
        c.put(start, end);
        return true;
    }

    private static boolean canAssignToJ(int start, int end) {
        for (Map.Entry<Integer, Integer> entry : j.entrySet()) {
            int jStart = entry.getKey();
            int jEnd = entry.getValue();

            if ((start < jStart && end > jStart) || (start >= jStart && start < jEnd)) {
                return false;
            }
        }
        j.put(start, end);
        return true;
    }

    private static void resetMaps() {
        c.clear();
        j.clear();
    }

    private static void printResult(boolean[] assignments) {
        if (assignments[assignments.length - 1]) {
            System.out.println("IMPOSSIBLE");
        } else {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < assignments.length - 1; i++) {
                result.append(assignments[i] ? 'J' : 'C');
            }
            System.out.println(result);
        }
    }
}