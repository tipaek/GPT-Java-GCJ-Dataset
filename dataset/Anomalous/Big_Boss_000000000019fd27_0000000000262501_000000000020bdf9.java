import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        int n = scan.nextInt();
        scan.nextLine(); // Consume the newline

        for (int i = 0; i < n; i++) {
            String result = solveTest();
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    public static String solveTest() {
        int n = scan.nextInt();
        int[][] intervals = new int[n][2];
        int[][] sortedIntervals = new int[n][2];
        Map<int[], Integer> indexMap = new HashMap<>();
        char[] assignments = new char[n];
        boolean impossible = false;

        // Read input intervals and store their original indices
        for (int i = 0; i < n; i++) {
            intervals[i][0] = scan.nextInt();
            intervals[i][1] = scan.nextInt();
            sortedIntervals[i] = intervals[i];
            indexMap.put(intervals[i], i);
        }

        // Sort intervals by their start time
        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

        Stack<int[]> jStack = new Stack<>();
        Stack<int[]> cStack = new Stack<>();
        char currentPerson = 'J';

        // Assign intervals to 'J' or 'C'
        for (int i = 0; i < n; i++) {
            int[] currentInterval = sortedIntervals[i];
            assignments[indexMap.get(currentInterval)] = currentPerson;

            if (i < n - 1 && doesOverlap(currentInterval, sortedIntervals[i + 1])) {
                if (currentPerson == 'J') {
                    jStack.push(currentInterval);
                    currentPerson = 'C';
                    if (!cStack.isEmpty() && doesOverlap(cStack.peek(), sortedIntervals[i + 1])) {
                        impossible = true;
                        break;
                    }
                } else {
                    cStack.push(currentInterval);
                    currentPerson = 'J';
                    if (!jStack.isEmpty() && doesOverlap(jStack.peek(), sortedIntervals[i + 1])) {
                        impossible = true;
                        break;
                    }
                }
            } else {
                if (currentPerson == 'J') {
                    jStack.push(currentInterval);
                } else {
                    cStack.push(currentInterval);
                }
            }
        }

        return impossible ? "IMPOSSIBLE" : new String(assignments);
    }

    public static boolean doesOverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }
}