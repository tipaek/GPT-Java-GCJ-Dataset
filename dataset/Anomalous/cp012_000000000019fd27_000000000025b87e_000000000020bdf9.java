import java.util.*;

public class Solution {
    private static Scanner sc;
    static int testCaseNumber = 1;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            solve();
        }
    }

    static boolean doesOverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }

    static char switchPerson(char p) {
        return p == 'J' ? 'C' : 'J';
    }

    static void solve() {
        int n = sc.nextInt();
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
                intervals[i][j] = sc.nextInt();
            }
            indexMap.put(intervals[i], i);
        }

        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < sortedIntervals.length; i++) {
            result[indexMap.get(sortedIntervals[i])] = currentPerson;

            if (i < sortedIntervals.length - 1 && doesOverlap(sortedIntervals[i], sortedIntervals[i + 1])) {
                if (currentPerson == 'J') {
                    jStack.push(sortedIntervals[i]);
                    currentPerson = switchPerson(currentPerson);

                    if (!cStack.isEmpty() && doesOverlap(cStack.peek(), sortedIntervals[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                } else {
                    cStack.push(sortedIntervals[i]);
                    currentPerson = switchPerson(currentPerson);

                    if (!jStack.isEmpty() && doesOverlap(jStack.peek(), sortedIntervals[i + 1])) {
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
}