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
            ArrayList<int[]> jTimeslots = new ArrayList<>();
            ArrayList<int[]> cTimeslots = new ArrayList<>();

            for (int k = 0; k < turns; k++) {
                int startTime = scan.nextInt();
                int endTime = scan.nextInt();

                boolean jBusy = isBusy(jTimeslots, startTime, endTime);
                boolean cBusy = isBusy(cTimeslots, startTime, endTime);

                if (!jBusy) {
                    jTimeslots.add(new int[]{startTime, endTime});
                    results[t] += "J";
                } else if (!cBusy) {
                    cTimeslots.add(new int[]{startTime, endTime});
                    results[t] += "C";
                } else {
                    results[t] = "IMPOSSIBLE";
                    // Skip remaining turns as result is already determined
                    for (int skip = k + 1; skip < turns; skip++) {
                        scan.nextInt();
                        scan.nextInt();
                    }
                    break;
                }
            }
        }

        for (int t = 0; t < testCases; t++) {
            System.out.println("Case #" + (t + 1) + ": " + results[t]);
        }

        scan.close();
    }

    private static boolean isBusy(ArrayList<int[]> timeslots, int startTime, int endTime) {
        for (int[] timeslot : timeslots) {
            int st = timeslot[0];
            int et = timeslot[1];
            if ((startTime < et && endTime > st)) {
                return true;
            }
        }
        return false;
    }
}