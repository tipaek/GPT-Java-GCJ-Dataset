import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int[] cameron = new int[2];
            int[] jaimie = new int[2];
            StringBuilder result = new StringBuilder();
            int activities = scanner.nextInt();
            scanner.nextLine();

            boolean possible = true;
            for (int activity = 0; activity < activities; activity++) {
                String[] times = scanner.nextLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);

                if (isAvailable(cameron, start, end)) {
                    cameron[0] = start;
                    cameron[1] = end;
                    result.append("C");
                } else if (isAvailable(jaimie, start, end)) {
                    jaimie[0] = start;
                    jaimie[1] = end;
                    result.append("J");
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.printf("Case #%d: %s\n", caseNumber, result.toString());
        }
    }

    private static boolean isAvailable(int[] schedule, int start, int end) {
        return (schedule[0] + schedule[1] == 0) || (schedule[1] <= start) || (schedule[0] >= end);
    }
}