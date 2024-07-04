import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        List<String> results = new ArrayList<>();

        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            int numActivities = scanner.nextInt();
            StringBuilder schedule = new StringBuilder();
            int[] J = new int[24 * 60];
            int[] C = new int[24 * 60];
            boolean possible = true;

            for (int j = 0; j < numActivities; ++j) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (possible) {
                    if (isAvailable(start, end, J)) {
                        markOccupied(start, end, J);
                        schedule.append("J");
                    } else if (isAvailable(start, end, C)) {
                        markOccupied(start, end, C);
                        schedule.append("C");
                    } else {
                        possible = false;
                        schedule.setLength(0);
                        schedule.append("IMPOSSIBLE");
                    }
                }
            }
            results.add("Case #" + i + ": " + schedule.toString());
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    static boolean isAvailable(int start, int end, int[] schedule) {
        for (int i = start; i < end; i++) {
            if (schedule[i] == 1) {
                return false;
            }
        }
        return true;
    }

    static void markOccupied(int start, int end, int[] schedule) {
        for (int i = start; i < end; i++) {
            schedule[i] = 1;
        }
    }
}