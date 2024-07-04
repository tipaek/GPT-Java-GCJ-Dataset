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
            int activities = Integer.parseInt(scanner.nextLine());
            StringBuilder schedule = new StringBuilder();
            boolean[] cTime = new boolean[1440];
            boolean[] jTime = new boolean[1440];
            boolean possible = true;

            for (int j = 0; j < activities; j++) {
                String[] times = scanner.nextLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);

                boolean cAvailable = Arrays.stream(cTime, start, end).noneMatch(b -> b);
                boolean jAvailable = Arrays.stream(jTime, start, end).noneMatch(b -> b);

                if (cAvailable) {
                    schedule.append("C");
                    Arrays.fill(cTime, start, end, true);
                } else if (jAvailable) {
                    schedule.append("J");
                    Arrays.fill(jTime, start, end, true);
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            results[i] = schedule.toString();
        }

        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }

        scanner.close();
    }
}