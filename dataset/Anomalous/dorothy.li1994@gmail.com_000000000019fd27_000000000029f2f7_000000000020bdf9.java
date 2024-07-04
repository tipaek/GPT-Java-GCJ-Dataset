import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();

        for (int i = 1; i <= cases; i++) {
            int[] cameron = new int[1500];
            int[] jamie = new int[1500];
            int activities = in.nextInt();
            boolean impossible = false;
            StringBuilder solution = new StringBuilder();

            for (int j = 0; j < activities; j++) {
                int start = in.nextInt();
                int end = in.nextInt();

                if (isAvailable(cameron, start, end)) {
                    fillSchedule(cameron, start, end);
                    solution.append("C");
                } else if (isAvailable(jamie, start, end)) {
                    fillSchedule(jamie, start, end);
                    solution.append("J");
                } else {
                    solution = new StringBuilder("IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + solution);
        }
    }

    private static boolean isAvailable(int[] schedule, int start, int end) {
        for (int k = start; k < end; k++) {
            if (schedule[k] == 1) {
                return false;
            }
        }
        return true;
    }

    private static void fillSchedule(int[] schedule, int start, int end) {
        for (int k = start; k < end; k++) {
            schedule[k] = 1;
        }
    }
}