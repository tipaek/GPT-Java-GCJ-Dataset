import java.util.*;

public class Solution {
    private static Scanner sc;
    private static int testCaseNumber = 1;

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
        int[][] sortedIntervals = new int[n][2];
        Map<int[], Integer> intervalIndexMap = new HashMap<>();
        char[] assignedPersons = new char[n];
        Stack<int[]> JStack = new Stack<>();
        Stack<int[]> CStack = new Stack<>();
        boolean isImpossible = false;

        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
            sortedIntervals[i] = intervals[i];
            intervalIndexMap.put(intervals[i], i);
        }

        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

        char currentPerson = 'J';
        for (int i = 0; i < n; i++) {
            assignedPersons[intervalIndexMap.get(sortedIntervals[i])] = currentPerson;
            if (i < n - 1 && doesOverlap(sortedIntervals[i], sortedIntervals[i + 1])) {
                if (currentPerson == 'J') {
                    JStack.push(sortedIntervals[i]);
                    currentPerson = switchPerson(currentPerson);
                    if (!CStack.isEmpty() && doesOverlap(CStack.peek(), sortedIntervals[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                } else {
                    CStack.push(sortedIntervals[i]);
                    currentPerson = switchPerson(currentPerson);
                    if (!JStack.isEmpty() && doesOverlap(JStack.peek(), sortedIntervals[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                }
            } else {
                if (currentPerson == 'J') {
                    JStack.push(sortedIntervals[i]);
                } else {
                    CStack.push(sortedIntervals[i]);
                }
            }
        }

        System.out.println("Case #" + (testCaseNumber++) + ": " + (isImpossible ? "IMPOSSIBLE" : new String(assignedPersons)));
    }

    private static char switchPerson(char person) {
        return person == 'J' ? 'C' : 'J';
    }

    private static boolean doesOverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }
}