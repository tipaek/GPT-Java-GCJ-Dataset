import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numcases = Integer.parseInt(br.readLine());
        for (int i = 0; i < numcases; i++) {
            String ans = "";
            int numacts = Integer.parseInt(br.readLine());
            TreeMap<Activity, Integer> hm = new TreeMap<>();
            for (int j = 0; j < numacts; j++) {
                Activity hold = new Activity(br.readLine());
                hm.put(hold, j);
            }
            int camtime = 0;
            int jamtime = 0;
            boolean fail = false;
            Iterator it = hm.keySet().iterator();
            char[] ret = new char[numacts];
            for (int j = 0; j < numacts; j++) {
                Activity act = (Activity) it.next();
                if (camtime <= act.begin) {
                    camtime = act.end;
                    ret[hm.get(act)] = 'C';
                } else if (jamtime <= act.begin) {
                    jamtime = act.end;
                    ret[hm.get(act)] = 'J';
                } else {
                    fail = true;
                    break;
                }
            }
            if (fail)
                ans = "IMPOSSIBLE";
            else {
                ans = new String(ret);
            }
            System.out.printf("Case #%d: %s%n", i + 1, ans);
            
        }
        
        
    }
        
    public static class Activity implements Comparable<Activity> {
        int begin;
        int end;
        int count;
        static int counter = 0;
        
        public Activity (String input) {
            StringTokenizer st = new StringTokenizer(input);
            begin = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
        }

        @Override
        public int compareTo(Activity o) {
            if (this.begin - o.begin != 0) {
                return this.begin - o.begin;
            } else if (this.end - o.end != 0) {
                return this.end - o.end;
            } else 
                return this.count - o.count;
        }
    }
    
}
