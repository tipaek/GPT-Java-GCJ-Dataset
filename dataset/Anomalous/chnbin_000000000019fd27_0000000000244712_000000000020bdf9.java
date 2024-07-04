import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numActivities = scanner.nextInt();
            String result = "";
            
            List<TimeSlot> timeSlots = new ArrayList<>();
            LinkedList<TimeSlot> cameronSchedule = new LinkedList<>();
            LinkedList<TimeSlot> jamieSchedule = new LinkedList<>();
            char[] assignments = new char[numActivities];
            
            for (int i = 0; i < numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                timeSlots.add(new TimeSlot(start, end, i));
            }
            
            Collections.sort(timeSlots, (a, b) -> Integer.compare(a.startTime, b.startTime));
            
            for (TimeSlot slot : timeSlots) {
                if (cameronSchedule.isEmpty() || cameronSchedule.peek().endTime <= slot.startTime) {
                    cameronSchedule.push(slot);
                    assignments[slot.index] = 'C';
                } else if (jamieSchedule.isEmpty() || jamieSchedule.peek().endTime <= slot.startTime) {
                    jamieSchedule.push(slot);
                    assignments[slot.index] = 'J';
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }
            
            if (!result.equals("IMPOSSIBLE")) {
                result = new String(assignments);
            }
            
            System.out.println("Case #" + testCase + ": " + result);
        }
        scanner.close();
    }
    
    public static class TimeSlot {
        public int startTime;
        public int endTime;
        public int index;
        
        public TimeSlot(int startTime, int endTime, int index) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.index = index;
        }
    }
}