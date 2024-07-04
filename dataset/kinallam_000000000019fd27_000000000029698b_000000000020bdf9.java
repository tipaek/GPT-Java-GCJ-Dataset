import java.util.*;

public class Solution {

    static class Interval {
        int start;
        int end;
        int task;
        String output;
    }

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int testcases = in.nextInt();
        for (int m =0; m<testcases;m++) {
            int length = in.nextInt();
            List<Interval> intervals = new ArrayList<>();

            for (int i=0; i< length; i++) {
                Interval interv = new Interval();
                interv.start = in.nextInt();
                interv.end = in.nextInt();
                interv.task = i;
                intervals.add(interv);

            }

            getSchedule(intervals, m+1);
        }

    }

    public static void getSchedule(List<Interval> nums, int t) {
        Integer jack = null;
        Integer cam  = null;
        boolean isPrint = false;

        Collections.sort(nums, (a,b) -> a.start - b.start);

        for (Interval a : nums) {
            if (jack == null) {
                jack = a.end;
                a.output = "J";
                continue;
            } else if (jack <= a.start) {
                jack = a.end;
                a.output = "J";
                continue;
            }  else if (cam == null) {
                cam = a.end;
                a.output = "C";
                continue;
            } else if (cam <= a.start) {
                cam = a.end;
                a.output = "C";
                continue;
            } else {
                String output = "IMPOSSIBLE";
                isPrint = true;
                System.out.println("Case #" + t + ": " + output);
                break;
            }
        }

        if (!isPrint) {
            Collections.sort(nums, (a,b) -> a.task - b.task);
            String out  = "";
            for (Interval a : nums) {
                out = out + a.output;
            }
            System.out.println("Case #" + t + ": " + out);

        }


    }
}
