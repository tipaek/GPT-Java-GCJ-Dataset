import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = scanner.nextInt();
        for (int testCase = 1; testCase <= cases; testCase++) {
            int n = scanner.nextInt();
            List<Event> events = new ArrayList<>();
            Map<Integer, Event> orderMap = new HashMap<>();
            for (int row = 0; row < n; row++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Event event = new Event(start, end);
                orderMap.put(row, event);
                events.add(event);
            }
            Collections.sort(events, Comparator.comparingInt((Event a) -> a.start).thenComparingInt(a -> a.end));
            String res = check(events, orderMap);
            System.out.println("Case #" + testCase + ": " + res);
        }
    }

    static String check(List<Event> events, Map<Integer, Event> orderMap) {
        Map<Event, Character> resMap = new HashMap<>();
        int jamieLastEnd = 0, carolLastEnd = 0;
        boolean impossible = false;
        for (Event e : events) {
            if(carolLastEnd <= e.start) {
                carolLastEnd = e.end;
                resMap.put(e, 'C');
            } else if (jamieLastEnd <= e.start) {
                jamieLastEnd = e.end;
                resMap.put(e, 'J');
            } else {
                impossible = true;
                break;
            }
        }
        if(impossible)
            return "IMPOSSIBLE";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < events.size(); i++) {
            Event e = orderMap.get(i);
            sb.append(resMap.get(e));
        }
        return sb.toString();
    }
}

class Event {
    public int start;
    public int end;

    public Event(int a, int b) {
        start = a;
        end = b;
    }
}
