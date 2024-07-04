import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + solve());
        }
    }

    private static String solve() {
        int n = scanner.nextInt();

        String output = "";
        List<Event> cameron = new LinkedList<>();
        List<Event> jamie = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            Event event = new Event();
            event.start = scanner.nextInt();
            event.end = scanner.nextInt();
            if (cameron.stream().noneMatch(event1 -> overlap(event, event1))) {
                cameron.add(event);
                output += "C";
            } else if (jamie.stream().noneMatch(event1 -> overlap(event, event1))) {
                jamie.add(event);
                output += "J";
            } else {
                return "IMPOSSIBLE";
            }
        }
        return output;
    }

    private static boolean overlap(Event event, Event event2) {
        return !(event.start >= event2.end || event.end <= event2.start);
    }

    static class Event {

        int start;
        int end;

    }

}