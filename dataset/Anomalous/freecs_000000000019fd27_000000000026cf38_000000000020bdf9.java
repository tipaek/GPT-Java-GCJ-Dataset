import java.util.*;
import java.io.*;

public class Solution {

    public void solve(int testCaseNumber, Scanner scanner) {
        int n = scanner.nextInt();
        Event[] events = new Event[2 * n];

        for (int i = 0; i < n; i++) {
            events[i] = new Event(scanner.nextInt(), true, i);
            events[n + i] = new Event(scanner.nextInt(), false, i);
        }

        Arrays.sort(events, (e1, e2) -> {
            if (e1.time != e2.time) {
                return Integer.compare(e1.time, e2.time);
            }
            return Boolean.compare(e2.start, e1.start);
        });

        boolean camAvailable = true;
        boolean jamAvailable = true;
        boolean isPossible = true;
        char[] result = new char[n];

        for (Event event : events) {
            if (event.start) {
                if (camAvailable) {
                    camAvailable = false;
                    result[event.index] = 'C';
                } else if (jamAvailable) {
                    jamAvailable = false;
                    result[event.index] = 'J';
                } else {
                    isPossible = false;
                    break;
                }
            } else {
                if (result[event.index] == 'C') {
                    camAvailable = true;
                } else {
                    jamAvailable = true;
                }
            }
        }

        String output = isPossible ? new String(result) : "IMPOSSIBLE";
        System.out.println("Case #" + testCaseNumber + ": " + output);
    }

    public Solution() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            solve(t, scanner);
        }
    }

    public static void main(String[] args) {
        new Solution();
    }
}

class Event {
    public int time;
    public boolean start;
    public int index;

    public Event(int time, boolean start, int index) {
        this.time = time;
        this.start = start;
        this.index = index;
    }
}