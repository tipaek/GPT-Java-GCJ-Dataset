import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activityCount = scanner.nextInt();
            int[][] activities = new int[activityCount][4];

            for (int i = 0; i < activityCount; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                activities[i][2] = i;
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            int lastEndC = 0;
            int lastEndJ = 0;
            boolean isImpossible = false;

            for (int[] activity : activities) {
                int start = activity[0];
                int end = activity[1];

                if (start >= lastEndC) {
                    lastEndC = end;
                    activity[3] = 0;
                } else if (start >= lastEndJ) {
                    lastEndJ = end;
                    activity[3] = 1;
                } else {
                    isImpossible = true;
                    break;
                }
            }

            StringBuilder output = new StringBuilder();
            if (isImpossible) {
                output.append("IMPOSSIBLE");
            } else {
                Arrays.sort(activities, Comparator.comparingInt(a -> a[2]));
                for (int[] activity : activities) {
                    output.append(activity[3] == 0 ? 'C' : 'J');
                }
            }

            System.out.println("Case #" + testCase + ": " + output);
        }
    }
}