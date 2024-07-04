import java.util.*;

public class Solution {
    static int caseCount = 1;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();

        for (int i = 0; i < count; i++) {
            solve(scan);
        }
    }
    public static void solve(Scanner scan) {
        int activities = scan.nextInt();
        List<Event> eventList = new ArrayList<>();

        boolean sadTimes = false;

        int cameronLast = Integer.MIN_VALUE;
        int jaimeLast = Integer.MIN_VALUE;

        for (int i = 0; i < activities; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();

            eventList.add(new Event(i, start, end));
        }

        eventList.sort(Event.comparator);

        for (int i = 0; i < eventList.size(); i++) {
            if (cameronLast <= eventList.get(i).start) {
                cameronLast = eventList.get(i).end;
                eventList.get(i).person = 'C';
            } else if (jaimeLast <= eventList.get(i).start) {
                jaimeLast = eventList.get(i).end;
                eventList.get(i).person = 'J';
            } else {
                sadTimes = true;
                break;
            }
        }
        if (sadTimes) {
            System.out.println("Case #" + caseCount + ": IMPOSSIBLE");
        } else {
            StringBuilder sb = new StringBuilder();
            Collections.sort(eventList);
            for (Event event : eventList) {
                sb.append(event.person);
            }
            System.out.println("Case #" + caseCount + ": " + sb.toString());
        }
        caseCount++;
    }

    static class Event implements Comparable<Event> {
        Integer index;
        int start;
        int end;
        Character person;

        public Event(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        // sort by event index
        @Override
        public int compareTo(Event o) {
            return this.index.compareTo(o.index);
        }

        // sort by start time
        public static Comparator<Event> comparator = (e1, e2) -> {
            Integer size1 = e1.start;
            Integer size2 = e2.start;
            return size1.compareTo(size2);
        };
    }
}
