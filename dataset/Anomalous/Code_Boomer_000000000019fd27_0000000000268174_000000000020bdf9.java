import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static boolean can(ArrayList<ArrayList<Integer>> intervals, ArrayList<Integer> newInterval) {
        if (intervals.isEmpty()) {
            return true;
        }
        
        for (int i = 0; i < intervals.size(); i++) {
            if (i == 0 && intervals.get(i).get(0) >= newInterval.get(1)) {
                return true;
            }
            if (i == intervals.size() - 1 && intervals.get(i).get(1) <= newInterval.get(0)) {
                return true;
            }
            if (i < intervals.size() - 1 && intervals.get(i).get(1) <= newInterval.get(0) && intervals.get(i + 1).get(0) >= newInterval.get(1)) {
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Comparator<ArrayList<Integer>> intervalComparator = Comparator.comparingInt(interval -> interval.get(0));
        
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
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
                if (can(C, interval)) {
                    result += "C";
                    C.add(interval);
                    C.sort(intervalComparator);
                } else if (can(J, interval)) {
                    result += "J";
                    J.add(interval);
                    J.sort(intervalComparator);
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }
            
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
        
        scanner.close();
    }
}