import java.util.*;

public class Solution {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= t; i++) {
            solve(i);
        }
    }

    private static void solve(int caseNumber) {
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        int[][] sortedIntervals = new int[n][2];
        char[] assignment = new char[n];
        Stack<int[]> jStack = new Stack<>();
        Stack<int[]> cStack = new Stack<>();
        boolean isImpossible = false;

        Map<int[], Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
            sortedIntervals[i] = intervals[i];
            indexMap.put(intervals[i], i);
        }

        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

        char currentPerson = 'J';

        for (int i = 0; i < n; i++) {
            int[] currentInterval = sortedIntervals[i];
            assignment[indexMap.get(currentInterval)] = currentPerson;

            if (i < n - 1 && doesOverlap(currentInterval, sortedIntervals[i + 1])) {
                if (currentPerson == 'J') {
                    jStack.push(currentInterval);
                    currentPerson = 'C';

                    if (!cStack.isEmpty() && doesOverlap(cStack.peek(), sortedIntervals[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                } else {
                    cStack.push(currentInterval);
                    currentPerson = 'J';

                    if (!jStack.isEmpty() && doesOverlap(jStack.peek(), sortedIntervals[i + 1])) {
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

        System.out.println("Case #" + caseNumber + ": " + (isImpossible ? "IMPOSSIBLE" : new String(assignment)));
    }

    private static boolean doesOverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }
}