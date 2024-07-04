import java.util.*;

public class Solution {
    private static Scanner scanner;
    private static int currentCase = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < t; i++) {
            solveCase();
        }
    }

    private static void solveCase() {
        int N = scanner.nextInt();
        int[][] intervals = new int[N][2];
        int[][] sortedIntervals = new int[N][2];
        char[] assignedChars = new char[N];
        Stack<int[]> cStack = new Stack<>();
        Stack<int[]> jStack = new Stack<>();
        Map<int[], Integer> indexMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
            indexMap.put(intervals[i], i);
        }

        sortedIntervals = intervals.clone();
        Arrays.sort(sortedIntervals, Comparator.comparingInt(o -> o[0]));

        char currentChar = 'C';
        boolean isImpossible = false;

        for (int i = 0; i < sortedIntervals.length; i++) {
            assignedChars[indexMap.get(sortedIntervals[i])] = currentChar;
            if (i != sortedIntervals.length - 1 && overlaps(sortedIntervals[i], sortedIntervals[i + 1])) {
                if (currentChar == 'J') {
                    jStack.push(sortedIntervals[i]);
                    currentChar = invertChar(currentChar);

                    if (!cStack.isEmpty() && overlaps(cStack.peek(), sortedIntervals[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                } else {
                    cStack.push(sortedIntervals[i]);
                    currentChar = invertChar(currentChar);

                    if (!jStack.isEmpty() && overlaps(jStack.peek(), sortedIntervals[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                }
            } else {
                if (currentChar == 'J') {
                    jStack.push(sortedIntervals[i]);
                } else {
                    cStack.push(sortedIntervals[i]);
                }
            }
        }

        System.out.println("Case #" + currentCase + ": " + (isImpossible ? "IMPOSSIBLE" : new String(assignedChars)));
        currentCase++;
    }

    private static char invertChar(char c) {
        return c == 'C' ? 'J' : 'C';
    }

    private static boolean overlaps(int[] interval1, int[] interval2) {
        return interval1[1] > interval2[0];
    }
}