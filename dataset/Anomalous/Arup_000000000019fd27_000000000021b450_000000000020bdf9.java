import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            Event[] events = new Event[n];
            
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                events[i] = new Event(start, end, i);
            }
            
            Arrays.sort(events);
            char[] result = new char[n];
            boolean possible = true;
            int cEnd = 0, jEnd = 0;
            
            for (Event event : events) {
                if (event.start >= cEnd) {
                    result[event.id] = 'C';
                    cEnd = event.end;
                } else if (event.start >= jEnd) {
                    result[event.id] = 'J';
                    jEnd = event.end;
                } else {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                System.out.println("Case #" + caseNumber + ": " + new String(result));
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
}

class Event implements Comparable<Event> {
    int start;
    int end;
    int id;
    
    public Event(int start, int end, int id) {
        this.start = start;
        this.end = end;
        this.id = id;
    }
    
    @Override
    public int compareTo(Event other) {
        if (this.end != other.end) {
            return this.end - other.end;
        }
        return this.id - other.id;
    }
}