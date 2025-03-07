import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static class Activity implements Comparable<Activity> {
        int time, index;
        boolean isStart;

        public Activity(int time, int index, boolean isStart) {
            this.time = time;
            this.index = index;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Activity other) {
            if (this.time != other.time) {
                return Integer.compare(this.time, other.time);
            }
            return Boolean.compare(other.isStart, this.isStart);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, i, true));
                activities.add(new Activity(end, i, false));
            }
            
            Collections.sort(activities);
            char[] assignments = new char[n];
            boolean cameronBusy = false, jamieBusy = false;
            boolean isPossible = true;
            
            for (Activity activity : activities) {
                if (activity.isStart) {
                    if (!cameronBusy) {
                        assignments[activity.index] = 'C';
                        cameronBusy = true;
                    } else if (!jamieBusy) {
                        assignments[activity.index] = 'J';
                        jamieBusy = true;
                    } else {
                        isPossible = false;
                        break;
                    }
                } else {
                    if (assignments[activity.index] == 'C') {
                        cameronBusy = false;
                    } else {
                        jamieBusy = false;
                    }
                }
            }
            
            System.out.print("Case #" + t + ": ");
            if (!isPossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(new String(assignments));
            }
        }
        
        scanner.close();
    }
}