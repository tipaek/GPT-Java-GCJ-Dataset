import java.util.*;

class Solution {
    private static Scanner sc;
    private static int caseNumber = 1;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();
        while (testCases-- > 0) {
            solveProblem();
        }
    }

    private static char togglePerson(char person) {
        return person == 'J' ? 'C' : 'J';
    }

    private static boolean hasOverlap(int[] interval1, int[] interval2) {
        return interval1[1] > interval2[0];
    }

    private static void solveProblem() {
        int n = sc.nextInt();
        char currentPerson = 'J';
        char[] assignment = new char[n];
        int[][] intervals = new int[n][2];
        int[][] sortedIntervals = new int[n][2];
        boolean impossible = false;
        Stack<int[]> cStack = new Stack<>();
        Stack<int[]> jStack = new Stack<>();
        Map<int[], Integer> intervalIndexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
            sortedIntervals[i] = intervals[i];
            intervalIndexMap.put(intervals[i], i);
        }

        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < sortedIntervals.length; i++) {
            assignment[intervalIndexMap.get(sortedIntervals[i])] = currentPerson;
            if (i < sortedIntervals.length - 1 && hasOverlap(sortedIntervals[i], sortedIntervals[i + 1])) {
                if (currentPerson == 'J') {
                    jStack.push(sortedIntervals[i]);
                    currentPerson = togglePerson(currentPerson);

                    if (!cStack.isEmpty() && hasOverlap(cStack.peek(), sortedIntervals[i + 1])) {
                        impossible = true;
                        break;
                    }
                } else {
                    cStack.push(sortedIntervals[i]);
                    currentPerson = togglePerson(currentPerson);

                    if (!jStack.isEmpty() && hasOverlap(jStack.peek(), sortedIntervals[i + 1])) {
                        impossible = true;
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

        System.out.println("Case #" + (caseNumber++) + ": " + (impossible ? "IMPOSSIBLE" : new String(assignment)));
    }
}