import java.util.*;

public class Solution {
    private static Scanner scanner;
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        while (testCases-- > 0) {
            solveTestCase();
        }
    }

    private static void solveTestCase() {
        int n = scanner.nextInt();
        int[][] intervals = new int[n][2];
        int[][] sortedIntervals = new int[n][2];
        char[] assignment = new char[n];
        boolean isImpossible = false;

        Map<int[], Integer> intervalIndexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
            sortedIntervals[i] = intervals[i].clone();
            intervalIndexMap.put(intervals[i], i);
        }

        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

        Stack<int[]> jStack = new Stack<>();
        Stack<int[]> cStack = new Stack<>();
        char currentPerson = 'J';

        for (int i = 0; i < sortedIntervals.length; i++) {
            int originalIndex = intervalIndexMap.get(sortedIntervals[i]);
            assignment[originalIndex] = currentPerson;

            if (i < sortedIntervals.length - 1 && intervalsOverlap(sortedIntervals[i], sortedIntervals[i + 1])) {
                if (currentPerson == 'J') {
                    jStack.push(sortedIntervals[i]);
                    currentPerson = switchPerson(currentPerson);
                    if (!cStack.isEmpty() && intervalsOverlap(cStack.peek(), sortedIntervals[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                } else {
                    cStack.push(sortedIntervals[i]);
                    currentPerson = switchPerson(currentPerson);
                    if (!jStack.isEmpty() && intervalsOverlap(jStack.peek(), sortedIntervals[i + 1])) {
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

        System.out.println("Case #" + (testCaseNumber++) + ": " + (isImpossible ? "IMPOSSIBLE" : new String(assignment)));
    }

    private static char switchPerson(char person) {
        return person == 'J' ? 'C' : 'J';
    }

    private static boolean intervalsOverlap(int[] interval1, int[] interval2) {
        return interval1[1] > interval2[0];
    }
}