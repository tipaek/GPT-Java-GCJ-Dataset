import java.util.*;

public class Solution {
    private static Scanner sc;
    private static int caseNumber = 1;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        char[] assignments = new char[n];
        Stack<int[]> jStack = new Stack<>();
        Stack<int[]> cStack = new Stack<>();
        boolean impossible = false;
        Map<int[], Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
            indexMap.put(intervals[i], i);
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        char currentPerson = 'J';
        for (int i = 0; i < n; i++) {
            assignments[indexMap.get(intervals[i])] = currentPerson;

            if (i < n - 1 && doesOverlap(intervals[i], intervals[i + 1])) {
                if (currentPerson == 'J') {
                    jStack.push(intervals[i]);
                    currentPerson = switchPerson(currentPerson);

                    if (!cStack.isEmpty() && doesOverlap(cStack.peek(), intervals[i + 1])) {
                        impossible = true;
                        break;
                    }
                } else {
                    cStack.push(intervals[i]);
                    currentPerson = switchPerson(currentPerson);

                    if (!jStack.isEmpty() && doesOverlap(jStack.peek(), intervals[i + 1])) {
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

        System.out.println("Case #" + (caseNumber++) + ": " + (impossible ? "IMPOSSIBLE" : new String(assignments)));
    }

    private static char switchPerson(char currentPerson) {
        return currentPerson == 'J' ? 'C' : 'J';
    }

    private static boolean doesOverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }
}