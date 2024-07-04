import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt(); // number of events
            Event[] events = new Event[n];
            
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                events[i] = new Event(start, end, i);
            }
            
            Arrays.sort(events, Comparator.comparingInt(e -> e.start));
            
            int cEnd = 0, jEnd = 0;
            char[] schedule = new char[n];
            boolean possible = true;
            
            for (Event event : events) {
                if (event.start >= cEnd) {
                    schedule[event.index] = 'C';
                    cEnd = event.end;
                } else if (event.start >= jEnd) {
                    schedule[event.index] = 'J';
                    jEnd = event.end;
                } else {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                System.out.println("Case #" + (t + 1) + ": " + new String(schedule));
            } else {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            }
        }
    }
}

class Event {
    int start;
    int end;
    int index;
    
    Event(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}