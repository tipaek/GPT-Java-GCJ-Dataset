import java.util.*;

public class Solution {
    private static Scanner scanner;
    static int caseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < testCases; i++) {
            processTestCase();
        }
    }

    public static void processTestCase() {
        int n = scanner.nextInt();
        int[][] intervals = new int[n][2];
        int[][] sortedIntervals = new int[n][2];
        char[] assignments = new char[n];
        boolean isImpossible = false;
        Map<int[], Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
            sortedIntervals[i] = intervals[i].clone();
            indexMap.put(intervals[i], i);
        }

        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

        Stack<int[]> jStack = new Stack<>();
        Stack<int[]> cStack = new Stack<>();
        char currentPerson = 'J';

        for (int i = 0; i < n; i++) {
            int[] interval = sortedIntervals[i];
            assignments[indexMap.get(interval)] = currentPerson;

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

        System.out.println("Case #" + (caseNumber++) + ": " + (isImpossible ? "IMPOSSIBLE" : new String(assignments)));
    }

    private static char switchPerson(char person) {
        return person == 'J' ? 'C' : 'J';
    }

    private static boolean intervalsOverlap(int[] interval1, int[] interval2) {
        return interval1[1] > interval2[0];
    }
}