import java.util.*;
import java.io.*;
public class Solution {
    
    static class TimePeriod implements Comparable {
        
        private int startTime;
        private int endTime;
        private int index;
        
        public TimePeriod(int startTime,int endTime, int index) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.index = index;
        }
        
        public int getStartTime() {
            return this.startTime;
        }
        
        public int getEndTime() {
            return this.endTime;
        }
        
        public int getIndex() {
            return this.index;
        }
        
        @Override
        public int compareTo(Object comparingTimePeriod) {
            int comparingStartTime = ((TimePeriod)comparingTimePeriod).getStartTime();
            int comparingEndTime = ((TimePeriod)comparingTimePeriod).getEndTime();
            /* For Ascending order*/
            if(this.startTime == comparingStartTime) {
                return this.endTime - comparingEndTime;
            }
            return this.startTime - comparingStartTime;
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int ti = 1; ti <= t; ++ti) {
            String result = "";
            int n = in.nextInt();
            ArrayList<TimePeriod> timePeriods = new ArrayList();
            for(int i = 0; i < n; i++) {
                int startTime = in.nextInt();
                int endTime = in.nextInt();
                TimePeriod timePeriod = new TimePeriod(startTime, endTime, i);
                timePeriods.add(timePeriod);
            }
            Collections.sort(timePeriods);
            String activistsForActivities[] = new String[n];
            /*
            for(int i = 0; i < n; i++) {
                TimePeriod timePeriod = timePeriods.get(i);
                System.out.println(":::" +
                timePeriod.getStartTime() + " ,"
                + timePeriod.getEndTime());
            }
            */
            int firstWorkerScheduledEndTime = 0;
            int secondWorkerScheduledEndTime = 0;
            boolean isPossible = true;
            for(int i = 0; i < n; i++) {
                TimePeriod timePeriod = timePeriods.get(i);
                int startTime = timePeriod.getStartTime();
                int endTime = timePeriod.getEndTime();
                int index = timePeriod.getIndex();
                if(firstWorkerScheduledEndTime <= startTime) {
                    firstWorkerScheduledEndTime = 0;
                }
                if(secondWorkerScheduledEndTime <= startTime) {
                    secondWorkerScheduledEndTime = 0;
                }
                if(firstWorkerScheduledEndTime == 0) {
                    activistsForActivities[index] = "C";
                    firstWorkerScheduledEndTime = endTime;
                } else if(secondWorkerScheduledEndTime == 0) {
                    activistsForActivities[index] = "J";
                    secondWorkerScheduledEndTime = endTime;
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            if(isPossible) {
                for(int i = 0; i < n; i++) {
                    result += activistsForActivities[i];
                    //System.out.println("result:"+i+"::" + result);
                }
                
            } else {
                result = "IMPOSSIBLE";
            }
            
            System.out.println("Case #" + ti + ": " + result);
        }
    }
}