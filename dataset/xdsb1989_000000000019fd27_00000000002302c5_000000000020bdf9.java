import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        String[] result = new String[cases];

        for (int i = 1; i <= cases; ++i) {
            int events = in.nextInt();
            List<Event> eventList = new ArrayList<>();
            for (int j = 0; j < events; j++) {
                Event event = new Event();
                event.start = in.nextInt();
                event.end = in.nextInt();
                event.index = j;
                eventList.add(event);
            }
            String answer = assignEvent(eventList);
            result[i-1] = "Case #" + i + ": " + answer;
        }
        for (int i = 0; i < cases; i++) {
            System.out.println(result[i]);
        }
    }

    private static String assignEvent(List<Event> eventList) {

        PriorityQueue<Event> queue = new PriorityQueue<>(new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return o1.end - o2.end;
            }
        });

        Collections.sort(eventList, new Comparator<Event>() {
            @Override
            public int compare(Event p1, Event p2) {
                return p1.start - p2.start;
            }
        });

        Stack<Character> stack = new Stack<Character>();
        stack.push('J'); stack.push('C');

        for (Event event : eventList) {
            if (!queue.isEmpty() && queue.peek().end <= event.start){
                Event pollEvent = queue.poll();
                char name = pollEvent.name;
                stack.push(name);
            }
            if (stack.isEmpty()) {
                return "IMPOSSIBLE";
            } else {
                char name = stack.pop();
                event.name = name;
                queue.add(event);
            }
        }

        Collections.sort(eventList, new Comparator<Event>() {
            @Override
            public int compare(Event p1, Event p2) {
                return p1.index - p2.index;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Event event : eventList) {
            sb.append(event.name);
        }

        return sb.toString();
    }

    public static class Event {
        int start;
        int end;
        char name;
        int index;
    }
}