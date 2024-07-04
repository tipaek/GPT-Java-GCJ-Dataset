import java.util.*;

public class Solution {
    private static Scanner sc;
    static int testCaseNumber = 1;

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
        Map<int[], Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
            indexMap.put(intervals[i], i);
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        char[] result = new char[n];
        Stack<int[]> JStack = new Stack<>();
        Stack<int[]> CStack = new Stack<>();
        boolean impossible = false;
        char currentPerson = 'J';

        for (int i = 0; i < n; i++) {
            result[indexMap.get(intervals[i])] = currentPerson;

            if (i < n - 1 && doesOverlap(intervals[i], intervals[i + 1])) {
                if (currentPerson == 'J') {
                    JStack.push(intervals[i]);
                    currentPerson = switchPerson(currentPerson);

                    if (!CStack.isEmpty() && doesOverlap(CStack.peek(), intervals[i + 1])) {
                        impossible = true;
                        break;
                    }
                } else {
                    CStack.push(intervals[i]);
                    currentPerson = switchPerson(currentPerson);

                    if (!JStack.isEmpty() && doesOverlap(JStack.peek(), intervals[i + 1])) {
                        impossible = true;
                        break;
                    }
                }
            } else {
                if (currentPerson == 'J') {
                    JStack.push(intervals[i]);
                } else {
                    CStack.push(intervals[i]);
                }
            }
        }

        System.out.println("Case #" + (testCaseNumber++) + ": " + (impossible ? "IMPOSSIBLE" : new String(result)));
    }

    private static char switchPerson(char person) {
        return person == 'J' ? 'C' : 'J';
    }

    private static boolean doesOverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }
}