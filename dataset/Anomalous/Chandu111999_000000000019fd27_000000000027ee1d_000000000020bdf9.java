import java.util.*;

public class Solution {
    private static Scanner sc;
    static int tn = 1;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int g = sc.nextInt();
        sc.nextLine();

        while (g-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int p = sc.nextInt();
        int[][] intervals = new int[p][2];
        int[][] sortedIntervals = new int[p][2];
        char[] result = new char[p];
        Stack<int[]> JStack = new Stack<>();
        Stack<int[]> CStack = new Stack<>();
        boolean impossible = false;

        Map<int[], Integer> indexMap = new HashMap<>();

        for (int i = 0; i < p; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
            sortedIntervals[i] = intervals[i].clone();
            indexMap.put(intervals[i], i);
        }

        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

        char currentPerson = 'J';

        for (int i = 0; i < sortedIntervals.length; i++) {
            int originalIndex = indexMap.get(sortedIntervals[i]);
            result[originalIndex] = currentPerson;

            if (i < sortedIntervals.length - 1 && doesOverlap(sortedIntervals[i], sortedIntervals[i + 1])) {
                if (currentPerson == 'J') {
                    JStack.push(sortedIntervals[i]);
                    currentPerson = 'C';
                    if (!CStack.isEmpty() && doesOverlap(CStack.peek(), sortedIntervals[i + 1])) {
                        impossible = true;
                        break;
                    }
                } else {
                    CStack.push(sortedIntervals[i]);
                    currentPerson = 'J';
                    if (!JStack.isEmpty() && doesOverlap(JStack.peek(), sortedIntervals[i + 1])) {
                        impossible = true;
                        break;
                    }
                }
            } else {
                if (currentPerson == 'J') {
                    JStack.push(sortedIntervals[i]);
                } else {
                    CStack.push(sortedIntervals[i]);
                }
            }
        }

        System.out.println("Case #" + (tn++) + ": " + (impossible ? "IMPOSSIBLE" : new String(result)));
    }

    private static boolean doesOverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }
}