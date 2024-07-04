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

            for (int k = 0; k < turns; k++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                boolean jBusy = isBusy(jTimes, startTime, endTime);
                boolean cBusy = isBusy(cTimes, startTime, endTime);

                if (!jBusy) {
                    jTimes.add(new int[]{startTime, endTime});
                    result.append("J");
                } else if (!cBusy) {
                    cTimes.add(new int[]{startTime, endTime});
                    result.append("C");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            results[t] = result.toString();
        }
        scanner.close();

        for (int t = 0; t < testCases; t++) {
            System.out.println("Case #" + (t + 1) + ": " + results[t]);
        }
    }

    private static boolean isBusy(ArrayList<int[]> times, int startTime, int endTime) {
        for (int[] time : times) {
            int start = time[0];
            int end = time[1];
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