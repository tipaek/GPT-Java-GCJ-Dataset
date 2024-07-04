import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            ArrayList<Interval> intervals = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                intervals.add(new Interval(start, end));
            }

            StringBuilder schedule = new StringBuilder();
            ArrayList<Interval> jTasks = new ArrayList<>();
            ArrayList<Interval> cTasks = new ArrayList<>();

            jTasks.add(intervals.get(0));
            schedule.append("J");
            intervals.remove(0);

            boolean impossible = false;

            for (Interval current : intervals) {
                boolean overlapJ = hasOverlap(jTasks, current);
                boolean overlapC = hasOverlap(cTasks, current);

                if (!overlapJ) {
                    jTasks.add(current);
                    schedule.append("J");
                } else if (!overlapC) {
                    cTasks.add(current);
                    schedule.append("C");
                } else {
                    impossible = true;
                    break;
                }
            }

            String result = impossible ? "IMPOSSIBLE" : schedule.toString();
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
        sc.close();
    }

    private static boolean hasOverlap(ArrayList<Interval> taskList, Interval current) {
        for (Interval task : taskList) {
            if ((task.start < current.end && task.end > current.start) || 
                (task.start <= current.start && task.end >= current.end)) {
                return true;
            }
        }
        return false;
    }
}

class Interval {
    int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}