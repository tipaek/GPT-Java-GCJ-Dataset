import java.util.*;

public class Solution {
    private static final Scanner scan = new Scanner(System.in);
    private static int testCaseNumber;

    public static void main(String[] args) {
        int t = scan.nextInt();
        while (t-- > 0) {
            processTestCase();
        }
    }

    private static void processTestCase() {
        int n = scan.nextInt();
        int[][] intervals = new int[n][2];
        int[][] sortedIntervals = new int[n][2];
        char[] assignments = new char[n];
        Map<int[], Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            intervals[i][0] = scan.nextInt();
            intervals[i][1] = scan.nextInt();
            sortedIntervals[i] = intervals[i].clone();
            indexMap.put(intervals[i], i);
        }

        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

        Stack<int[]> jStack = new Stack<>();
        Stack<int[]> cStack = new Stack<>();
        boolean isImpossible = false;
        char currentPerson = 'J';

        for (int i = 0; i < n; i++) {
            int[] currentInterval = sortedIntervals[i];
            assignments[indexMap.get(currentInterval)] = currentPerson;

            if (i < n - 1 && doesOverlap(currentInterval, sortedIntervals[i + 1])) {
                if (currentPerson == 'J') {
                    jStack.push(currentInterval);
                    currentPerson = 'C';
                    if (!cStack.isEmpty() && doesOverlap(cStack.peek(), sortedIntervals[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                } else {
                    cStack.push(currentInterval);
                    currentPerson = 'J';
                    if (!jStack.isEmpty() && doesOverlap(jStack.peek(), sortedIntervals[i + 1])) {
                        isImpossible = true;
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

        System.out.println("Case #" + ++testCaseNumber + ": " + (isImpossible ? "IMPOSSIBLE" : new String(assignments)));
    }

    private static boolean doesOverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }
}