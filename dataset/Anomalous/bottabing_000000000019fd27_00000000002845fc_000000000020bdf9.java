import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = in.nextInt();
        
        for (int test = 1; test <= testCount; test++) {
            int totalEvents = in.nextInt();
            Event[] events = new Event[totalEvents];
            char[] solution = new char[totalEvents];
            
            for (int event = 0; event < totalEvents; event++) {
                int start = in.nextInt();
                int end = in.nextInt();
                events[event] = new Event(start, end, event);
            }
            
            Arrays.sort(events);

            boolean cameronAvailable = true;
            int cameronEnd = 0;
            boolean jamieAvailable = true;
            int jamieEnd = 0;
            boolean impossible = false;
            
            for (Event event : events) {
                int start = event.getStart();
                int end = event.getEnd();
                int index = event.getIndex();
                
                if (cameronEnd <= start) {
                    cameronAvailable = true;
                }
                if (jamieEnd <= start) {
                    jamieAvailable = true;
                }
                
                if (cameronAvailable) {
                    cameronAvailable = false;
                    cameronEnd = end;
                    solution[index] = 'C';
                } else if (jamieAvailable) {
                    jamieAvailable = false;
                    jamieEnd = end;
                    solution[index] = 'J';
                } else {
                    impossible = true;
                    break;
                }
            }
            
            if (impossible) {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + test + ": " + new String(solution));
            }
        }
        
        in.close();
    }
}

class Event implements Comparable<Event> {
    private int start;
    private int end;
    private int index;

    public Event(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(Event other) {
        return Integer.compare(this.start, other.start);
    }
}