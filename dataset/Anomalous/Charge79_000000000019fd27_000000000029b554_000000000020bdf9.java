import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        String[] results = new String[testCases];

        for (int i = 0; i < testCases; i++) {
            int[] cTime = new int[1441];
            int[] jTime = new int[1441];
            int numActivities = Integer.parseInt(scanner.nextLine());
            String[] activities = new String[numActivities];

            for (int j = 0; j < numActivities; j++) {
                activities[j] = scanner.nextLine();
            }

            StringBuilder output = new StringBuilder();
            boolean isPossible = true;

            for (String activity : activities) {
                String[] timeRange = activity.split(" ");
                int start = Integer.parseInt(timeRange[0]);
                int end = Integer.parseInt(timeRange[1]);

                boolean canAssignC = canAssignTime(cTime, start, end);
                boolean canAssignJ = canAssignTime(jTime, start, end);

                if (canAssignC) {
                    output.append("C");
                    Arrays.fill(cTime, start, end, 1);
                } else if (canAssignJ) {
                    output.append("J");
                    Arrays.fill(jTime, start, end, 1);
                } else {
                    output.setLength(0);
                    output.append("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            results[i] = output.toString();
        }

        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }

        scanner.close();
    }

    private static boolean canAssignTime(int[] timeArray, int start, int end) {
        for (int i = start; i < end; i++) {
            if (timeArray[i] == 1) {
                return false;
            }
        }
        return true;
    }
}