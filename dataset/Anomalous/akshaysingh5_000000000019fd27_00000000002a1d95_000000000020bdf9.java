import java.util.*;

public class Solution {
    private static Scanner sc = new Scanner(System.in);
    private static int tn = 1;

    public static void main(String[] args) {
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        char[] result = new char[n];
        Stack<int[]> jStack = new Stack<>();
        Stack<int[]> cStack = new Stack<>();
        Map<int[], Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
            indexMap.put(intervals[i], i);
        }

        int[][] sortedIntervals = intervals.clone();
        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

        boolean impossible = false;
        char currentPerson = 'J';

        for (int i = 0; i < sortedIntervals.length; i++) {
            result[indexMap.get(sortedIntervals[i])] = currentPerson;

            if (i < sortedIntervals.length - 1 && doesOverlap(sortedIntervals[i], sortedIntervals[i + 1])) {
                if (currentPerson == 'J') {
                    jStack.push(sortedIntervals[i]);
                    currentPerson = 'C';

                    if (!cStack.isEmpty() && doesOverlap(cStack.peek(), sortedIntervals[i + 1])) {
                        impossible = true;
                        break;
                    }
                } else {
                    cStack.push(sortedIntervals[i]);
                    currentPerson = 'J';

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

        System.out.println("Case #" + (tn++) + ": " + (impossible ? "IMPOSSIBLE" : new String(result)));
    }

    private static boolean doesOverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }
}