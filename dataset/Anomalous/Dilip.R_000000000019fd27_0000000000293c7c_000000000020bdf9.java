import java.util.*;

public class Solution {
    private static Scanner scanner;
    static int testCaseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        while (testCases-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[][] intervals = new int[n][2];
        int[][] sortedIntervals = new int[n][2];
        Map<int[], Integer> indexMap = new HashMap<>();
        char[] result = new char[n];
        boolean isImpossible = false;
        Stack<int[]> jStack = new Stack<>();
        Stack<int[]> cStack = new Stack<>();
        char currentPerson = 'J';

        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
            sortedIntervals[i] = intervals[i];
            indexMap.put(intervals[i], i);
        }

        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < n; i++) {
            int[] interval = sortedIntervals[i];
            result[indexMap.get(interval)] = currentPerson;

            if (i < n - 1 && doesOverlap(interval, sortedIntervals[i + 1])) {
                if (currentPerson == 'J') {
                    jStack.push(interval);
                    currentPerson = switchPerson(currentPerson);

                    if (!cStack.isEmpty() && doesOverlap(cStack.peek(), sortedIntervals[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                } else {
                    cStack.push(interval);
                    currentPerson = switchPerson(currentPerson);

                    if (!jStack.isEmpty() && doesOverlap(jStack.peek(), sortedIntervals[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                }
            } else {
                if (currentPerson == 'J') {
                    jStack.push(interval);
                } else {
                    cStack.push(interval);
                }
            }
        }

        System.out.println("Case #" + (testCaseNumber++) + ": " + (isImpossible ? "IMPOSSIBLE" : new String(result)));
    }

    private static char switchPerson(char person) {
        return person == 'J' ? 'C' : 'J';
    }

    private static boolean doesOverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }
}