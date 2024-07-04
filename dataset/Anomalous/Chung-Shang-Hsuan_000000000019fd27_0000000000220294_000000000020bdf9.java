import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private int n;
    private Event[] events;

    public Solution(int n, Scanner sc) {
        this.n = n;
        events = new Event[n];
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            events[i] = new Event(start, end, i);
        }
        Arrays.sort(events, (o1, o2) -> Integer.compare(o1.startTime, o2.startTime));
    }

    public String calculate() {
        int count = 0;
        int currentTimeC = 0;
        int currentTimeJ = 0;

        for (Event event : events) {
            if (event.startTime >= currentTimeC) {
                event.usedBy = 'C';
                currentTimeC = event.endTime;
                count++;
            } else if (event.startTime >= currentTimeJ) {
                event.usedBy = 'J';
                currentTimeJ = event.endTime;
                count++;
            }
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
}

class Event {
    int startTime;
    int endTime;
    int order;
    char usedBy;

    public Event(int startTime, int endTime, int order) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.order = order;
        this.usedBy = ' ';
    }
}