import java.util.*;
import java.lang.*;
import java.io.*;

class Activity implements Comparable<Activity> {
    Integer id;
    Integer time;
    Boolean isStart;

    Activity(Integer id, Integer time, Boolean isStart) {
        this.id = id;
        this.time = time;
        this.isStart = isStart;
    }

    public int compareTo(Activity act) {
        return this.time.compareTo(act.time);
    }
}

class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i=1;i<=t;i++) {
            int n = Integer.parseInt(br.readLine());
            List<Activity> activities = new ArrayList<>();
            char[] ans = new char[n];

            for(int j=0;j<n;j++) {
                String[] times = br.readLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);

                activities.add(new Activity(j, start, true));
                activities.add(new Activity(j, end, false));
            }

            Collections.sort(activities);

            Integer cam = null, jam = null;
            boolean impossible = false;

            for(Activity act : activities) {
                if (act.isStart) {
                    if (cam != null && jam != null) {
                        impossible = true;
                        break;
                    } else if (cam == null) {
                        cam = act.id;
                        ans[act.id] = 'C';
                    } else if (jam == null) {
                        jam = act.id;
                        ans[act.id] = 'J';
                    }
                } else {

                    if(act.id.equals(cam)) {
                        cam = null;
                    } else if (act.id.equals(jam)) {
                        jam = null;
                    }
                }
            }

            if (impossible) {
                System.out.println("Case #"+i+": IMPOSSIBLE");
            } else {
                System.out.println("Case #"+i+": "+new String(ans));
            }
        }

    }
}