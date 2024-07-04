import java.util.*;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    static int testCaseNumber = 0;

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        int[][] sortedIntervals = new int[n][2];
        Map<int[], Integer> indexMap = new HashMap<>();
        char[] schedule = new char[n];
        char currentPerson = 'J';

        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
            sortedIntervals[i] = intervals[i];
            indexMap.put(intervals[i], i);
        }

        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

        boolean isImpossible = false;
        for (int i = 0; i < n - 1; i++) {
            if (sortedIntervals[i][1] > sortedIntervals[i + 1][0]) {
                isImpossible = true;
                break;
            }
        }

        if (isImpossible) {
            System.out.println("Case #" + (++testCaseNumber) + ": IMPOSSIBLE");
        } else {
            for (int i = 0; i < n; i++) {
                schedule[indexMap.get(sortedIntervals[i])] = currentPerson;
                if (i < n - 1 && overlaps(sortedIntervals[i], sortedIntervals[i + 1])) {
                    currentPerson = togglePerson(currentPerson);
                }
            }
            System.out.println("Case #" + (++testCaseNumber) + ": " + new String(schedule));
        }
    }

    private static char togglePerson(char person) {
        return person == 'J' ? 'C' : 'J';
    }

    private static boolean overlaps(int[] a, int[] b) {
        return a[1] > b[0];
    }
}