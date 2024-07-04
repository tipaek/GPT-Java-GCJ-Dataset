import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            int n = scanner.nextInt();
            int[] intervals = new int[n * 2];

            for (int j = 0; j < n * 2; j++) {
                intervals[j] = scanner.nextInt();
            }

            String assignment = assignTasks(intervals, n);
            System.out.println("Case #" + caseIndex + ": " + assignment);
        }
    }

    private static String assignTasks(int[] intervals, int n) {
        if (isImpossible(intervals, n)) {
            return "IMPOSSIBLE";
        }

        StringBuilder result = new StringBuilder();
        String firstPerson = n <= 3 ? "C" : "J";
        String secondPerson = n <= 3 ? "J" : "C";

        result.append(firstPerson);

        for (int k = 2; k < n * 2; k += 2) {
            if (isConflict(intervals, k)) {
                result.append(secondPerson);
            } else if (isOverlap(intervals, k)) {
                result.append(result.charAt(result.length() - 1) == 'J' ? secondPerson : firstPerson);
            } else if (intervals[k] == intervals[k - 1]) {
                result.append(result.charAt(result.length() - 1));
            } else {
                result.append(firstPerson);
            }
        }

        return result.toString();
    }

    private static boolean isImpossible(int[] intervals, int n) {
        return (intervals[0] == 0 && intervals[1] == 1440 && n > 2) ||
               (intervals[2] > intervals[0] && intervals[3] < intervals[1]);
    }

    private static boolean isConflict(int[] intervals, int k) {
        return (intervals[k] < intervals[k - 1] && intervals[k] > intervals[k - 2]) ||
               (intervals[k + 1] > intervals[k - 2] && intervals[k + 1] < intervals[k - 2]);
    }

    private static boolean isOverlap(int[] intervals, int k) {
        return (intervals[k] < intervals[k - 1] && intervals[k] < intervals[k - 2]) ||
               (intervals[k + 1] < intervals[k - 2] && intervals[k + 1] > intervals[k - 2]);
    }
}