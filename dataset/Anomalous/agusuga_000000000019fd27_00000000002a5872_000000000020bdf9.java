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

            // Collect all the activities
            for (int j = 0; j < numActivity; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                activities.add(new Point(0, start));
                activities.add(new Point(1, end));
                pairs.add(new Point(start, end));
            }

            activities.sort((x1, x2) -> {
                int result = Double.compare(x1.getY(), x2.getY());
                if (result == 0) {
                    result = Double.compare(x1.getX(), x2.getX());
                }
                return result;
            });

            StringBuilder schedule = new StringBuilder();
            int cameronBusy = -1;
            int jamieBusy = -1;

            for (Point activity : activities) {
                if (activity.getX() == 0) { // Start time
                    if (cameronBusy == -1) {
                        cameronBusy = (int) activity.getY();
                        schedule.append('C');
                    } else if (jamieBusy == -1) {
                        jamieBusy = (int) activity.getY();
                        schedule.append('J');
                    } else {
                        schedule = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                } else { // End time
                    if (cameronBusy != -1) {
                        for (Point pair : pairs) {
                            if (pair.getY() == activity.getY() && cameronBusy == pair.getX()) {
                                cameronBusy = -1;
                                break;
                            }
                        }
                    }

                    if (jamieBusy != -1) {
                        for (Point pair : pairs) {
                            if (pair.getY() == activity.getY() && jamieBusy == pair.getX()) {
                                jamieBusy = -1;
                                break;
                            }
                        }
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + schedule);
        }
    }
}