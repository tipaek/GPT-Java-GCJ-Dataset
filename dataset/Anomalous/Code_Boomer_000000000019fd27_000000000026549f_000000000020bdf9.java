import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static boolean canPlaceInterval(ArrayList<ArrayList<Integer>> intervals, ArrayList<Integer> newInterval) {
        if (intervals.isEmpty()) {
            return true;
        }

        for (int i = 0; i < intervals.size(); i++) {
            ArrayList<Integer> current = intervals.get(i);
            if (i == 0 && newInterval.get(1) <= current.get(0)) {
                return true;
            }
            if (i == intervals.size() - 1 && newInterval.get(0) >= current.get(1)) {
                return true;
            }
            if (i < intervals.size() - 1) {
                ArrayList<Integer> next = intervals.get(i + 1);
                if (newInterval.get(0) >= current.get(1) && newInterval.get(1) <= next.get(0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Comparator<ArrayList<Integer>> intervalComparator = Comparator.comparing(o -> o.get(0));

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

            String result = "";
            ArrayList<ArrayList<Integer>> J = new ArrayList<>();
            ArrayList<ArrayList<Integer>> C = new ArrayList<>();

            for (ArrayList<Integer> interval : intervals) {
                if (canPlaceInterval(J, interval)) {
                    result += "J";
                    J.add(interval);
                    J.sort(intervalComparator);
                } else if (canPlaceInterval(C, interval)) {
                    result += "C";
                    C.add(interval);
                    C.sort(intervalComparator);
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }
}