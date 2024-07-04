import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);

        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            StringBuilder result = new StringBuilder("Case #").append(caseIndex).append(": ");

            int numberOfEvents = scanner.nextInt();
            Event[] events = new Event[numberOfEvents];
            char[] assignments = new char[numberOfEvents];
            boolean isPossible = true;

            for (int i = 0; i < numberOfEvents; i++) {
                events[i] = new Event(i, scanner.nextInt(), scanner.nextInt());
            }
            Arrays.sort(events);

            int jFreeTime = 0;
            int cFreeTime = 0;
            for (int i = 0; i < numberOfEvents && isPossible; i++) {
                Event event = events[i];
                if (jFreeTime <= event.startTime) {
                    jFreeTime = event.endTime;
                    assignments[event.id] = 'J';
                } else if (cFreeTime <= event.startTime) {
                    cFreeTime = event.endTime;
                    assignments[event.id] = 'C';
                } else {
                    isPossible = false;
                }
            }
            if (isPossible) {
                result.append(new String(assignments));
            } else {
                result.append("IMPOSSIBLE");
            }

            writer.println(result.toString());
        }

        scanner.close();
        writer.close();
    }

    private static class Event implements Comparable<Event> {
        int id, startTime, endTime;

        Event(int id, int startTime, int endTime) {
            this.id = id;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Event other) {
            return Integer.compare(this.startTime, other.startTime);
        }

        @Override
        public String toString() {
            return "Event #" + id + " starts at " + startTime + " ends at " + endTime;
        }
    }
}