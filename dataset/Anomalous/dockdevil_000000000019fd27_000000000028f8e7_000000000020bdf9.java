import java.util.*;

public class Solution {
    private static Scanner sc = new Scanner(System.in);
    private static int caseNumber = 1;

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
        char[] result = new char[n];
        Map<int[], Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
            indexMap.put(intervals[i], i);
        }

        int[][] sortedIntervals = intervals.clone();
        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

        Stack<int[]> JStack = new Stack<>();
        Stack<int[]> CStack = new Stack<>();
        boolean impossible = false;
        char currentPerson = 'J';

        for (int i = 0; i < sortedIntervals.length; i++) {
            int[] currentInterval = sortedIntervals[i];
            result[indexMap.get(currentInterval)] = currentPerson;

            if (i < sortedIntervals.length - 1 && isOverlapping(currentInterval, sortedIntervals[i + 1])) {
                if (currentPerson == 'J') {
                    JStack.push(currentInterval);
                    currentPerson = switchPerson(currentPerson);
                    if (!CStack.isEmpty() && isOverlapping(CStack.peek(), sortedIntervals[i + 1])) {
                        impossible = true;
                        break;
                    }
                } else {
                    CStack.push(currentInterval);
                    currentPerson = switchPerson(currentPerson);
                    if (!JStack.isEmpty() && isOverlapping(JStack.peek(), sortedIntervals[i + 1])) {
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

        System.out.println("Case #" + (caseNumber++) + ": " + (impossible ? "IMPOSSIBLE" : new String(result)));
    }

    private static char switchPerson(char current) {
        return current == 'J' ? 'C' : 'J';
    }

    private static boolean isOverlapping(int[] interval1, int[] interval2) {
        return interval1[1] > interval2[0];
    }
}