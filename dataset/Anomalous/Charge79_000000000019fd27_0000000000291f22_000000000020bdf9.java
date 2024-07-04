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
            int n = Integer.parseInt(scanner.nextLine());
            StringBuilder output = new StringBuilder();
            boolean[] cTime = new boolean[1440];
            boolean[] jTime = new boolean[1440];
            boolean possible = true;

            for (int j = 0; j < n; j++) {
                String[] interval = scanner.nextLine().split(" ");
                int start = Integer.parseInt(interval[0]);
                int end = Integer.parseInt(interval[1]);

                boolean cAvailable = isAvailable(cTime, start, end);
                boolean jAvailable = isAvailable(jTime, start, end);

                if (cAvailable) {
                    output.append("C");
                    fillTime(cTime, start, end);
                } else if (jAvailable) {
                    output.append("J");
                    fillTime(jTime, start, end);
                } else {
                    output = new StringBuilder("IMPOSSIBLE");
                    possible = false;
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

    private static boolean isAvailable(boolean[] time, int start, int end) {
        for (int i = start; i < end; i++) {
            if (time[i]) {
                return false;
            }
        }
        return true;
    }

    private static void fillTime(boolean[] time, int start, int end) {
        for (int i = start; i < end; i++) {
            time[i] = true;
        }
    }
}