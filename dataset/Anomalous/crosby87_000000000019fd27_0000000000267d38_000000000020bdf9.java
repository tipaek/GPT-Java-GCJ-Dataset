import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static class Event {
        int start;
        int end;

        public Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static ArrayList<String> generateBinaryStrings(int n) {
        ArrayList<String> result = new ArrayList<>();
        result.add("");

        for (int i = 0; i < n; i++) {
            ArrayList<String> temp = new ArrayList<>();
            for (String str : result) {
                temp.add(str + "0");
                temp.add(str + "1");
            }
            result = temp;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int eventCount = scanner.nextInt();
            System.out.print("Case #" + t + ": ");
            Event[] events = new Event[eventCount];

            for (int i = 0; i < eventCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                events[i] = new Event(start, end);
            }

            ArrayList<String> binaryStrings = generateBinaryStrings(eventCount);
            boolean isPossible = false;

            for (String binaryString : binaryStrings) {
                ArrayList<Integer> jamieSchedule = new ArrayList<>();
                ArrayList<Integer> cameronSchedule = new ArrayList<>();
                boolean jamieWorks = true;
                boolean cameronWorks = true;

                for (int j = 0; j < binaryString.length(); j++) {
                    if (binaryString.charAt(j) == '0') {
                        jamieSchedule.add(j);
                    } else {
                        cameronSchedule.add(j);
                    }
                }

                for (int j = 0; j < jamieSchedule.size(); j++) {
                    for (int k = j + 1; k < jamieSchedule.size(); k++) {
                        Event event1 = events[jamieSchedule.get(j)];
                        Event event2 = events[jamieSchedule.get(k)];
                        if (eventsOverlap(event1, event2)) {
                            jamieWorks = false;
                        }
                    }
                }

                for (int j = 0; j < cameronSchedule.size(); j++) {
                    for (int k = j + 1; k < cameronSchedule.size(); k++) {
                        Event event1 = events[cameronSchedule.get(j)];
                        Event event2 = events[cameronSchedule.get(k)];
                        if (eventsOverlap(event1, event2)) {
                            cameronWorks = false;
                        }
                    }
                }

                if (jamieWorks && cameronWorks) {
                    for (char ch : binaryString.toCharArray()) {
                        System.out.print(ch == '0' ? 'J' : 'C');
                    }
                    System.out.println();
                    isPossible = true;
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("IMPOSSIBLE");
            }
        }

        scanner.close();
    }

    private static boolean eventsOverlap(Event event1, Event event2) {
        return (event1.start < event2.end && event1.end > event2.start);
    }
}