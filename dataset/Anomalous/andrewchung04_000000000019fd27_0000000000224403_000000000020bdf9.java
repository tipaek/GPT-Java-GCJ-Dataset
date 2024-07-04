import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activities = scanner.nextInt();
            ArrayList<Event> events = new ArrayList<>();

            for (int activity = 0; activity < activities; activity++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                events.add(new Event(start, EventType.START, activity));
                events.add(new Event(end, EventType.END, activity));
            }

            Collections.sort(events);

            int cameronCount = 0;
            int jamieCount = 0;
            boolean[] isJamie = new boolean[activities];
            boolean isImpossible = false;

            for (Event event : events) {
                if (event.type == EventType.START) {
                    if (cameronCount == 0 && jamieCount == 0) {
                        cameronCount++;
                    } else if (cameronCount == 1 && jamieCount == 0) {
                        isJamie[event.activityIndex] = true;
                        jamieCount++;
                    } else if (cameronCount == 0 && jamieCount == 1) {
                        cameronCount++;
                    } else {
                        System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                        isImpossible = true;
                        break;
                    }
                } else {
                    if (isJamie[event.activityIndex]) {
                        jamieCount--;
                    } else {
                        cameronCount--;
                    }
                }
            }

            if (!isImpossible) {
                StringBuilder schedule = new StringBuilder();
                for (boolean jamie : isJamie) {
                    schedule.append(jamie ? "J" : "C");
                }
                System.out.println("Case #" + caseNumber + ": " + schedule);
            }
        }
    }
}

class Event implements Comparable<Event> {
    public int time;
    public EventType type;
    public int activityIndex;

    public Event(int time, EventType type, int activityIndex) {
        this.time = time;
        this.type = type;
        this.activityIndex = activityIndex;
    }

    @Override
    public int compareTo(Event other) {
        if (this.time == other.time) {
            return this.type.compareTo(other.type);
        }
        return this.time - other.time;
    }
}

enum EventType {
    START, END
}