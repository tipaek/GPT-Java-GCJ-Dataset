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
        int[][] sortedIntervals = intervals.clone();
        char currentPerson = 'J';
        char[] result = new char[n];
        Stack<int[]> jStack = new Stack<>();
        Stack<int[]> cStack = new Stack<>();
        boolean isImpossible = false;
        Map<int[], Integer> indexMap = new HashMap<>();

        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals[i].length; j++) {
                intervals[i][j] = scanner.nextInt();
            }
            indexMap.put(intervals[i], i);
        }

        Arrays.sort(sortedIntervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        for (int i = 0; i < sortedIntervals.length; i++) {
            result[indexMap.get(sortedIntervals[i])] = currentPerson;
            if (i < sortedIntervals.length - 1 && isOverlap(sortedIntervals[i], sortedIntervals[i + 1])) {
                if (currentPerson == 'J') {
                    jStack.push(sortedIntervals[i]);
                    currentPerson = switchPerson(currentPerson);
                    if (!cStack.isEmpty() && isOverlap(cStack.peek(), sortedIntervals[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                } else {
                    cStack.push(sortedIntervals[i]);
                    currentPerson = switchPerson(currentPerson);
                    if (!jStack.isEmpty() && isOverlap(jStack.peek(), sortedIntervals[i + 1])) {
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

        System.out.println("Case #" + (testCaseNumber++) + ": " + (isImpossible ? "IMPOSSIBLE" : new String(result)));
    }

    private static char switchPerson(char currentPerson) {
        return currentPerson == 'J' ? 'C' : 'J';
    }

    private static boolean isOverlap(int[] interval1, int[] interval2) {
        return interval1[1] > interval2[0];
    }
}