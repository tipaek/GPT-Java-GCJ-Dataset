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
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numberOfActivities = scanner.nextInt();
            String result = "";
            
            List<TimeSlot> timeSlots = new ArrayList<>();
            LinkedList<TimeSlot> cameronSchedule = new LinkedList<>();
            LinkedList<TimeSlot> jamieSchedule = new LinkedList<>();
            
            for (int i = 0; i < numberOfActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                timeSlots.add(new TimeSlot(start, end));
            }
            
            Collections.sort(timeSlots, (slot1, slot2) -> Integer.compare(slot1.startTime, slot2.startTime));
            
            for (TimeSlot slot : timeSlots) {
                if (cameronSchedule.isEmpty() || cameronSchedule.peek().endTime <= slot.startTime) {
                    cameronSchedule.push(slot);
                    result += "C";
                } else if (jamieSchedule.isEmpty() || jamieSchedule.peek().endTime <= slot.startTime) {
                    jamieSchedule.push(slot);
                    result += "J";
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + result);
        }
        
        scanner.close();
    }
    
    public static class TimeSlot {
        public int startTime;
        public int endTime;
        
        public TimeSlot(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}