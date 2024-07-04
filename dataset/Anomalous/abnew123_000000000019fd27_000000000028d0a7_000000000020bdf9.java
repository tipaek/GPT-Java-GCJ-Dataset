import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            System.err.println("hi?");
            for (int i = 1; i <= testCases; ++i) {
                int n = scanner.nextInt();
                List<Event> cameronEvents = new ArrayList<>();
                List<Event> jamieEvents = new ArrayList<>();
                StringBuilder schedule = new StringBuilder();
                boolean isImpossible = false;

                for (int j = 0; j < n; j++) {
                    Event newEvent = new Event(scanner.nextInt(), scanner.nextInt());
                    boolean cameronConflict = cameronEvents.stream().anyMatch(e -> e.overlaps(newEvent));
                    boolean jamieConflict = jamieEvents.stream().anyMatch(e -> e.overlaps(newEvent));

                    if (cameronConflict && jamieConflict) {
                        schedule = new StringBuilder("IMPOSSIBLE");
                        isImpossible = true;
                        break;
                    }

                    if (!cameronConflict) {
                        cameronEvents.add(newEvent);
                        schedule.append("C");
                    } else {
                        jamieEvents.add(newEvent);
                        schedule.append("J");
                    }
                }

                System.out.println("Case #" + i + ": " + schedule.toString());
            }
        }
    }
}

class Event {
    private final int start;
    private final int end;

    public Event(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean overlaps(Event other) {
        return !(this.start >= other.end || this.end <= other.start);
    }
}