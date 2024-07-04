import java.util.*;

public class Solution {
    private static Scanner scanner;
    private static int currentCase = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < testCases; i++) {
            solveCase();
        }
    }

    private static void solveCase() {
        int N = scanner.nextInt();
        int[][] intervals = new int[N][2];
        int[][] sortedIntervals = new int[N][2];
        char[] assignments = new char[N];
        Stack<int[]> cameronStack = new Stack<>();
        Stack<int[]> jamieStack = new Stack<>();
        HashMap<int[], Integer> intervalIndexMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
            intervalIndexMap.put(intervals[i], i);
        }

        sortedIntervals = intervals.clone();
        Arrays.sort(sortedIntervals, Comparator.comparingInt(o -> o[0]));

        char currentPerson = 'C';
        boolean impossible = false;

        for (int i = 0; i < sortedIntervals.length; i++) {
            assignments[intervalIndexMap.get(sortedIntervals[i])] = currentPerson;
            if (i != sortedIntervals.length - 1 && overlaps(sortedIntervals[i], sortedIntervals[i + 1])) {
                if (currentPerson == 'J') {
                    jamieStack.push(sortedIntervals[i]);
                    currentPerson = invert(currentPerson);

                    if (!cameronStack.isEmpty() && overlaps(cameronStack.peek(), sortedIntervals[i + 1])) {
                        impossible = true;
                        break;
                    }
                } else {
                    cameronStack.push(sortedIntervals[i]);
                    currentPerson = invert(currentPerson);

                    if (!jamieStack.isEmpty() && overlaps(jamieStack.peek(), sortedIntervals[i + 1])) {
                        impossible = true;
                        break;
                    }
                }
            } else {
                if (currentPerson == 'J') {
                    jamieStack.push(sortedIntervals[i]);
                } else {
                    cameronStack.push(sortedIntervals[i]);
                }
            }
        }

        System.out.println("Case #" + currentCase + ": " + (impossible ? "IMPOSSIBLE" : new String(assignments)));
        currentCase++;
    }

    private static char invert(char c) {
        return c == 'C' ? 'J' : 'C';
    }

    private static boolean overlaps(int[] interval1, int[] interval2) {
        return interval1[1] > interval2[0];
    }
}