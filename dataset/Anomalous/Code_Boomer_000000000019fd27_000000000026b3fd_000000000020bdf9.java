import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static boolean canInsert(ArrayList<ArrayList<Integer>> intervals, ArrayList<Integer> newInterval) {
        if (intervals.isEmpty()) {
            return true;
        }
        
        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.size() == 1) {
                if (intervals.get(i).get(1) <= newInterval.get(0)) {
                    return true;
                }
            }
            if (i == 0) {
                if (intervals.get(i).get(0) >= newInterval.get(1)) {
                    return true;
                }
            } else if (i == intervals.size() - 1) {
                if (intervals.get(i).get(1) <= newInterval.get(0)) {
                    return true;
                }
            } else {
                if (intervals.get(i - 1).get(1) <= newInterval.get(0) && newInterval.get(1) <= intervals.get(i).get(0)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Comparator<ArrayList<Integer>> intervalComparator = (o1, o2) -> o1.get(0).compareTo(o2.get(0));
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer>> intervals = new ArrayList<>();
            
            for (int j = 0; j < n; j++) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(sc.nextInt());
                temp.add(sc.nextInt());
                intervals.add(temp);
            }

            String result = "";
            ArrayList<ArrayList<Integer>> J = new ArrayList<>();
            ArrayList<ArrayList<Integer>> C = new ArrayList<>();

            for (ArrayList<Integer> interval : intervals) {
                if (canInsert(C, interval)) {
                    result += "C";
                    C.add(interval);
                    C.sort(intervalComparator);
                } else if (canInsert(J, interval)) {
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
    }
}