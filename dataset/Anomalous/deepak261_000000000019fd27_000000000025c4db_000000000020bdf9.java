import java.util.*;

class Solution {
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

    public static void solve() {
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        int[][] sortedIntervals = new int[n][2];
        char[] resultChars = new char[n];
        Stack<int[]> jStack = new Stack<>();
        Stack<int[]> cStack = new Stack<>();
        boolean isImpossible = false;
        Map<int[], Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
            sortedIntervals[i] = intervals[i].clone();
            indexMap.put(intervals[i], i);
        }

        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

        char currentPerson = 'J';
        for (int i = 0; i < n; i++) {
            resultChars[indexMap.get(sortedIntervals[i])] = currentPerson;
            if (i < n - 1 && doesOverlap(sortedIntervals[i], sortedIntervals[i + 1])) {
                if (currentPerson == 'J') {
                    jStack.push(sortedIntervals[i]);
                    currentPerson = switchPerson(currentPerson);
                    if (!cStack.isEmpty() && doesOverlap(cStack.peek(), sortedIntervals[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                } else {
                    cStack.push(sortedIntervals[i]);
                    currentPerson = switchPerson(currentPerson);
                    if (!jStack.isEmpty() && doesOverlap(jStack.peek(), sortedIntervals[i + 1])) {
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

        System.out.println("Case #" + (testCaseNumber++) + ": " + (isImpossible ? "IMPOSSIBLE" : new String(resultChars)));
    }

    private static char switchPerson(char person) {
        return person == 'J' ? 'C' : 'J';
    }

    private static boolean doesOverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }
}