import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCases = in.nextInt(); // num test cases
    int testCaseCounter = 0;
    while(testCaseCounter < testCases){
        int inputSize = in.nextInt();
        testCaseCounter++;
        int[][] input = new int[inputSize][2];
        for (int i = 0; i < inputSize; ++i) {
            for (int j = 0; j < 2; ++j) {
                String time1 = in.next();
                input[i][j] = Integer.parseInt(time1);
            }
        }
        String result = schedule(input);
        System.out.println("Case #" + testCaseCounter + ": "+result);
        
    }
    }
    
    public static String schedule(int[][] times){
        HashMap<Integer, Set<Integer>> timeToAssociatedEvent = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            int[] startAndEndTimes = times[i];
            for (Integer startOrEndTime : startAndEndTimes) {
                Set<Integer> associatedEvents =timeToAssociatedEvent.get(startOrEndTime);
                if(associatedEvents == null){
                    Set<Integer> newAssociatedEvents = new HashSet<>();
                    newAssociatedEvents.add(i);
                    timeToAssociatedEvent.put(startOrEndTime,newAssociatedEvents);
                }else{
                    associatedEvents.add(i);
                }
            }

        }
        PriorityQueue<ScheduleObj> queue = new  PriorityQueue<>(new Comparator<ScheduleObj>() {
            @Override
            public int compare(ScheduleObj o1, ScheduleObj o2) {
                return Double.compare(o1.time,o2.time);
            }
        });

        for (Integer eventTime : timeToAssociatedEvent.keySet()) {
            ScheduleObj e = new ScheduleObj(eventTime, timeToAssociatedEvent.get(eventTime));
            queue.offer(e);
        }
        String[] ordered = new String[times.length];
        int c_currEvent= -1;
        int j_currEvent = -1;
        while(!queue.isEmpty()){
            ScheduleObj obj = queue.poll();

            if(obj.eventsAssociated.remove(c_currEvent)){
                    c_currEvent = -1;

            }else if(obj.eventsAssociated.remove(j_currEvent)){
                    j_currEvent = -1;

            } else if(c_currEvent == -1){
                int nextEvent = obj.eventsAssociated.iterator().next();
                obj.eventsAssociated.remove(nextEvent);
                c_currEvent = nextEvent;
                ordered[nextEvent] = "C";
            } else if(j_currEvent == -1){
                int nextEvent = obj.eventsAssociated.iterator().next();
                obj.eventsAssociated.remove(nextEvent);
                j_currEvent = nextEvent;
                ordered[nextEvent] = "J";
            } else{
                return "IMPOSSIBLE";

            }

            if(!obj.eventsAssociated.isEmpty()){
                queue.offer(obj);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String str :
                ordered) {
            sb.append(str);
        }
        return sb.toString();
    }
    public static class ScheduleObj{

        private Set<Integer> eventsAssociated;
        private int time;


        public ScheduleObj(Integer eventTime, Set<Integer> integers) {
            eventsAssociated = integers;
            time=eventTime;
        }
    }
}