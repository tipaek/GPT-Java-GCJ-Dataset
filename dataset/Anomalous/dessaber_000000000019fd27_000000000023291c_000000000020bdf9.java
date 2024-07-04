import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int n = scanner.nextInt();
            PriorityQueue<Event> events = new PriorityQueue<>();
            
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                events.add(new Event(i, start, EventType.START));
                int end = scanner.nextInt();
                events.add(new Event(i, end, EventType.END));
            }
            
            Map<Integer, Character> assignedTasks = new HashMap<>();
            boolean isPossible = true;
            char lastAssigned = 'J';
            StringBuilder schedule = new StringBuilder();
            
            while (!events.isEmpty()) {
                Event event = events.poll();
                
                if (event.type == EventType.END) {
                    lastAssigned = assignedTasks.remove(event.id);
                } else {
                    if (assignedTasks.size() == 2) {
                        isPossible = false;
                        break;
                    }
                    char currentPerson = assignedTasks.isEmpty() || lastAssigned == 'J' ? 'C' : 'J';
                    assignedTasks.put(event.id, currentPerson);
                    schedule.append(currentPerson);
                    lastAssigned = currentPerson;
                }
            }
            
            if (isPossible) {
                System.out.println("Case #" + caseNum + ": " + schedule);
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }

    private static class Event implements Comparable<Event> {
        int id;
        int time;
        EventType type;

        Event(int id, int time, EventType type) {
            this.id = id;
            this.time = time;
            this.type = type;
        }

        @Override
        public int compareTo(Event other) {
            if (this.time != other.time) {
                return Integer.compare(this.time, other.time);
            }
            return this.type.compareTo(other.type);
        }
    }

    private enum EventType {
        START, END
    }
}