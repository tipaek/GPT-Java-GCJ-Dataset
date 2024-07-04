import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            final String IMPOSSIBLE = "IMPOSSIBLE";

            for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
                int n = scanner.nextInt();
                StringBuilder result = new StringBuilder();
                ArrayList<int[]> jActivities = new ArrayList<>();
                ArrayList<int[]> cActivities = new ArrayList<>();

                boolean isPossible = true;

                for (int activity = 0; activity < n; activity++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();

                    if (isFree(jActivities, start, end)) {
                        jActivities.add(new int[]{start, end});
                        result.append("J");
                    } else if (isFree(cActivities, start, end)) {
                        cActivities.add(new int[]{start, end});
                        result.append("C");
                    } else {
                        result = new StringBuilder(IMPOSSIBLE);
                        isPossible = false;
                        break;
                    }
                }

                System.out.println("Case #" + caseNumber + ": " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isFree(ArrayList<int[]> activities, int start, int end) {
        for (int[] activity : activities) {
            if ((activity[0] < start && start < activity[1]) || (activity[0] < end && end < activity[1])) {
                return false;
            }
        }
        return true;
    }
}