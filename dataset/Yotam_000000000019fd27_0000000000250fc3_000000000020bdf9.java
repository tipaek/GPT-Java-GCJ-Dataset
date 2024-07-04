import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

   static class Interval{
        int start;
        int end;
        int startIndex;
        int endIndex;
        int originalIndex;
        boolean done;

        public Interval(int start, int end,int originalIndex) {
            this.start = start;
            this.end = end;
            this.originalIndex = originalIndex;
            this.done=false;
        }

       @Override
       public boolean equals(Object o) {
           if (this == o) return true;
           if (o == null || getClass() != o.getClass()) return false;
           Interval interval = (Interval) o;
           return start == interval.start &&
                   end == interval.end &&
                   startIndex == interval.startIndex &&
                   endIndex == interval.endIndex &&
                   originalIndex == interval.originalIndex &&
                   done == interval.done;
       }

       @Override
       public int hashCode() {
           return Objects.hash(start, end, startIndex, endIndex, originalIndex, done);
       }
   }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scanner.nextInt();
        for(int i=0;i<tests;i++){
            int N= scanner.nextInt();
            Interval[] startTime = new Interval[N];
            Interval[] endTime = new Interval[N];
            for(int j=0;j<N;j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Interval interval = new Interval(start, end, j);
                startTime[j] = interval;
                endTime[j] = interval;
            }
            Arrays.sort(startTime, new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    return Integer.compare(o1.start,o2.start);
                }
            });
            Arrays.sort(endTime, new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    return Integer.compare(o1.end,o2.end);
                }
            });
            StringBuilder result = new StringBuilder();
            boolean done =false;
            List<Interval> openIntervals = new ArrayList();
            List<Interval> removeIntervals = new ArrayList();
            for(int j=0;j<N;j++) {
                for(Interval interval : openIntervals){
                    if(interval.end<=startTime[j].start){
                        removeIntervals.add(interval);
                    }
                }
                openIntervals.removeAll(removeIntervals);
                if(openIntervals.size()==2){
                    System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
                    done=true;
                    break;
                }
                openIntervals.add(startTime[j]);
            }
            if(done){
                continue;
            }
            for(int j=0;j<N;j++) {
               startTime[j].startIndex=j;
               endTime[j].endIndex=j;
               result.append(" ");
            }

            for(int j=0;j<N;j++) {
                if(startTime[j].done)
                    continue;
                result.setCharAt(startTime[j].originalIndex,'C');
                int skip=0;
                for(int k=j+1;k<N;k++){
                    if(startTime[k].start>=startTime[j].end)
                        break;
                    result.setCharAt(startTime[k].originalIndex,'J');
                    startTime[k].done=true;
                    skip++;
                }
                j+=skip;
            }
            System.out.println("Case #"+(i+1)+": "+result.toString());
        }


    }
}
