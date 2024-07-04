import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.


        for (int testNo = 1; testNo <= tests; ++testNo) {
            System.out.print("Case #" + testNo + ": ");
            int n = in.nextInt();
            ArrayList<Activity> activities = new ArrayList<>();

            for(int i = 0; i < n; ++i) {
                int st = in.nextInt();
                int en = in.nextInt();

                activities.add(new Activity(st, en, i));
            }

            boolean isImpossible = false;

            int currentSec = 0;

            for(int i = 0; i < 60 * 60; ++i) {

                for(Activity ac : activities) {
                    if(ac.startTime <= i && ac.endTime > i) {
                        currentSec++;
                    }
                }

                if(currentSec > 2) {
                    isImpossible = true;
                }
                currentSec = 0;
            }

            if(isImpossible) {
                System.out.println("IMPOSSIBLE");
                continue;
            }

            Collections.sort(activities);

            Person Joe = new Person();
            Person Cam = new Person();

            for(Activity p : activities) {
                if(Joe.canAssign(p)) {
                    Joe.assign(p);
                    p.person = "J";
                } else {
                    Cam.assign(p);
                    p.person = "C";
                }
            }

            for(int i = 0; i < n; ++i) {
                for(Activity ac : activities) {
                    if(ac.id == i) {
                        System.out.print(ac.person);
                    }
                }
            }

            System.out.println();
        }
    }


}

class Person {
    boolean[] daySeconds;

    public Person() {
        daySeconds = new boolean[60 * 60];
    }

    public void assign(Activity activity) {
        for(int i = activity.startTime; i < activity.endTime; ++i) {
            daySeconds[i] = true;
        }
    }

    public boolean canAssign(Activity activity) {
        for(int i = activity.startTime; i < activity.endTime; ++i) {
            if(daySeconds[i]) {
                return false;
            }
        }
        return true;

    }
}

class Activity implements Comparable{
    int startTime, endTime;
    int id;
    String person;

    public Activity(int startTime, int endTime, int id) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.id = id;
        this.person = "";
    }


    public boolean in(int time) {
        return startTime < time && endTime > time;
    }

    @Override
    public int compareTo(Object o) {
        Activity compareTo = (Activity) o;
        if(endTime == compareTo.endTime) {
            return 0;
        } else if(endTime < compareTo.endTime) {
            return -1;
        }
        return 1;
    }
}
