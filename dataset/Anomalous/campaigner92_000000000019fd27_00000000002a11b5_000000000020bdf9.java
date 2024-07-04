import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        String[] results = new String[testCases];

        for (int t = 0; t < testCases; t++) {
            results[t] = "";
            int turns = scanner.nextInt();
            ArrayList<int[]> jSchedule = new ArrayList<>();
            ArrayList<int[]> cSchedule = new ArrayList<>();

            for (int k = 0; k < turns; k++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                if (isAvailable(jSchedule, startTime, endTime)) {
                    jSchedule.add(new int[]{startTime, endTime});
                    results[t] += "J";
                } else if (isAvailable(cSchedule, startTime, endTime)) {
                    cSchedule.add(new int[]{startTime, endTime});
                    results[t] += "C";
                } else {
                    results[t] = "IMPOSSIBLE";
                    scanner.nextLine(); // Skip remaining intervals for this test case
                    break;
                }
            }
        }

        for (int t = 0; t < testCases; t++) {
            System.out.println("Case #" + (t + 1) + ": " + results[t]);
        }
        scanner.close();
    }

    private static boolean isAvailable(ArrayList<int[]> schedule, int startTime, int endTime) {
        for (int[] interval : schedule) {
            int existingStart = interval[0];
            int existingEnd = interval[1];
            if ((startTime < existingEnd && endTime > existingStart)) {
                return false;
            }
        }
        return true;
    }
}