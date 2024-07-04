import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();

            for (int i = 1; i <= testCases; ++i) {
                int n = scanner.nextInt();
                boolean[] cSchedule = new boolean[1441];
                boolean[] jSchedule = new boolean[1441];
                boolean isImpossible = false;
                StringBuilder result = new StringBuilder();

                for (int j = 0; j < n; j++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();

                    if (isImpossible) {
                        continue;
                    }

                    if (!isCollision(cSchedule, start, end)) {
                        markSchedule(cSchedule, start, end);
                        result.append("C");
                    } else if (!isCollision(jSchedule, start, end)) {
                        markSchedule(jSchedule, start, end);
                        result.append("J");
                    } else {
                        isImpossible = true;
                    }
                }

                if (isImpossible) {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + i + ": " + result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isCollision(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return true;
            }
        }
        return false;
    }

    private static void markSchedule(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = true;
        }
    }
}