import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.channels.SelectableChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i=1; i <= t; i++) {

            System.out.print("Case #" + i + ": ");


            int activities = in.nextInt();


            StringBuffer sb = new StringBuffer();

            List<Schedule> schedulesC = new ArrayList<>();
            List<Schedule> schedulesJ = new ArrayList<>();

            for (int j=0;j<activities;j++) {
                Schedule currentSchedule = new Schedule(in.nextInt(), in.nextInt());
                if (isAvailable(schedulesC, currentSchedule)) {
                    schedulesC.add(currentSchedule);
                    sb.append("C");
                } else if(isAvailable(schedulesJ, currentSchedule)) {
                    schedulesJ.add(currentSchedule);
                    sb.append("J");
                } else {
                    sb = new StringBuffer("IMPOSSIBLE");
                    break;
                }
            }




            System.out.println(sb.toString());
        }

    }

    public static boolean isAvailable(List<Schedule> schedules, Schedule schedule) {
        for (Schedule s : schedules) {
            if (schedule.start < s.end && schedule.start >= s.start || schedule.end < s.end && schedule.end >= s.start) {
                return false;
            }
        }
        return true;
    }


}

class Schedule {
    int start;
    int end;

    public Schedule(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
