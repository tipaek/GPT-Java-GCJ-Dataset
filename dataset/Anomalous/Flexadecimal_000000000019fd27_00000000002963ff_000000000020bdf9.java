import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            PriorityQueue<Event> events = new PriorityQueue<>();
            Event[] tasks = new Event[n];
            
            for (int i = 0; i < n; i++) {
                Event start = new Event(true, scanner.nextInt(), null, null);
                Event end = new Event(false, scanner.nextInt(), null, null);
                start.pair = end;
                events.add(start);
                events.add(end);
                tasks[i] = start;
            }
            
            boolean isImpossible = false;
            boolean isCWorking = false;
            boolean isJWorking = false;
            
            while (!events.isEmpty()) {
                Event event = events.poll();
                if (event.isStart) {
                    if (!isCWorking) {
                        event.pair.assignedTo = "C";
                        isCWorking = true;
                    } else if (!isJWorking) {
                        event.pair.assignedTo = "J";
                        isJWorking = true;
                    } else {
                        isImpossible = true;
                        break;
                    }
                } else {
                    if ("C".equals(event.assignedTo)) {
                        isCWorking = false;
                    } else if ("J".equals(event.assignedTo)) {
                        isJWorking = false;
                    }
                }
            }
            
            System.out.print("Case #" + caseNum + ": ");
            if (!isImpossible) {
                StringBuilder result = new StringBuilder();
                for (Event task : tasks) {
                    result.append(task.pair.assignedTo);
                }
                System.out.println(result.toString());
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }

    static class Event implements Comparable<Event> {
        boolean isStart;
        int time;
        Event pair;
        String assignedTo;

        public Event(boolean isStart, int time, Event pair, String assignedTo) {
            this.isStart = isStart;
            this.time = time;
            this.pair = pair;
            this.assignedTo = assignedTo;
        }

        @Override
        public int compareTo(Event other) {
            if (this.time == other.time) {
                return Boolean.compare(other.isStart, this.isStart);
            }
            return Integer.compare(this.time, other.time);
        }
    }
}