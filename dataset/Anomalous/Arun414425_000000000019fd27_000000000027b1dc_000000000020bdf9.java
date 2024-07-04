import java.util.*;

public class M {
    private static Scanner sc = new Scanner(System.in);
    private static int caseNumber = 1;

    public static void main(String[] args) {
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
        Map<int[], Integer> indexMap = new HashMap<>();
        char[] result = new char[n];
        boolean impossible = false;

        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
            sortedIntervals[i] = intervals[i];
            indexMap.put(intervals[i], i);
        }

        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

        Stack<int[]> jStack = new Stack<>();
        Stack<int[]> cStack = new Stack<>();
        char currentPerson = 'J';

        for (int i = 0; i < n; i++) {
            int[] currentInterval = sortedIntervals[i];
            result[indexMap.get(currentInterval)] = currentPerson;

            if (i < n - 1 && doesOverlap(currentInterval, sortedIntervals[i + 1])) {
                if (currentPerson == 'J') {
                    jStack.push(currentInterval);
                    currentPerson = switchPerson(currentPerson);

                    if (!cStack.isEmpty() && doesOverlap(cStack.peek(), sortedIntervals[i + 1])) {
                        impossible = true;
                        break;
                    }
                } else {
                    cStack.push(currentInterval);
                    currentPerson = switchPerson(currentPerson);

                    if (!jStack.isEmpty() && doesOverlap(jStack.peek(), sortedIntervals[i + 1])) {
                        impossible = true;
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

        System.out.println("Case #" + (caseNumber++) + ": " + (impossible ? "IMPOSSIBLE" : new String(result)));
    }

    private static char switchPerson(char person) {
        return person == 'J' ? 'C' : 'J';
    }

    private static boolean doesOverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }
}