import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testcases = scan.nextInt();
        String[] results = new String[testcases];

        for (int t = 0; t < testcases; t++) {
            int turns = scan.nextInt();
            results[t] = scheduleTurns(scan, turns);
        }
        
        scan.close();

        for (int t = 0; t < testcases; t++) {
            System.out.println("Case #" + (t + 1) + ": " + results[t]);
        }
    }

    private static String scheduleTurns(Scanner scan, int turns) {
        ArrayList<int[]> jTimeslots = new ArrayList<>();
        ArrayList<int[]> cTimeslots = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        for (int k = 0; k < turns; k++) {
            int startTime = scan.nextInt();
            int endTime = scan.nextInt();

            if (isAvailable(jTimeslots, startTime, endTime)) {
                jTimeslots.add(new int[]{startTime, endTime});
                result.append("J");
            } else if (isAvailable(cTimeslots, startTime, endTime)) {
                cTimeslots.add(new int[]{startTime, endTime});
                result.append("C");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }

    private static boolean isAvailable(ArrayList<int[]> timeslots, int start, int end) {
        for (int[] timeslot : timeslots) {
            int tsStart = timeslot[0];
            int tsEnd = timeslot[1];
            if ((start < tsEnd && end > tsStart) || (start == tsStart && end == tsEnd)) {
                return false;
            }
        }
        return true;
    }
}