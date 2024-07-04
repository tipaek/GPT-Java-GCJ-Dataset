import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static boolean canFit(ArrayList<ArrayList<Integer>> schedules, ArrayList<Integer> newInterval) {
        if (schedules.isEmpty()) {
            return true;
        }

        for (int i = 0; i < schedules.size(); i++) {
            if (i == 0 && schedules.get(i).get(0) >= newInterval.get(1)) {
                return true;
            }
            if (i == schedules.size() - 1 && schedules.get(i).get(1) <= newInterval.get(0)) {
                return true;
            }
            if (i < schedules.size() - 1 && schedules.get(i).get(1) <= newInterval.get(0) && schedules.get(i + 1).get(0) >= newInterval.get(1)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Comparator<ArrayList<Integer>> comparator = Comparator.comparingInt(o -> o.get(0));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            ArrayList<ArrayList<Integer>> intervals = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                ArrayList<Integer> interval = new ArrayList<>();
                interval.add(scanner.nextInt());
                interval.add(scanner.nextInt());
                intervals.add(interval);
            }

            StringBuilder result = new StringBuilder();
            ArrayList<ArrayList<Integer>> scheduleJ = new ArrayList<>();
            ArrayList<ArrayList<Integer>> scheduleC = new ArrayList<>();

            for (ArrayList<Integer> interval : intervals) {
                if (canFit(scheduleC, interval)) {
                    result.append("C");
                    scheduleC.add(interval);
                    scheduleC.sort(comparator);
                } else if (canFit(scheduleJ, interval)) {
                    result.append("J");
                    scheduleJ.add(interval);
                    scheduleJ.sort(comparator);
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + result);
        }

        scanner.close();
    }
}