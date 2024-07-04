import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numIntervals = scanner.nextInt();
            int[][] intervals = new int[numIntervals][2];
            int[][] sortedIntervals = new int[numIntervals][2];
            char[] assignments = new char[numIntervals];
            Map<int[], Integer> intervalToIndex = new HashMap<>();
            Stack<int[]> jamieStack = new Stack<>();
            Stack<int[]> cameronStack = new Stack<>();
            boolean isImpossible = false;

            for (int i = 0; i < numIntervals; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                sortedIntervals[i] = intervals[i].clone();
                intervalToIndex.put(intervals[i], i);
            }

            Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

            char currentPerson = 'J';
            for (int i = 0; i < sortedIntervals.length; i++) {
                assignments[intervalToIndex.get(sortedIntervals[i])] = currentPerson;

                if (i < sortedIntervals.length - 1 && overlaps(sortedIntervals[i], sortedIntervals[i + 1])) {
                    if (currentPerson == 'J') {
                        jamieStack.push(sortedIntervals[i]);
                        currentPerson = switchPerson(currentPerson);
                        if (!cameronStack.isEmpty() && overlaps(cameronStack.peek(), sortedIntervals[i + 1])) {
                            isImpossible = true;
                            break;
                        }
                    } else {
                        cameronStack.push(sortedIntervals[i]);
                        currentPerson = switchPerson(currentPerson);
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

            System.out.println("Case #" + testCase + ": " + (isImpossible ? "IMPOSSIBLE" : new String(assignments)));
        }
    }

    private static boolean overlaps(int[] interval1, int[] interval2) {
        return interval1[1] > interval2[0];
    }

    private static char switchPerson(char person) {
        return person == 'J' ? 'C' : 'J';
    }
}