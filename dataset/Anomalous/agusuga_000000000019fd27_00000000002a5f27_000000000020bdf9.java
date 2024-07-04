import java.util.*;
import java.io.*;
import java.awt.Point;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();

        for (int i = 0; i < cases; i++) {
            int numActivity = in.nextInt();
            List<Point> activities = new ArrayList<>();
            List<Point> pairs = new ArrayList<>();

            for (int j = 0; j < numActivity; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                activities.add(new Point(0, start));
                activities.add(new Point(1, end));
                pairs.add(new Point(start, end));
            }

            activities.sort(new Comparator<Point>() {
                public int compare(Point p1, Point p2) {
                    int result = Integer.compare(p1.y, p2.y);
                    if (result == 0) {
                        result = Integer.compare(p1.x, p2.x);
                    }
                    return result;
                }
            });

            StringBuilder schedule = new StringBuilder();
            int cameronBusy = -1;
            int jamieBusy = -1;
            boolean impossible = false;

            for (Point activity : activities) {
                if (activity.x == 0) { // Start time
                    if (cameronBusy == -1) {
                        cameronBusy = activity.y;
                        schedule.append('C');
                    } else if (jamieBusy == -1) {
                        jamieBusy = activity.y;
                        schedule.append('J');
                    } else {
                        impossible = true;
                        break;
                    }
                } else { // End time
                    for (Point pair : pairs) {
                        if (pair.y == activity.y) {
                            if (cameronBusy == pair.x) {
                                cameronBusy = -1;
                            } else if (jamieBusy == pair.x) {
                                jamieBusy = -1;
                            }
                        }
                    }
                }
            }

            if (impossible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + schedule);
            }
        }
    }
}