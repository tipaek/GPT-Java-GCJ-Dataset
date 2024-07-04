import java.util.*;

public class Solution {
    public static class Event {
        int start;
        int end;

        public Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static List<String> generateBinaryStrings(int n) {
        List<String> result = new ArrayList<>();
        result.add("");
        for (int i = 0; i < n; i++) {
            List<String> temp = new ArrayList<>();
            for (String str : result) {
                temp.add(str + "0");
                temp.add(str + "1");
            }
            result = temp;
        }
        return result;
    }

    public static boolean hasConflict(List<Event> events) {
        for (int i = 0; i < events.size(); i++) {
            for (int j = i + 1; j < events.size(); j++) {
                Event e1 = events.get(i);
                Event e2 = events.get(j);
                if ((e1.start < e2.end && e1.end > e2.start) || (e2.start < e1.end && e2.end > e1.start)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            System.out.print("Case #" + t + ": ");
            Event[] events = new Event[N];

            for (int i = 0; i < N; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                events[i] = new Event(start, end);
            }

            List<String> binaryStrings = generateBinaryStrings(N);
            boolean found = false;

            for (String binaryString : binaryStrings) {
                List<Event> jamieEvents = new ArrayList<>();
                List<Event> cameronEvents = new ArrayList<>();

                for (int i = 0; i < binaryString.length(); i++) {
                    if (binaryString.charAt(i) == '0') {
                        jamieEvents.add(events[i]);
                    } else {
                        cameronEvents.add(events[i]);
                    }
                }

                if (!hasConflict(jamieEvents) && !hasConflict(cameronEvents)) {
                    for (char c : binaryString.toCharArray()) {
                        System.out.print(c == '0' ? 'J' : 'C');
                    }
                    System.out.println();
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("IMPOSSIBLE");
            }
        }
        scanner.close();
    }
}