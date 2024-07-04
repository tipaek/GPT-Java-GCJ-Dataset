import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        List<List<String>> results = new ArrayList<>();

        for (int t = 0; t < testCases; t++) {
            int activities = scanner.nextInt();
            int[] startTimes = new int[activities];
            int[] finishTimes = new int[activities];

            for (int i = 0; i < activities; i++) {
                startTimes[i] = scanner.nextInt();
                finishTimes[i] = scanner.nextInt();
            }

            List<String> currentResult = new ArrayList<>();
            results.add(currentResult);

            if (isImpossible(startTimes, finishTimes, activities)) {
                currentResult.add("IMPOSSIBLE");
            } else {
                assignActivities(startTimes, finishTimes, activities, currentResult);
            }
        }

        printResults(results);
    }

    private static boolean isImpossible(int[] startTimes, int[] finishTimes, int activities) {
        int ceiling = (int) Math.ceil((double) activities / 2);

        for (int i = 0; i < activities; i++) {
            int count = 0;
            for (int j = 0; j < activities; j++) {
                if (j != i && finishTimes[i] > startTimes[j] && finishTimes[j] > startTimes[i]) {
                    count++;
                }
                if (count >= ceiling) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void assignActivities(int[] startTimes, int[] finishTimes, int activities, List<String> currentResult) {
        int cStart = -1, cEnd = -1, jStart = -1, jEnd = -1;

        for (int i = 0; i < activities; i++) {
            if (i == 0 || canAssign(startTimes[i], finishTimes[i], cStart, cEnd)) {
                currentResult.add("C");
                cStart = startTimes[i];
                cEnd = finishTimes[i];
            } else if (canAssign(startTimes[i], finishTimes[i], jStart, jEnd)) {
                currentResult.add("J");
                jStart = startTimes[i];
                jEnd = finishTimes[i];
            }
        }
    }

    private static boolean canAssign(int start, int finish, int currentStart, int currentEnd) {
        return currentStart == -1 || (currentStart >= start && currentStart >= finish) || (currentStart <= start && currentEnd <= finish && currentEnd <= start);
    }

    private static void printResults(List<List<String>> results) {
        for (int i = 0; i < results.size(); i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            for (String result : results.get(i)) {
                System.out.print(result);
            }
            System.out.println();
        }
    }
}