import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int total = in.nextInt();
        long finishActivity [] = new long [2];
        for (int i = 1; i <= total; i++) {
            int numActivities = in.nextInt();
            Dato  activities [] = new Dato [numActivities];
            char  activitiesReord [] = new char [numActivities];
            boolean boom = false;
            for (int w = 0; w < numActivities; w++) {
                long starts = in.nextLong();
                long ends = in.nextLong();
                activities [w] = new Dato();
                activities [w].starts = starts;
                activities [w].ends = ends;
                activities [w].num_activity = w;
            }
            Arrays.sort(activities,new Comparator<Dato>() {
                @Override
                public int compare(Dato o1, Dato o2) {
                    return Long.compare(o1.starts, o2.starts);
                }
            });
            boom = false;
            for (int w = 0; w < numActivities; w++) {
                if (finishActivity[0] <= activities[w].starts) {
                    activitiesReord [activities[w].num_activity] = 'C';
                    finishActivity[0] = activities[w].ends;
                } else {
                    if (finishActivity[1] <= activities[w].starts) {
                        activitiesReord [activities[w].num_activity] = 'J';
                        finishActivity[1] = activities[w].ends;
                    } else {
                        boom = true;
                        break;
                    }
                }
            }
            int result = 0;
            if (!boom) {
                StringBuilder s = new StringBuilder();
                while (result < numActivities) {
                    s.append(activitiesReord[result]);
                    result++;
                }
                System.out.println("Case #" + result + ":" + s);
            }
            else {
                System.out.println("Case #" + result + ": IMPOSSIBLE");
            }
            finishActivity[0] = 0;
            finishActivity[1] = 0;
        }
    }
}

class Dato {
    long starts;
    long ends;
    int num_activity;
}

