import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static String schedule(int[][] intervals, int caseNumber) {
        StringBuilder result = new StringBuilder();
        ArrayList<int[]> cList = new ArrayList<>();
        ArrayList<int[]> jList = new ArrayList<>();

        if (intervals.length > 0) {
            result.append("C");
            cList.add(new int[]{intervals[0][0], intervals[0][1]});

            for (int i = 1; i < intervals.length; i++) {
                if (isValid(cList, intervals[i])) {
                    result.append('C');
                    cList.add(intervals[i]);
                } else if (isValid(jList, intervals[i])) {
                    result.append('J');
                    jList.add(intervals[i]);
                } else {
                    return "Case #" + (caseNumber + 1) + ": " + "IMPOSSIBLE";
                }
            }
        }

        return "Case #" + (caseNumber + 1) + ": " + result.toString();
    }

    // Validates if the interval belongs to either Jamie or Cameron
    public static boolean isValid(ArrayList<int[]> checkList, int[] interval) {
        for (int[] existingInterval : checkList) {
            if ((interval[0] >= existingInterval[0] && interval[0] < existingInterval[1]) ||
                (interval[1] > existingInterval[0] && interval[1] <= existingInterval[1]) ||
                (interval[0] == existingInterval[0])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        StringBuilder results = new StringBuilder();

        for (int caseNumber = 0; caseNumber < numTestCases; caseNumber++) {
            int size = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            int[][] intervals = new int[size][2];

            for (int i = 0; i < size; i++) {
                String[] intervalStrings = scanner.nextLine().split(" ");
                intervals[i][0] = Integer.parseInt(intervalStrings[0]);
                intervals[i][1] = Integer.parseInt(intervalStrings[1]);
            }

            results.append(schedule(intervals, caseNumber)).append("\n");
        }

        System.out.print(results.toString());
    }
}