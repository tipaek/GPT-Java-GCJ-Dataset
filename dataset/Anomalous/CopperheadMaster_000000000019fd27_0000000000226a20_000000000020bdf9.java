import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int activityCount = scanner.nextInt();
            int[][] activities = new int[activityCount][2];
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < activityCount; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            int lastEndC = 0;
            int lastEndJ = 0;
            boolean possible = true;

            for (int[] activity : activities) {
                int start = activity[0];
                int end = activity[1];

                if (start >= lastEndC) {
                    lastEndC = end;
                    result.append("C");
                } else if (start >= lastEndJ) {
                    lastEndJ = end;
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            System.out.println("Case #" + caseNum + ": " + result);
        }
    }
}