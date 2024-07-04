import java.util.*;

public class Solution {
    private static Scanner scanner;
    private static int caseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        while (testCases > 0) {
            testCases--;

            int numIntervals = scanner.nextInt();
            int[][] intervals = new int[numIntervals][2];
            char[] result = new char[numIntervals];
            Map<int[], Integer> intervalIndexMap = new HashMap<>();

            for (int i = 0; i < numIntervals; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                intervalIndexMap.put(intervals[i], i);
            }

            int[][] sortedIntervals = intervals.clone();
            Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

            Stack<int[]> jamieStack = new Stack<>();
            Stack<int[]> cameronStack = new Stack<>();
            boolean isImpossible = false;
            char currentPerson = 'J';

            for (int i = 0; i < sortedIntervals.length; i++) {
                result[intervalIndexMap.get(sortedIntervals[i])] = currentPerson;
                
                if (i < sortedIntervals.length - 1 && overlaps(sortedIntervals[i], sortedIntervals[i + 1])) {
                    if (currentPerson == 'J') {
                        jamieStack.push(sortedIntervals[i]);
                        currentPerson = 'C';
                        if (!cameronStack.isEmpty() && overlaps(cameronStack.peek(), sortedIntervals[i + 1])) {
                            isImpossible = true;
                            break;
                        }
                    } else {
                        cameronStack.push(sortedIntervals[i]);
                        currentPerson = 'J';
                        if (!jamieStack.isEmpty() && overlaps(jamieStack.peek(), sortedIntervals[i + 1])) {
                            isImpossible = true;
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

            System.out.println("Case #" + (caseNumber++) + ": " + (isImpossible ? "IMPOSSIBLE" : new String(result)));
        }
    }

    private static boolean overlaps(int[] a, int[] b) {
        return a[1] > b[0];
    }
}