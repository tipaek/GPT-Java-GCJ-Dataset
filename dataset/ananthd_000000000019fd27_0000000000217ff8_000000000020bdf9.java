import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int[][] array = new int[100][100];

        for (int i = 1; i <= t; ++i) {
            int num_activities = in.nextInt();
            Time[] times = new Time[num_activities];

            for(int j = 0; j < num_activities; j++){
                int start = in.nextInt();
                int end = in.nextInt();
                times[j] = new Time(start, end);
            }
            List<Time> sortedTimes = new ArrayList(Arrays.asList(times));
            sortedTimes.sort(Comparator.comparingInt(time -> time.start));
            Time time1 = null;
            Time time2 = null;
            boolean impossible = false;
            for (Time time:sortedTimes){
                int start = time.start;
                if (time1 != null){
                    if (time1.end <= start){
                        time1 = null;
                    }
                }
                if (time2 != null){
                    if (time2.end <= start){
                        time2 = null;
                    }
                }
                if (time1 != null && time2 != null){
                    //bad. two activites already here
                    impossible = true;
                    break;
                }
                else if(time1 != null){
                    if (time1.assigned == 'J'){
                        time.assigned = 'C';
                    }
                    else{
                        time.assigned = 'J';
                    }
                    time2 = time;
                }
                else if(time2 != null){
                    if (time2.assigned == 'J'){
                        time.assigned = 'C';
                    }
                    else{
                        time.assigned = 'J';
                    }
                    time1 = time;
                }
                else{
                    time.assigned = 'J';
                    time1 = time;
                }
            }
            if (impossible){
                System.out.println("Case #" + i +": IMPOSSIBLE");
            }
            else{
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < times.length; j++) {
                    builder.append(times[j].assigned);
                }
                System.out.println("Case #" + i +": "+builder.toString());
            }
        }
    }
    private static class Time {
        int start,end;
        char assigned;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
