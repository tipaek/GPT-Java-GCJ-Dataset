
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int caseId = 1; caseId <= t; caseId++) {
            int schedules = scanner.nextInt();

            StringBuilder result = new StringBuilder();

            boolean[] cameron = new boolean[24 * 60 + 1];
            boolean[] jamie = new boolean[24 * 60 + 1];

            for (int i = 0; i < schedules; i++) {
                int beg = scanner.nextInt();
                int end = scanner.nextInt();

                if (isFree(cameron, beg, end)) {
                    schedule(cameron, beg, end);
                    result.append('C');
                } else if (isFree(jamie, beg, end)) {
                    schedule(jamie, beg, end);
                    result.append('J');
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + caseId + ": " + result);
        }
    }

    private static void schedule(boolean[] arr, int beg, int end) {
        for (int i = beg; i <= end; i++) {
            arr[i] = true;
        }
    }

    private static boolean isFree(boolean[] arr, int beg, int end) {
        for (int i = beg + 1; i < end; i++) {
            if (arr[i]) {
                return false;
            }
        }
        return true;
    }
}
