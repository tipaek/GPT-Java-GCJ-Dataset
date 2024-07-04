import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        class Activity implements Comparable <Activity> {
            int s;
            int f;
            int index;
            public Activity(int start, int finish, int index) {
                this.s = start;
                this.f = finish;
                this.index = index;
            }
            @Override
            public int compareTo(Activity o) {
                return this.f - o.f;
            }

            public boolean overlapsWith(Activity other) {
                return ((this.s >= other.s  && this.s < other.f) || (this.f <= other.f && this.f > other.s) || (other.s >= this.s  && other.s < this.f) || (other.f <= this.f && other.f > this.s));
            }
        }
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String result = "";

            int n = in.nextInt();
            int cameron = 0;
            int jamie = 0;
            ArrayList<Activity> cameronActivities = new ArrayList<Activity>();
            ArrayList<Activity> jamieActivities = new ArrayList<Activity>();
            Activity[] activities = new Activity[n];
            boolean possible = true;
            for (int j = 0; j < n; j++) {
                int start = in.nextInt();
                int finish = in.nextInt();
                Activity current = new Activity(start, finish, j);
                activities[j] = current;
                boolean notAssigned = false;
                for (Activity a: cameronActivities) {
                    if (a.overlapsWith(current)) {
                        notAssigned = true;
                    }
                }
                if (notAssigned) {
                    boolean assignToJamie = true;
                    for (Activity a: jamieActivities) {
                        if (a.overlapsWith(current)) {
                            assignToJamie = false;
                            possible = false;
                        }
                    }
                    if (assignToJamie) {
                        result += "J";
                        jamieActivities.add(current);
                    }
                } else {
                    result += "C";
                    cameronActivities.add(current);
                }
            }
            if (possible) {
                assert result.length() == n;
                System.out.println("Case #" + i + ": " + result);
            } else {
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
            }
        }
        in.close();

    }
}