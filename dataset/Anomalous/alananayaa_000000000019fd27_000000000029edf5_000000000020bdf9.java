import java.util.*;

public class Solution {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            int[][] sortedIntervals = new int[n][2];
            char[] result = new char[n];
            Stack<int[]> jamieSchedule = new Stack<>();
            Stack<int[]> cameronSchedule = new Stack<>();
            boolean isImpossible = false;
            Map<int[], Integer> indexMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                sortedIntervals[i] = intervals[i];
                indexMap.put(intervals[i], i);
            }

            Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

            char currentPerson = 'J';

            for (int i = 0; i < n; i++) {
                int[] currentInterval = sortedIntervals[i];
                result[indexMap.get(currentInterval)] = currentPerson;

                if (i < n - 1 && intervalsOverlap(currentInterval, sortedIntervals[i + 1])) {
                    if (currentPerson == 'J') {
                        jamieSchedule.push(currentInterval);
                        currentPerson = switchPerson(currentPerson);

                        if (!cameronSchedule.isEmpty() && intervalsOverlap(cameronSchedule.peek(), sortedIntervals[i + 1])) {
                            isImpossible = true;
                            break;
                        }
                    } else {
                        cameronSchedule.push(currentInterval);
                        currentPerson = switchPerson(currentPerson);

                        if (!jamieSchedule.isEmpty() && intervalsOverlap(jamieSchedule.peek(), sortedIntervals[i + 1])) {
                            isImpossible = true;
                            break;
                        }
                    }
                } else {
                    if (currentPerson == 'J') {
                        jamieSchedule.push(currentInterval);
                    } else {
                        cameronSchedule.push(currentInterval);
                    }
                }
            }

            System.out.println("Case #" + t + ": " + (isImpossible ? "IMPOSSIBLE" : new String(result)));
        }
    }

    private static char switchPerson(char person) {
        return person == 'J' ? 'C' : 'J';
    }

    private static boolean intervalsOverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }
}