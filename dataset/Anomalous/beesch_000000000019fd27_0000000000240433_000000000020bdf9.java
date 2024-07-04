import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = in.nextInt();

            for (int i = 1; i <= t; ++i) {
                int n = in.nextInt();
                byte[] c = new byte[1440];
                byte[] j = new byte[1440];
                boolean isImpossible = false;
                StringBuilder result = new StringBuilder();

                for (int a = 0; a < n; a++) {
                    int start = in.nextInt();
                    int end = in.nextInt();

                    if (isImpossible) {
                        continue;
                    }

                    if (!hasCollision(c, start, end)) {
                        markSchedule(c, start, end);
                        result.append("C");
                    } else if (!hasCollision(j, start, end)) {
                        markSchedule(j, start, end);
                        result.append("J");
                    } else {
                        isImpossible = true;
                    }
                }

                System.out.println("Case #" + i + ": " + (isImpossible ? "IMPOSSIBLE" : result.toString()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean hasCollision(byte[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] == 1) {
                return true;
            }
        }
        return false;
    }

    private static void markSchedule(byte[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = 1;
        }
    }
}