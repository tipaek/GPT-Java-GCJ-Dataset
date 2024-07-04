import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tests = scan.nextInt();
        for (int test = 1; test <= tests; test++) {
            int eventCount = scan.nextInt();
            PriorityQueue<EventTime> events = new PriorityQueue<>();
            List<EventTime> eventsRetainOrder = new ArrayList<>();
            for (int e = 0; e < eventCount; e++) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                EventTime eventTime = new EventTime(start, end);
                events.add(eventTime);
                eventsRetainOrder.add(eventTime);
            }

            int cameronBusyTo = -1;
            int jamieBusyTo = -1;
            boolean NO = false;
            while (!events.isEmpty()) {
                EventTime eventTime = events.remove();
//                System.out.println(eventTime);
                if (cameronBusyTo <= eventTime.startTime) {
//                    System.out.println("Given to cameron, busy to " + cameronBusyTo);
                    cameronBusyTo = eventTime.endTime;
//                    System.out.println("Cameron busy to " + cameronBusyTo);
                    eventTime.person = 'C';
                } else if (jamieBusyTo <= eventTime.startTime) {
//                    System.out.println("Given to jamie, busy to " + jamieBusyTo);
                    jamieBusyTo = eventTime.endTime;
//                    System.out.println("Jamie busy to " + jamieBusyTo);
                    eventTime.person = 'J';
                } else {
                    NO = true;
                    break;
                }
            }

            System.out.print("Case #" + test + ": ");
            if (NO)
                System.out.print("IMPOSSIBLE");
            else
                for (EventTime e : eventsRetainOrder)
                    System.out.print(e.person);
            System.out.println();
        }
    }
}

class EventTime implements Comparable<EventTime> {
    Integer startTime, endTime;
    char person;

    EventTime(int st, int et) {
        startTime = st;
        endTime = et;
    }

    public int compareTo(EventTime o) {
        return startTime.compareTo(o.startTime);
    }

    public String toString() {
        return "EventTime{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
