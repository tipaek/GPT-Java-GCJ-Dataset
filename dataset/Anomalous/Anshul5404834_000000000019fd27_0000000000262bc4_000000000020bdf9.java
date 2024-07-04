import java.util.*;

public class Solution {
    private static Map<Integer, Integer> endTimes;
    private static Map<Integer, Integer> indices;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int test = 1; test <= testCases; test++) {
            int n = scanner.nextInt();
            endTimes = new HashMap<>();
            indices = new HashMap<>();
            int[] startTimes = new int[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                startTimes[i] = start;
                endTimes.put(start, end);
                indices.put(start, i);
            }

            Arrays.sort(startTimes);
            System.out.print("Case #" + test + ": ");
            int[] assignments = assignTasks(startTimes);

            if (assignments == null) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (int assignment : assignments) {
                    System.out.print(assignment == 0 ? "C" : "J");
                }
                System.out.println();
            }
        }
    }

    private static int[] assignTasks(int[] startTimes) {
        int[] assignments = new int[startTimes.length];
        int endC = 0;
        int endJ = 0;

        for (int start : startTimes) {
            int end = endTimes.get(start);
            int index = indices.get(start);

            if (start >= endC) {
                endC = end;
                assignments[index] = 0;
            } else if (start >= endJ) {
                endJ = end;
                assignments[index] = 1;
            } else {
                return null;
            }
        }

        return assignments;
    }
}