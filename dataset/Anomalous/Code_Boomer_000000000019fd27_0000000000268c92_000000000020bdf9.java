import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static boolean canInsert(ArrayList<ArrayList<Integer>> intervals, ArrayList<Integer> newInterval) {
        if (intervals.isEmpty()) {
            return true;
        }
        for (int i = 0; i < intervals.size(); i++) {
            if (i == 0 && newInterval.get(1) <= intervals.get(i).get(0)) {
                return true;
            }
            if (i == intervals.size() - 1 && newInterval.get(0) >= intervals.get(i).get(1)) {
                return true;
            }
            if (i < intervals.size() - 1 &&
                newInterval.get(0) >= intervals.get(i).get(1) &&
                newInterval.get(1) <= intervals.get(i + 1).get(0)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Comparator<ArrayList<Integer>> intervalComparator = Comparator.comparingInt(o -> o.get(0));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            ArrayList<ArrayList<Integer>> intervals = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                ArrayList<Integer> interval = new ArrayList<>();
                interval.add(scanner.nextInt());
                interval.add(scanner.nextInt());
                intervals.add(interval);
            }

            StringBuilder result = new StringBuilder();
            ArrayList<ArrayList<Integer>> C = new ArrayList<>();
            ArrayList<ArrayList<Integer>> J = new ArrayList<>();

            for (ArrayList<Integer> interval : intervals) {
                if (canInsert(C, interval)) {
                    result.append("C");
                    C.add(interval);
                    C.sort(intervalComparator);
                } else if (canInsert(J, interval)) {
                    result.append("J");
                    J.add(interval);
                    J.sort(intervalComparator);
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + t + ": " + result);
        }
    }
}