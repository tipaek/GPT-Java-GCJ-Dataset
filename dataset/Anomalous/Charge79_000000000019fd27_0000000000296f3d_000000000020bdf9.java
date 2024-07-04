import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        String[] results = new String[testCases];

        for (int i = 0; i < testCases; i++) {
            int numActivities = Integer.parseInt(scanner.nextLine());
            String[] activities = new String[numActivities];
            for (int j = 0; j < numActivities; j++) {
                activities[j] = scanner.nextLine();
            }

            boolean[] cTime = new boolean[1441];
            boolean[] jTime = new boolean[1441];
            StringBuilder output = new StringBuilder();

            for (String activity : activities) {
                String[] times = activity.split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);

                boolean cAvailable = true;
                boolean jAvailable = true;

                for (int k = start; k < end; k++) {
                    if (cTime[k]) {
                        cAvailable = false;
                    }
                    if (jTime[k]) {
                        jAvailable = false;
                    }
                }

                if (cAvailable) {
                    Arrays.fill(cTime, start, end, true);
                    output.append("C");
                } else if (jAvailable) {
                    Arrays.fill(jTime, start, end, true);
                    output.append("J");
                } else {
                    output = new StringBuilder("IMPOSSIBLE");
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
}