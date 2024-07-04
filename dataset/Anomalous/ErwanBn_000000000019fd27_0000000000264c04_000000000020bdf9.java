import java.util.*;

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
        Map<int[], Integer> indexMap = new HashMap<>();
        char[] assignments = new char[n];
        boolean impossible = false;

        for (int i = 0; i < n; i++) {
            intervals[i][0] = scan.nextInt();
            intervals[i][1] = scan.nextInt();
            indexMap.put(intervals[i], i);
        }

        int[][] sortedIntervals = intervals.clone();
        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

        Stack<int[]> jStack = new Stack<>();
        Stack<int[]> cStack = new Stack<>();
        char currentPerson = 'J';

        for (int i = 0; i < sortedIntervals.length; i++) {
            assignments[indexMap.get(sortedIntervals[i])] = currentPerson;

            if (i < sortedIntervals.length - 1 && doesOverlap(sortedIntervals[i], sortedIntervals[i + 1])) {
                if (currentPerson == 'J') {
                    jStack.push(sortedIntervals[i]);
                    currentPerson = getNextPerson(currentPerson);

                    if (!cStack.isEmpty() && doesOverlap(cStack.peek(), sortedIntervals[i + 1])) {
                        impossible = true;
                        break;
                    }
                } else {
                    cStack.push(sortedIntervals[i]);
                    currentPerson = getNextPerson(currentPerson);

                    if (!jStack.isEmpty() && doesOverlap(jStack.peek(), sortedIntervals[i + 1])) {
                        impossible = true;
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

        return impossible ? "IMPOSSIBLE" : new String(assignments);
    }

    private static char getNextPerson(char currentPerson) {
        return currentPerson == 'J' ? 'C' : 'J';
    }

    public static boolean doesOverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }
}