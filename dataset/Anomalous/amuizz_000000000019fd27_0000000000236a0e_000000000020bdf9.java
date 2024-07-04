import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= testCases; t++) {
            List<int[]> cameronSchedule = new ArrayList<>();
            List<int[]> jamieSchedule = new ArrayList<>();
            int numIntervals = Integer.parseInt(scanner.nextLine());
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < numIntervals; i++) {
                int[] interval = parseInterval(scanner.nextLine());
                if (!hasOverlap(cameronSchedule, interval)) {
                    cameronSchedule.add(interval);
                    result.append("C");
                } else if (!hasOverlap(jamieSchedule, interval)) {
                    jamieSchedule.add(interval);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println(result);
        }
    }

    private static int[] parseInterval(String input) {
        String[] parts = input.split(" ");
        int[] interval = new int[2];
        interval[0] = Integer.parseInt(parts[0]);
        interval[1] = Integer.parseInt(parts[1]);
        return interval;
    }

    private static boolean hasOverlap(List<int[]> schedule, int[] interval) {
        for (int[] existingInterval : schedule) {
            if (overlaps(existingInterval, interval)) {
                return true;
            }
        }
        return false;
    }

    private static boolean overlaps(int[] interval1, int[] interval2) {
        return (interval1[0] < interval2[1] && interval1[1] > interval2[0]);
    }
}