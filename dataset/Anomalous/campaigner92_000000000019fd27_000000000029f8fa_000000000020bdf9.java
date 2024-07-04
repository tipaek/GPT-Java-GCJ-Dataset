import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        String[] results = new String[testCases];

        for (int t = 0; t < testCases; t++) {
            results[t] = "";
            int turns = scan.nextInt();
            ArrayList<int[]> jSchedule = new ArrayList<>();
            ArrayList<int[]> cSchedule = new ArrayList<>();

            for (int k = 0; k < turns; k++) {
                int startTime = scan.nextInt();
                int endTime = scan.nextInt();
                boolean jBusy = isBusy(jSchedule, startTime, endTime);
                boolean cBusy = isBusy(cSchedule, startTime, endTime);

                if (!jBusy) {
                    jSchedule.add(new int[]{startTime, endTime});
                    results[t] += "J";
                } else if (!cBusy) {
                    cSchedule.add(new int[]{startTime, endTime});
                    results[t] += "C";
                } else {
                    results[t] = "IMPOSSIBLE";
                    scan.nextLine(); // Skip the remaining input for this test case
                    break;
                }
            }
        }

        for (int t = 0; t < testCases; t++) {
            System.out.println("Case #" + (t + 1) + ": " + results[t]);
        }
    }

    private static boolean isBusy(ArrayList<int[]> schedule, int startTime, int endTime) {
        for (int[] slot : schedule) {
            int st = slot[0];
            int et = slot[1];
            if ((startTime >= st && startTime < et) || (endTime > st && endTime <= et) ||
                (st >= startTime && st < endTime) || (et > startTime && et <= endTime)) {
                return true;
            }
        }
        return false;
    }
}