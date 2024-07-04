import java.util.*;

public class Solution {
    private static int testCaseNumber = 1;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            processTestCase();
        }
    }

    private static void processTestCase() {
        int n = scanner.nextInt();
        int[][] intervals = new int[n][2];
        Map<int[], Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
            indexMap.put(intervals[i], i);
        }

        int[][] sortedIntervals = intervals.clone();
        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

        char[] assignments = new char[n];
        Stack<int[]> jStack = new Stack<>();
        Stack<int[]> cStack = new Stack<>();
        boolean isImpossible = false;
        char currentPerson = 'J';

        for (int i = 0; i < sortedIntervals.length; i++) {
            assignments[indexMap.get(sortedIntervals[i])] = currentPerson;

            if (i < sortedIntervals.length - 1 && overlaps(sortedIntervals[i], sortedIntervals[i + 1])) {
                if (currentPerson == 'J') {
                    jStack.push(sortedIntervals[i]);
                    currentPerson = switchPerson(currentPerson);

                    if (!cStack.isEmpty() && overlaps(cStack.peek(), sortedIntervals[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                } else {
                    cStack.push(sortedIntervals[i]);
                    currentPerson = switchPerson(currentPerson);

                    if (!jStack.isEmpty() && overlaps(jStack.peek(), sortedIntervals[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                }
            } else {
                if (currentPerson == 'J') {
                    jStack.push(sortedIntervals[i]);
                } else {
                    cStack.push(sortedIntervals[i]);
                }
            }
        }

        System.out.println("Case #" + testCaseNumber++ + ": " + (isImpossible ? "IMPOSSIBLE" : new String(assignments)));
    }

    private static char switchPerson(char person) {
        return person == 'J' ? 'C' : 'J';
    }

    private static boolean overlaps(int[] a, int[] b) {
        return a[1] > b[0];
    }
}