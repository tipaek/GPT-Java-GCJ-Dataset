import java.util.*;

public class Solution {

    private int n;
    private Event[] events;

    public Solution(int n, Scanner sc) {
        this.n = n;
        this.events = new Event[n];
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            events[i] = new Event(start, end, i);
        }
        Arrays.sort(events, Comparator.comparingInt(e -> e.endtime));
    }

    public String calculate() {
        int count = 0;
        int position = 0;
        int currentTime = 0;

        while (position < n) {
            Event event = events[position];
            if (event.starttime >= currentTime) {
                event.used = true;
                event.usedBy = 'C';
                currentTime = event.endtime;
                count++;
            }
            position++;
        }

        position = 0;
        currentTime = 0;

        while (position < n) {
            Event event = events[position];
            if (!event.used && event.starttime >= currentTime) {
                event.usedBy = 'J';
                currentTime = event.endtime;
                count++;
            }
            position++;
        }

        if (count < n) return "IMPOSSIBLE";

        char[] result = new char[n];
        for (Event event : events) {
            result[event.order] = event.usedBy;
        }

        return new String(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int c = 1; c <= cases; c++) {
            int numEvents = sc.nextInt();
            Solution solution = new Solution(numEvents, sc);
            System.out.println("Case #" + c + ": " + solution.calculate());
        }
    }

    private static class Event {
        int starttime;
        int endtime;
        int order;
        boolean used;
        char usedBy;

        Event(int starttime, int endtime, int order) {
            this.starttime = starttime;
            this.endtime = endtime;
            this.order = order;
            this.used = false;
            this.usedBy = ' ';
        }
    }
}