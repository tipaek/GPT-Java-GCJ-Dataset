import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    
    static class Event implements Comparable<Event> {
        int time;
        int id;
        
        public Event(int time, int id) {
            this.time = time;
            this.id = id;
        }
        
        @Override
        public int compareTo(Event other) {
            if (this.time != other.time) {
                return Integer.compare(this.time, other.time);
            }
            return Integer.compare(this.id, other.id);
        }
        
        @Override
        public String toString() {
            return String.format("(%d, %d)", this.time, this.id);
        }
    }
    
    static ArrayList<Event> events;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            events = new ArrayList<>();
            
            for (int i = 1; i <= n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                events.add(new Event(start, i));
                events.add(new Event(end, -i));
            }
            
            Collections.sort(events);
            LinkedList<Integer> available = new LinkedList<>();
            available.add(0);
            available.add(1);
            int[] assignments = new int[n + 1];
            boolean impossible = false;
            
            for (Event event : events) {
                if (event.id < 0) {
                    available.add(assignments[-event.id]);
                } else {
                    if (available.isEmpty()) {
                        impossible = true;
                        break;
                    }
                    int assigned = available.pop();
                    assignments[event.id] = assigned;
                }
            }
            
            System.out.print("Case #" + t + ": ");
            if (impossible) {
                System.out.print("IMPOSSIBLE");
            } else {
                for (int i = 1; i <= n; i++) {
                    System.out.print(assignments[i] == 0 ? 'C' : 'J');
                }
            }
            System.out.println();
        }
        
        scanner.close();
    }
}