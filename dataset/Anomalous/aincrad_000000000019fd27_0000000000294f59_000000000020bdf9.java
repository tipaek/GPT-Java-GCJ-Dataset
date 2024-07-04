import java.util.*;

public class Solution {
    static int testCaseNumber = 1;
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
        Map<int[], Integer> indexMap = new HashMap<>();
        char[] result = new char[n];
        Stack<int[]> stackJ = new Stack<>();
        Stack<int[]> stackC = new Stack<>();
        boolean isImpossible = false;

        // Read intervals and store their original indices
        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
            indexMap.put(intervals[i], i);
        }

        // Sort intervals by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        char currentPerson = 'J';

        // Assign intervals to 'J' or 'C'
        for (int i = 0; i < n; i++) {
            result[indexMap.get(intervals[i])] = currentPerson;
            if (i < n - 1 && doesOverlap(intervals[i], intervals[i + 1])) {
                if (currentPerson == 'J') {
                    stackJ.push(intervals[i]);
                    currentPerson = switchPerson(currentPerson);

                    if (!stackC.isEmpty() && doesOverlap(stackC.peek(), intervals[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                } else {
                    stackC.push(intervals[i]);
                    currentPerson = switchPerson(currentPerson);

                    if (!stackJ.isEmpty() && doesOverlap(stackJ.peek(), intervals[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                }
            } else {
                if (currentPerson == 'J') {
                    stackJ.push(intervals[i]);
                } else {
                    stackC.push(intervals[i]);
                }
            }
        }

        System.out.println("Case #" + testCaseNumber++ + ": " + (isImpossible ? "IMPOSSIBLE" : new String(result)));
    }

    private static char switchPerson(char person) {
        return person == 'J' ? 'C' : 'J';
    }

    private static boolean doesOverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }
}