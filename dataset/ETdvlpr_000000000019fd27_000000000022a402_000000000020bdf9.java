
import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dave
 */
public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        ArrayList<String[]> schedules = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(input.nextLine());
            String[] lines = new String[t];
            for (int j = 0; j < t; j++) {
                lines[j] = input.nextLine();
            }
            schedules.add(lines);
        }
        Solution sol = new Solution();
        for (int i = 0; i < n; i++) {
            System.out.println(sol.solve(schedules.get(i), i + 1));
        }
    }

    public String solve(String[] Schedule, int Case) {
        String sch = "";
        ArrayList<Point> C = new ArrayList<>();
        ArrayList<Point> J = new ArrayList<>();
        for (int i = 0; i < Schedule.length; i++) {
            String[] s = Schedule[i].split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            
            boolean viable = true;
            for (int j = 0; j < J.size(); j++) {
                if((start > J.get(j).x && start < J.get(j).y) || (end > J.get(j).x && end < J.get(j).y )) {
                    viable = false;
                    break;
                }
            }
            if(viable) {
                sch += "J";
                J.add(new Point(start, end));
                continue;
            }
            viable = true;
            for (int j = 0; j < C.size(); j++) {
                if((start > C.get(j).x && start < C.get(j).y) || (end > C.get(j).x && end < C.get(j).y )) {
                    viable = false;
                    break;
                }
            }
            if(viable) {
                sch += "C";
                C.add(new Point(start, end));
            } else {
                return String.format("Case #%d: IMPOSSIBLE", Case);
            }
        }
        return String.format("Case #%d: %s", Case, sch);
    }
}
