import java.util.*;

public class Solution {
    private static int caseNumber = 0;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[][] intervals = new int[n][2];
        int[][] sortedIntervals = new int[n][2];
        char[] assignedPersons = new char[n];
        Stack<int[]> jStack = new Stack<>();
        Stack<int[]> cStack = new Stack<>();
        boolean isImpossible = false;

        Map<int[], Integer> intervalIndexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
            sortedIntervals[i] = intervals[i];
            intervalIndexMap.put(intervals[i], i);
        }

        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

        char currentPerson = 'J';

        for (int i = 0; i < n; i++) {
            int[] currentInterval = sortedIntervals[i];
            assignedPersons[intervalIndexMap.get(currentInterval)] = currentPerson;

            if (i < n - 1 && overlaps(currentInterval, sortedIntervals[i + 1])) {
                if (currentPerson == 'J') {
                    jStack.push(currentInterval);
                    currentPerson = switchPerson(currentPerson);

                    if (!cStack.isEmpty() && overlaps(cStack.peek(), sortedIntervals[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                } else {
                    cStack.push(currentInterval);
                    currentPerson = switchPerson(currentPerson);

                    if (!jStack.isEmpty() && overlaps(jStack.peek(), sortedIntervals[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                }
            } else {
                if (currentPerson == 'J') {
                    jStack.push(currentInterval);
                } else {
                    cStack.push(currentInterval);
                }
            }
        }

        System.out.println("Case #" + ++caseNumber + ": " + (isImpossible ? "IMPOSSIBLE" : new String(assignedPersons)));
    }

    private static char switchPerson(char person) {
        return person == 'J' ? 'C' : 'J';
    }

    private static boolean overlaps(int[] interval1, int[] interval2) {
        return interval1[1] > interval2[0];
    }
}