import java.util.*;

class Solution {
    private static Scanner sc;
    static int caseNumber = 1;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();

        while (testCases-- > 0) {
            solveProblem();
        }
    }

    private static char togglePerson(char currentPerson) {
        return currentPerson == 'J' ? 'C' : 'J';
    }

    private static boolean hasOverlap(int[] interval1, int[] interval2) {
        return interval1[1] > interval2[0];
    }

    private static void solveProblem() {
        int numIntervals = sc.nextInt();
        char currentPerson = 'J';
        char[] assignment = new char[numIntervals];
        int[][] intervals = new int[numIntervals][2];
        int[][] sortedIntervals = new int[numIntervals][2];
        boolean impossible = false;

        Stack<int[]> cStack = new Stack<>();
        Stack<int[]> jStack = new Stack<>();
        Map<int[], Integer> intervalIndexMap = new HashMap<>();

        for (int i = 0; i < numIntervals; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
            sortedIntervals[i] = intervals[i].clone();
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