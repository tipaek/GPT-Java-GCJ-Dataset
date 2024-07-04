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
                events.add(new Event(start, 's', i));
                events.add(new Event(end, 'e', i));
            }

            Collections.sort(events, new EventComparator());

            char[] assignments = new char[n];
            int cameron = -1, jamie = -1;
            boolean impossible = false;

            for (Event event : events) {
                if (event.type == 's') {
                    if (cameron != -1 && jamie != -1) {
                        impossible = true;
                        break;
                    } else if (jamie == -1) {
                        jamie = event.index;
                        assignments[jamie] = 'J';
                    } else {
                        cameron = event.index;
                        assignments[cameron] = 'C';
                    }
                } else {
                    if (event.index == cameron) {
                        cameron = -1;
                    } else {
                        jamie = -1;
                    }
                }
            }

            if (impossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + new String(assignments));
            }
        }
    }
}

class Event {
    int time;
    char type;
    int index;

    Event(int time, char type, int index) {
        this.time = time;
        this.type = type;
        this.index = index;
    }
}

class EventComparator implements Comparator<Event> {
    @Override
    public int compare(Event a, Event b) {
        if (a.time == b.time) {
            return Character.compare(a.type, b.type);
        }
        return Integer.compare(a.time, b.time);
    }
}