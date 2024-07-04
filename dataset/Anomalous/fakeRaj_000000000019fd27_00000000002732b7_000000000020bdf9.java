import java.util.*;

public class Solution {
    private static Scanner sc = new Scanner(System.in);
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        int testCases = sc.nextInt();
        sc.nextLine();

        while (testCases-- > 0) {
            processTestCase();
        }
    }

    private static void processTestCase() {
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        int[][] sortedIntervals = new int[n][2];
        char[] result = new char[n];
        Stack<int[]> jStack = new Stack<>();
        Stack<int[]> cStack = new Stack<>();
        boolean isImpossible = false;
        Map<int[], Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
            sortedIntervals[i] = intervals[i];
            indexMap.put(intervals[i], i);
        }

        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

        char currentPerson = 'J';
        for (int i = 0; i < n; i++) {
            int[] interval = sortedIntervals[i];
            result[indexMap.get(interval)] = currentPerson;

            if (i < n - 1 && intervalsOverlap(interval, sortedIntervals[i + 1])) {
                if (currentPerson == 'J') {
                    jStack.push(interval);
                    currentPerson = switchPerson(currentPerson);

                    if (!cStack.isEmpty() && intervalsOverlap(cStack.peek(), sortedIntervals[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                } else {
                    cStack.push(interval);
                    currentPerson = switchPerson(currentPerson);

                    if (!jStack.isEmpty() && intervalsOverlap(jStack.peek(), sortedIntervals[i + 1])) {
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

    private static boolean intervalsOverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }
}