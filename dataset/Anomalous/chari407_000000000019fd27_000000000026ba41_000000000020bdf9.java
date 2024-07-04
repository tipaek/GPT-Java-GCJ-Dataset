import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int test = 1; test <= t; test++) {
            int n = sc.nextInt();
            StringBuilder answer = new StringBuilder();
            boolean[] cameron = new boolean[1441];
            boolean[] jamie = new boolean[1441];
            boolean impossible = false;

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();

                if (isAvailable(cameron, start, end)) {
                    markTime(cameron, start, end);
                    answer.append('C');
                } else if (isAvailable(jamie, start, end)) {
                    markTime(jamie, start, end);
                    answer.append('J');
                } else {
                    impossible = true;
                }
            }

            if (impossible) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", test);
            } else {
                System.out.printf("Case #%d: %s\n", test, answer.toString());
            }
        }
    }

    private static void markTime(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = true;
        }
    }

    private static boolean isAvailable(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }
}