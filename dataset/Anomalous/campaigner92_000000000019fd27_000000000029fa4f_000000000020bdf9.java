import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        String[] results = new String[testCases];

        for (int t = 0; t < testCases; t++) {
            int turns = scanner.nextInt();
            ArrayList<int[]> jTimes = new ArrayList<>();
            ArrayList<int[]> cTimes = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            boolean isImpossible = false;

            for (int k = 0; k < turns; k++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                if (isImpossible) continue;

                boolean jBusy = isTimeSlotBusy(jTimes, startTime, endTime);
                boolean cBusy = isTimeSlotBusy(cTimes, startTime, endTime);

                if (!jBusy) {
                    jTimes.add(new int[]{startTime, endTime});
                    result.append("J");
                } else if (!cBusy) {
                    cTimes.add(new int[]{startTime, endTime});
                    result.append("C");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    isImpossible = true;
                }
            }
            results[t] = result.toString();
        }

        for (int t = 0; t < testCases; t++) {
            System.out.println("Case #" + (t + 1) + ": " + results[t]);
        }
        scanner.close();
    }

    private static boolean isTimeSlotBusy(ArrayList<int[]> timeSlots, int startTime, int endTime) {
        for (int[] timeSlot : timeSlots) {
            int start = timeSlot[0];
            int end = timeSlot[1];
            if ((startTime < end && endTime > start)) {
                return true;
            }
        }
        return false;
    }
}