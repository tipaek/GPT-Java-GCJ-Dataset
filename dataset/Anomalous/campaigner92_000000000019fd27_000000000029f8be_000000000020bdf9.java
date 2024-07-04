import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        String[] results = new String[testCases];

        for (int t = 0; t < testCases; t++) {
            int turns = scanner.nextInt();
            ArrayList<int[]> jTimeSlots = new ArrayList<>();
            ArrayList<int[]> cTimeSlots = new ArrayList<>();
            StringBuilder schedule = new StringBuilder();

            boolean impossible = false;

            for (int k = 0; k < turns; k++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                if (!isBusy(jTimeSlots, startTime, endTime)) {
                    jTimeSlots.add(new int[]{startTime, endTime});
                    schedule.append("J");
                } else if (!isBusy(cTimeSlots, startTime, endTime)) {
                    cTimeSlots.add(new int[]{startTime, endTime});
                    schedule.append("C");
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }

            results[t] = schedule.toString();
        }

        for (int t = 0; t < testCases; t++) {
            System.out.println("Case #" + (t + 1) + ": " + results[t]);
        }
    }

    private static boolean isBusy(ArrayList<int[]> timeSlots, int startTime, int endTime) {
        for (int[] slot : timeSlots) {
            int start = slot[0];
            int end = slot[1];
            if ((startTime >= start && startTime < end) || (endTime > start && endTime <= end) || 
                (start >= startTime && start < endTime) || (end > startTime && end <= endTime)) {
                return true;
            }
        }
        return false;
    }
}