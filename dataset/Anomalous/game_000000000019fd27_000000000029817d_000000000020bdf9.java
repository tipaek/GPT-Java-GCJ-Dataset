import java.util.*;

public class Solution {
    private static Scanner sc = new Scanner(System.in);
    private static int tn = 1;

    public static void main(String[] args) {
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline

        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        int[][] sortedIntervals = new int[n][2];
        char[] result = new char[n];
        Map<int[], Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
            sortedIntervals[i] = intervals[i];
            indexMap.put(intervals[i], i);
        }

        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

        Stack<int[]> JStack = new Stack<>();
        Stack<int[]> CStack = new Stack<>();
        boolean impossible = false;
        char currentPerson = 'J';

        for (int i = 0; i < n; i++) {
            int[] currentInterval = sortedIntervals[i];
            result[indexMap.get(currentInterval)] = currentPerson;

            if (i < n - 1 && doesOverlap(currentInterval, sortedIntervals[i + 1])) {
                if (currentPerson == 'J') {
                    JStack.push(currentInterval);
                    currentPerson = 'C';
                    if (!CStack.isEmpty() && doesOverlap(CStack.peek(), sortedIntervals[i + 1])) {
                        impossible = true;
                        break;
                    }
                } else {
                    CStack.push(currentInterval);
                    currentPerson = 'J';
                    if (!JStack.isEmpty() && doesOverlap(JStack.peek(), sortedIntervals[i + 1])) {
                        impossible = true;
                        break;
                    }
                }
            } else {
                if (currentPerson == 'J') {
                    JStack.push(currentInterval);
                } else {
                    CStack.push(currentInterval);
                }
            }
        }

        System.out.println("Case #" + (tn++) + ": " + (impossible ? "IMPOSSIBLE" : new String(result)));
    }

    private static boolean doesOverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }
}