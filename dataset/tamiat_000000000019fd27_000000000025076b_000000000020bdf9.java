import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static class Activity{
        int start, end, order;
        public Activity(String[] times, int order){
            this.start = Integer.parseInt(times[0]);
            this.end = Integer.parseInt(times[1]);
            this.order = order;
        }

        @Override
        public String toString() {
            return "Activity{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ttc = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < ttc; tc++){
            int N = Integer.parseInt(br.readLine());
            String[] assignment = new String[N];
            List<Activity> activities = new ArrayList<>();
            for(int i = 0; i < N; i++){
                activities.add(new Activity(br.readLine().split(" "), i));
            }
            Collections.sort(activities, new Comparator<Activity>() {
                @Override
                public int compare(Activity activity, Activity t1) {
                    return activity.start - t1.start;
                }
            });
            Activity c = null, j = null;
            boolean bb = false;
            for(Activity activity: activities) {
                boolean as = false;
                //assign C
                if(c == null || c.end <= activity.start){
                    c = activity;
                    as = true;
                    assignment[activity.order] = "C";
                }
                //assign J
                if(!as && (j == null || j.end <= activity.start)){
                    j = activity;
                    as = true;
                    assignment[activity.order] = "J";
                }

                if(!as){
                    bb = true; break;
                }

            };
            if(bb) System.out.println("Case #" + (tc+1) + ": IMPOSSIBLE");
            else {
                StringJoiner joiner = new StringJoiner("");
                for(int i = 0; i < assignment.length; i++) {
                    joiner.add(assignment[i]);
                }
                System.out.println("Case #" + (tc+1) + ": " + joiner);
            }
        }
    }
}
