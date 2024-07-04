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
            ArrayList<int[]> jTimeSlots = new ArrayList<>();
            ArrayList<int[]> cTimeSlots = new ArrayList<>();

            for (int k = 0; k < turns; k++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                boolean jBusy = isBusy(jTimeSlots, startTime, endTime);
                boolean cBusy = isBusy(cTimeSlots, startTime, endTime);

                if (!jBusy) {
                    jTimeSlots.add(new int[]{startTime, endTime});
                    results[t] += "J";
                } else if (!cBusy) {
                    cTimeSlots.add(new int[]{startTime, endTime});
                    results[t] += "C";
                } else {
                    results[t] = "IMPOSSIBLE";
                    scanner.nextLine();  // Skip remaining input for this test case
                    for (int skip = k + 1; skip < turns; skip++) {
                        scanner.nextLine();
                    }
                    break;
                }
            }
        }
        scanner.close();

        for (int t = 0; t < testCases; t++) {
            System.out.println("Case #" + (t + 1) + ": " + results[t]);
        }
    }

    private static boolean isBusy(ArrayList<int[]> timeSlots, int startTime, int endTime) {
        for (int[] slot : timeSlots) {
            int start = slot[0];
            int end = slot[1];
            if ((startTime >= start && startTime < end) ||
                (endTime > start && endTime <= end) ||
                (start >= startTime && start < endTime) ||
                (end > startTime && end <= endTime)) {
                return true;
            }
        }
        return false;
    }
}