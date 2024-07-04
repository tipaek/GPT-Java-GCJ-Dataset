import java.util.*;

public class Solution {
    private static Scanner scanner;
    static int testCaseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        while (testCases-- > 0) {
            solve();
        }
    }

    public static void solve() {
        int n = scanner.nextInt();
        int[][] intervals = new int[n][2];
        int[][] sortedIntervals = new int[n][2];
        char[] assignedPersons = new char[n];
        Stack<int[]> stackJ = new Stack<>();
        Stack<int[]> stackC = new Stack<>();
        boolean isImpossible = false;
        Map<int[], Integer> intervalToIndexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
            sortedIntervals[i] = intervals[i];
            intervalToIndexMap.put(intervals[i], i);
        }

        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

        char currentPerson = 'J';

        for (int i = 0; i < sortedIntervals.length; i++) {
            assignedPersons[intervalToIndexMap.get(sortedIntervals[i])] = currentPerson;

            if (i < sortedIntervals.length - 1 && doesOverlap(sortedIntervals[i], sortedIntervals[i + 1])) {
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

        System.out.println("Case #" + (testCaseNumber++) + ": " + (isImpossible ? "IMPOSSIBLE" : new String(assignedPersons)));
    }

    private static char switchPerson(char person) {
        return person == 'J' ? 'C' : 'J';
    }

    private static boolean doesOverlap(int[] interval1, int[] interval2) {
        return interval1[1] > interval2[0];
    }
}