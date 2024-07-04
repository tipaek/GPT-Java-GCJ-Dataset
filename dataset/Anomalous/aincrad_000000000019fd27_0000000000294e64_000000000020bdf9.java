import java.util.*;

public class Main {
    static int testCaseNumber;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[][] intervals = new int[n][2];
        char[] assignments = new char[n];
        boolean isImpossible = false;

        Map<int[], Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
            indexMap.put(intervals[i], i);
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        Stack<int[]> jStack = new Stack<>();
        Stack<int[]> cStack = new Stack<>();
        char currentPerson = 'J';

        for (int i = 0; i < n; i++) {
            assignments[indexMap.get(intervals[i])] = currentPerson;

            if (i < n - 1 && overlaps(intervals[i], intervals[i + 1])) {
                if (currentPerson == 'J') {
                    jStack.push(intervals[i]);
                    currentPerson = switchPerson(currentPerson);

                    if (!cStack.isEmpty() && overlaps(cStack.peek(), intervals[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                } else {
                    cStack.push(intervals[i]);
                    currentPerson = switchPerson(currentPerson);

                    if (!jStack.isEmpty() && overlaps(jStack.peek(), intervals[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                }
            } else {
                if (currentPerson == 'J') {
                    jStack.push(intervals[i]);
                } else {
                    cStack.push(intervals[i]);
                }
            }
        }

        System.out.println("Case #" + testCaseNumber++ + ": " + (isImpossible ? "IMPOSSIBLE" : new String(assignments)));
    }

    private static char switchPerson(char person) {
        return person == 'J' ? 'C' : 'J';
    }

    private static boolean overlaps(int[] a, int[] b) {
        return a[1] > b[0];
    }
}