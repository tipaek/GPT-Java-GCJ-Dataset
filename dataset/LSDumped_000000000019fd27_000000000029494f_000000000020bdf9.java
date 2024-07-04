import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int total = in.nextInt();
        long finishActivity [] = new long [2];
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= total; i++) {
            int numActivities = in.nextInt();
            Dato  activities [] = new Dato [numActivities];
            for (int w = 0; w < numActivities; w++) {
                long starts = in.nextLong();
                long ends = in.nextLong();
                activities [w] = new Dato();
                activities [w].starts = starts;
                activities [w].ends = ends;
            }
            Arrays.sort(activities,new Comparator<Dato>() {
                @Override
                public int compare(Dato o1, Dato o2) {
                    return Long.compare(o1.starts, o2.starts);
                }
            });
            for (int w = 0; w < numActivities; w++) {
                if (finishActivity[0] <= activities[w].starts) {
                    result.append('C');
                    finishActivity[0] = activities[w].ends;
                } else {
                    if (finishActivity[1] <= activities[w].starts) {
                        result.append('J');
                        finishActivity[1] = activities[w].ends;
                    } else {
                        result = new StringBuilder();
                        result.append("IMPOSSIBLE");
                        break;
                    }
                }
            }
            System.out.println("Case#" + i + ": " + result);
            result = new StringBuilder();
            finishActivity[0] = 0;
            finishActivity[1] = 0;
        }
    }
}

class Dato {
    long starts;
    long ends;
}

