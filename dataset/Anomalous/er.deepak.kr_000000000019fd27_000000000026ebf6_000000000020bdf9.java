import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            List<Event> events = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                events.add(new Event(start, 's'));
                events.add(new Event(end, 'e'));
            }

            events.sort(Comparator.comparingInt(Event::getTime));

            String result = "";
            int ongoingActivities = 0;

            for (Event event : events) {
                if (event.getType() == 's') {
                    ongoingActivities++;
                    if (ongoingActivities > 2) {
                        result = "IMPOSSIBLE";
                        break;
                    } else if (ongoingActivities == 1) {
                        result += "C";
                    } else {
                        result += "J";
                    }
                } else {
                    ongoingActivities--;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}

class Event {
    private final int time;
    private final char type;

    public Event(int time, char type) {
        this.time = time;
        this.type = type;
    }

    public int getTime() {
        return time;
    }

    public char getType() {
        return type;
    }
}