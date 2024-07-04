import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    private static Scanner scanner;
    private static int caseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        while (testCases-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[][] intervals = new int[n][2];
        char[] assignedPersons = new char[n];
        Stack<int[]> jStack = new Stack<>();
        Stack<int[]> cStack = new Stack<>();
        Map<int[], Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
            indexMap.put(intervals[i], i);
        }

        int[][] sortedIntervals = intervals.clone();
        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

        boolean isImpossible = false;
        char currentPerson = 'J';

        for (int i = 0; i < sortedIntervals.length; i++) {
            assignedPersons[indexMap.get(sortedIntervals[i])] = currentPerson;

            if (i < sortedIntervals.length - 1 && overlaps(sortedIntervals[i], sortedIntervals[i + 1])) {
                if (currentPerson == 'J') {
                    jStack.push(sortedIntervals[i]);
                    currentPerson = switchPerson(currentPerson);

                    if (!cStack.isEmpty() && overlaps(cStack.peek(), sortedIntervals[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                } else {
                    cStack.push(sortedIntervals[i]);
                    currentPerson = switchPerson(currentPerson);

                    if (!jStack.isEmpty() && overlaps(jStack.peek(), sortedIntervals[i + 1])) {
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

        System.out.println("Case #" + (caseNumber++) + ": " + (isImpossible ? "IMPOSSIBLE" : new String(assignedPersons)));
    }

    private static char switchPerson(char currentPerson) {
        return currentPerson == 'J' ? 'C' : 'J';
    }

    private static boolean overlaps(int[] interval1, int[] interval2) {
        return interval1[1] > interval2[0];
    }
}