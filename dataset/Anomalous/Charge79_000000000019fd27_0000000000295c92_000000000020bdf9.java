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
            boolean[] cTime = new boolean[1441];
            boolean[] jTime = new boolean[1441];
            StringBuilder output = new StringBuilder();
            boolean possible = true;

            for (int j = 0; j < n; j++) {
                String[] interval = scanner.nextLine().split(" ");
                int start = Integer.parseInt(interval[0]);
                int end = Integer.parseInt(interval[1]);

                boolean cAvailable = isAvailable(cTime, start, end);
                boolean jAvailable = isAvailable(jTime, start, end);

                if (cAvailable) {
                    output.append("C");
                    Arrays.fill(cTime, start, end, true);
                } else if (jAvailable) {
                    output.append("J");
                    Arrays.fill(jTime, start, end, true);
                } else {
                    output = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                results[i] = output.toString();
            } else {
                results[i] = "IMPOSSIBLE";
            }
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
}