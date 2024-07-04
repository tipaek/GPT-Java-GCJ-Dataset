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

            ArrayList<String> binaryStrings = generateBinaryStrings(N);
            boolean foundSolution = false;

            for (String binaryString : binaryStrings) {
                ArrayList<Integer> jamieTasks = new ArrayList<>();
                ArrayList<Integer> cameronTasks = new ArrayList<>();

                for (int i = 0; i < binaryString.length(); i++) {
                    if (binaryString.charAt(i) == '0') {
                        jamieTasks.add(i);
                    } else {
                        cameronTasks.add(i);
                    }
                }

                if (isValidSchedule(events, jamieTasks) && isValidSchedule(events, cameronTasks)) {
                    for (char c : binaryString.toCharArray()) {
                        System.out.print(c == '0' ? 'J' : 'C');
                    }
                    System.out.println();
                    foundSolution = true;
                    break;
                }
            }

            if (!foundSolution) {
                System.out.println("IMPOSSIBLE");
            }
        }
        scanner.close();
    }

    private static boolean isValidSchedule(Event[] events, ArrayList<Integer> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            for (int j = i + 1; j < tasks.size(); j++) {
                Event event1 = events[tasks.get(i)];
                Event event2 = events[tasks.get(j)];
                if (eventsOverlap(event1, event2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean eventsOverlap(Event event1, Event event2) {
        return (event1.start < event2.end && event1.end > event2.start);
    }
}