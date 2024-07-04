import java.util.*;

public class Solution {
    private static Scanner sc;
    private static int t = 1;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();
        while (testCases-- > 0) {
            solveTestCase();
        }
    }

    private static void solveTestCase() {
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

        Stack<int[]> cStack = new Stack<>();
        Stack<int[]> jStack = new Stack<>();
        boolean impossible = false;
        char currentPerson = 'J';

        for (int i = 0; i < n; i++) {
            int[] interval = sortedIntervals[i];
            result[indexMap.get(interval)] = currentPerson;

            if (currentPerson == 'J') {
                jStack.push(interval);
                currentPerson = togglePerson(currentPerson);
                if (!cStack.isEmpty() && doesOverlap(cStack.peek(), sortedIntervals[i + 1])) {
                    impossible = true;
                    break;
                }
            } else {
                cStack.push(interval);
                currentPerson = togglePerson(currentPerson);
                if (!jStack.isEmpty() && doesOverlap(jStack.peek(), sortedIntervals[i + 1])) {
                    impossible = true;
                    break;
                }
            }
        }

        System.out.println("Case #" + (t++) + ": " + (impossible ? "IMPOSSIBLE" : new String(result)));
    }

    private static char togglePerson(char person) {
        return person == 'J' ? 'C' : 'J';
    }

    private static boolean doesOverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }
}