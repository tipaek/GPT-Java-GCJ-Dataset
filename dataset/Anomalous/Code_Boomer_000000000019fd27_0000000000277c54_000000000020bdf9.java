import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static boolean can(ArrayList<ArrayList<Integer>> intervals, ArrayList<Integer> interval) {
        if (intervals.isEmpty()) {
            return true;
        }

        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.size() == 1) {
                if (intervals.get(i).get(1) <= interval.get(0)) {
                    return true;
                }
            } else if (i == 0) {
                if (intervals.get(i).get(0) >= interval.get(1)) {
                    return true;
                }
            } else if (i == intervals.size() - 1) {
                if (intervals.get(i).get(1) <= interval.get(0)) {
                    return true;
                }
            } else {
                if (intervals.get(i - 1).get(1) <= interval.get(0) && interval.get(1) <= intervals.get(i).get(0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Comparator<ArrayList<Integer>> compare = Comparator.comparingInt(o -> o.get(0));
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer>> activities = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(sc.nextInt());
                temp.add(sc.nextInt());
                activities.add(temp);
            }

            String result = "";
            ArrayList<ArrayList<Integer>> J = new ArrayList<>();
            ArrayList<ArrayList<Integer>> C = new ArrayList<>();

            for (ArrayList<Integer> activity : activities) {
                if (can(C, activity)) {
                    result += "C";
                    C.add(activity);
                    C.sort(compare);
                } else if (can(J, activity)) {
                    result += "J";
                    J.add(activity);
                    J.sort(compare);
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
}