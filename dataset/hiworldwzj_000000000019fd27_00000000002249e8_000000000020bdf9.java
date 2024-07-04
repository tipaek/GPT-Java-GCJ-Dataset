import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

import static javax.print.attribute.standard.MediaSizeName.C;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        int testCaseNum = 0;
        while(T != 0) {
            T--;
            testCaseNum++;
            int N = Integer.parseInt(reader.readLine());
            Activity[] activities = new Activity[N];
            impossible = false;
            for(int i = 0; i < N; i++) {
                String[] bufs = reader.readLine().split(" ");
                activities[i] = new Activity();
                activities[i].start = Integer.parseInt(bufs[0]);
                activities[i].end = Integer.parseInt(bufs[1]);
                for(int j = 0; j < i; j++) {
                    if(activities[i].inserct(activities[j])) {
                        activities[i].friends.add(j);
                        activities[j].friends.add(i);
                    }
                }
            }
            for(int i = 0; i < N; i++) {
                if(activities[i].holder == null) {
                    activities[i].holder = 'J';
                    dfs(activities, i);
                }
            }
            if(impossible) {
                System.out.println("Case #" + testCaseNum + ": IMPOSSIBLE");
            } else {
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < activities.length; i++) {
                    sb.append(activities[i].holder);
                }
                System.out.println("Case #" + testCaseNum + ": "  + sb.toString());
            }
        }
    }

    public static void dfs(Activity[] activities, int id) {
        for(int new_id : activities[id].friends) {
            if(activities[new_id].holder == null) {
                activities[new_id].holder = activities[id].holder == 'J' ? 'C': 'J';
                dfs(activities, new_id);
            } else {
                //å†²çªäº†ï¼Œè¿”å›
                if(activities[new_id].holder == activities[id].holder) {
                    impossible = true;
                    return;
                }
            }
        }
    }

    static boolean impossible = false;

    static class Activity implements Comparable<Activity>{
        int start;
        int end;
        Character holder = null;
        ArrayList<Integer> friends = new ArrayList<>();

        @Override
        public int compareTo(Activity o) {
            if(this.start < o.start) {
                return -1;
            }
            if(this.start > o.start) {
                return 1;
            }
            return 0;
        }

        public boolean inserct(Activity o) {
            int start = Math.max(this.start, o.start);
            int end = Math.min(this.end - 1, o.end - 1);
            //æ˜¯å¦å­˜åœ¨é‡å 
            if(start <= end) {
                return true;
            } else {
                return false;
            }
        }
    }
}
