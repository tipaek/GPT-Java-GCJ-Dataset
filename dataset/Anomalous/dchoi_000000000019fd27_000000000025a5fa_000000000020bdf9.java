import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activityCount = scanner.nextInt();

            int[] cameron = {0, 0};
            int[] jamie = {0, 0};
            StringBuilder schedule = new StringBuilder();

            boolean possible = true;

            for (int i = 0; i < activityCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (!possible) {
                    continue;
                }

                if (start >= cameron[1] || end <= cameron[0]) {
                    schedule.append("C");
                    cameron[0] = start;
                    cameron[1] = end;
                } else if (start >= jamie[1] || end <= jamie[0]) {
                    schedule.append("J");
                    jamie[0] = start;
                    jamie[1] = end;
                } else {
                    possible = false;
                    schedule = new StringBuilder("IMPOSSIBLE");
                }
            }

            System.out.println("Case #" + testCase + ": " + schedule.toString());
        }
    }
}