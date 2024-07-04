import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Solution3_2 {

    public static boolean can(ArrayList<ArrayList<Integer>> intervals, ArrayList<Integer> interval) {
        if (intervals.isEmpty()) {
            return true;
        }
        
        for (int i = 0; i < intervals.size(); i++) {
            if (i == 0 && interval.get(1) <= intervals.get(i).get(0)) {
                return true;
            } else if (i == intervals.size() - 1 && intervals.get(i).get(1) <= interval.get(0)) {
                return true;
            } else if (i > 0 && intervals.get(i - 1).get(1) <= interval.get(0) && interval.get(1) <= intervals.get(i).get(0)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Comparator<ArrayList<Integer>> comparator = Comparator.comparing(o -> o.get(0));
        int T = sc.nextInt();
        
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer>> intervals = new ArrayList<>();
            
            for (int j = 0; j < n; j++) {
                ArrayList<Integer> interval = new ArrayList<>();
                interval.add(sc.nextInt());
                interval.add(sc.nextInt());
                intervals.add(interval);
            }
            
            String result = "";
            ArrayList<ArrayList<Integer>> J = new ArrayList<>();
            ArrayList<ArrayList<Integer>> C = new ArrayList<>();
            
            for (ArrayList<Integer> interval : intervals) {
                if (can(C, interval)) {
                    result += "C";
                    C.add(interval);
                    C.sort(comparator);
                } else if (can(J, interval)) {
                    result += "J";
                    J.add(interval);
                    J.sort(comparator);
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
        sc.close();
    }
}