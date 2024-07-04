import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Solution solution = new Solution();
        
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            TimeSlot[] timeSlots = new TimeSlot[n];
            
            for (int j = 0; j < n; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                timeSlots[j] = solution.new TimeSlot(start, end);
            }
            
            Arrays.sort(timeSlots);
            TimeSlot cameron = solution.new TimeSlot(0, 0);
            TimeSlot james = solution.new TimeSlot(0, 0);
            StringBuilder schedule = new StringBuilder();
            
            cameron = timeSlots[0];
            schedule.append("C");
            
            boolean possible = true;
            
            for (int j = 1; j < n; j++) {
                if (timeSlots[j].start >= cameron.end) {
                    schedule.append("C");
                    cameron = timeSlots[j];
                } else if (timeSlots[j].start >= james.end) {
                    schedule.append("J");
                    james = timeSlots[j];
                } else {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                System.out.println("Case #" + (i + 1) + ": " + schedule.toString());
            }
        }
        
        sc.close();
    }
    
    public class TimeSlot implements Comparable<TimeSlot> {
        int start;
        int end;
        
        public TimeSlot(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(TimeSlot other) {
            return Integer.compare(this.start, other.start);
        }
    }
}