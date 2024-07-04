import java.util.*;

public class Solution {
    private static Scanner sc;
    private static int tn = 1;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        int[][] sortedIntervals = new int[n][2];
        char[] result = new char[n];
        Stack<int[]> stackJ = new Stack<>();
        Stack<int[]> stackC = new Stack<>();
        boolean isImpossible = false;

        Map<int[], Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
            sortedIntervals[i] = intervals[i].clone();
            indexMap.put(intervals[i], i);
        }

        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

        char currentPerson = 'J';

        for (int i = 0; i < n; i++) {
            int originalIndex = indexMap.get(sortedIntervals[i]);
            result[originalIndex] = currentPerson;

            if (i < n - 1 && doesOverlap(sortedIntervals[i], sortedIntervals[i + 1])) {
                if (currentPerson == 'J') {
                    stackJ.push(sortedIntervals[i]);
                    currentPerson = switchPerson(currentPerson);

                    if (!stackC.isEmpty() && doesOverlap(stackC.peek(), sortedIntervals[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                } else {
                    stackC.push(sortedIntervals[i]);
                    currentPerson = switchPerson(currentPerson);

                    if (!stackJ.isEmpty() && doesOverlap(stackJ.peek(), sortedIntervals[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                }
            } else {
                if (currentPerson == 'J') {
                    stackJ.push(sortedIntervals[i]);
                } else {
                    stackC.push(sortedIntervals[i]);
                }
            }
        }

        System.out.println("Case #" + (tn++) + ": " + (isImpossible ? "IMPOSSIBLE" : new String(result)));
    }

    private static char switchPerson(char person) {
        return person == 'J' ? 'C' : 'J';
    }

    private static boolean doesOverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }
}