
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            Activity[] activities = new Activity[N];
            for (int j = 0; j < N; j++) {
                String[] ip = br.readLine().split(" ");
                activities[j] = new Activity(Integer.parseInt(ip[0]), Integer.parseInt(ip[1]));
            }

            Arrays.sort(activities, new SortByStartTime());

            //store end time for J and C
            // 0 -> J
            //1 -> C
            StringBuilder sb = new StringBuilder("");

            boolean flag = true;
            Availtime availtime = new Availtime();
            for (int j = 0; j < N; j++) {

                //check if C is available

                if (activities[j].start_time >= availtime.C) {
                    sb.append('C');
                    availtime.C = activities[j].end_time;
                }
                //check if J is available

                else if (activities[j].start_time >= availtime.J) {
                    sb.append('J');
                    availtime.J = activities[j].end_time;
                } else {
                    System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Case #" + i + ": " + sb.toString());

            }


        }
    }
}

class Activity {
    int start_time;
    int end_time;


    Activity(int start_time, int end_time) {
        this.start_time = start_time;
        this.end_time = end_time;
    }
}

class SortByStartTime implements Comparator<Activity> {
    public int compare(Activity a, Activity b) {
        return (a.start_time) - (b.start_time);
    }
}

class Availtime {
    int J;
    int C;
}