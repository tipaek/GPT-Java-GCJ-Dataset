
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int q = 0; q < t; q++) {
            int n = in.nextInt();

            ArrayList<TimeLine> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int s = in.nextInt();
                int e = in.nextInt();
                TimeLine tl = new TimeLine(s, e,i);
                list.add(tl);
            }
        Job j = new Job(list);
            System.out.println("Case #"+(q+1)+": "+j.result);
        }
    }

    public static  class Job{

        public final String result;

        public Job(List<TimeLine> list) {
             result = doJob(list);
        }

        private String doJob(List<TimeLine> list) {
            List<TimeLine> sorted = list.stream().sorted(Comparator.comparing(TimeLine::getS)).collect(Collectors.toList());

            int jFreeFrom = -1;
            int cFreeFrom = -1;
            for (TimeLine timeLine : sorted) {
                if (timeLine.s >= jFreeFrom){
                    timeLine.assignedTo = "J";
                    jFreeFrom = timeLine.e;
                    continue;
                }
                if (timeLine.s >= cFreeFrom){
                    timeLine.assignedTo = "C";
                    cFreeFrom = timeLine.e;
                    continue;
                }
                return "IMPOSSIBLE";
            }

            return String.join("",list.stream().map(x -> x.assignedTo).collect(Collectors.toList()));
        }
    }

    public static class TimeLine {
        public final int s;
        public final int e;
        public final int i;

        public TimeLine(int s, int e, int i) {
            this.s = s;
            this.e = e;
            this.i = i;
        }

        public String assignedTo;

        public int getS() {
            return s;
        }

        @Override
        public String toString() {
            return "TimeLine{" +
                    "s=" + s +
                    ", e=" + e +
                    ", i=" + i +
                    ", assignedTo='" + assignedTo + '\'' +
                    '}';
        }
    }
}
