import java.util.*;

public class Solution {
    private static final Scanner scan = new Scanner(System.in);
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        int t = scan.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int n = scan.nextInt();
        int[][] intervals = new int[n][2];
        char[] assignments = new char[n];
        Map<int[], Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            intervals[i][0] = scan.nextInt();
            intervals[i][1] = scan.nextInt();
            indexMap.put(intervals[i], i);
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        Stack<int[]> jStack = new Stack<>();
        Stack<int[]> cStack = new Stack<>();
        char currentPerson = 'J';
        boolean impossible = false;

        for (int i = 0; i < n; i++) {
            assignments[indexMap.get(intervals[i])] = currentPerson;

            if (i < n - 1 && overlaps(intervals[i], intervals[i + 1])) {
                if (currentPerson == 'J') {
                    jStack.push(intervals[i]);
                    currentPerson = switchPerson(currentPerson);

                    if (!cStack.isEmpty() && overlaps(cStack.peek(), intervals[i + 1])) {
                        impossible = true;
                        break;
                    }
                } else {
                    cStack.push(intervals[i]);
                    currentPerson = switchPerson(currentPerson);

                    if (!jStack.isEmpty() && overlaps(jStack.peek(), intervals[i + 1])) {
                        impossible = true;
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

        System.out.println("Case #" + (testCaseNumber++) + ": " + (impossible ? "IMPOSSIBLE" : new String(assignments)));
    }

    private static char switchPerson(char person) {
        return person == 'J' ? 'C' : 'J';
    }

    private static boolean overlaps(int[] a, int[] b) {
        return a[1] > b[0];
    }
}