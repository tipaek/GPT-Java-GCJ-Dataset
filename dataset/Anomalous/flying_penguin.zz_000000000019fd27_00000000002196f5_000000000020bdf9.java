import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int activities = scanner.nextInt();
            boolean[] cameronSchedule = new boolean[24 * 60 + 1];
            boolean[] jamieSchedule = new boolean[24 * 60 + 1];

            StringBuilder result = new StringBuilder();
            boolean impossible = false;

            for (int i = 0; i < activities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (!cameronSchedule[start] && !cameronSchedule[end]) {
                    for (int k = start + 1; k < end; k++) {
                        cameronSchedule[k] = true;
                    }
                    result.append("C");
                } else if (!jamieSchedule[start] && !jamieSchedule[end]) {
                    for (int k = start + 1; k < end; k++) {
                        jamieSchedule[k] = true;
                    }
                    result.append("J");
                } else {
                    impossible = true;
                }
            }

            if (impossible) {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}