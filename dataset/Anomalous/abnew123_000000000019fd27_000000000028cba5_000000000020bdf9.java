import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            StringBuilder answer = new StringBuilder();
            List<Event> cameronSchedule = new ArrayList<>();
            List<Event> jamieSchedule = new ArrayList<>();
            
            boolean cameronConflict, jamieConflict;
            
            for (int j = 0; j < n; j++) {
                Event event = new Event(scanner.nextInt(), scanner.nextInt());
                cameronConflict = false;
                jamieConflict = false;
                
                for (Event e : cameronSchedule) {
                    if (e.overlapsWith(event)) {
                        cameronConflict = true;
                        break;
                    }
                }
                
                for (Event e : jamieSchedule) {
                    if (e.overlapsWith(event)) {
                        jamieConflict = true;
                        break;
                    }
                }
                
                if (cameronConflict && jamieConflict) {
                    answer = new StringBuilder("IMPOSSIBLE");
                    break;
                }
                
                if (!cameronConflict) {
                    cameronSchedule.add(event);
                    answer.append("C");
                } else {
                    jamieSchedule.add(event);
                    answer.append("J");
                }
            }
            
            System.out.println("Case #" + i + ": " + answer);
        }
        
        scanner.close();
    }
}

class Event {
    private int start;
    private int end;
    
    public Event(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    public boolean overlapsWith(Event other) {
        return !(this.end <= other.start || this.start >= other.end);
    }
}