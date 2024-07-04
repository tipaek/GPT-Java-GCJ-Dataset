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
        ArrayList<String> binaryStrings = new ArrayList<>();
        binaryStrings.add("");
        for (int i = 0; i < n; i++) {
            ArrayList<String> newStrings = new ArrayList<>();
            for (String str : binaryStrings) {
                newStrings.add(str + "0");
                newStrings.add(str + "1");
            }
            binaryStrings = newStrings;
        }
        return binaryStrings;
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
                ArrayList<Integer> jamieIndices = new ArrayList<>();
                ArrayList<Integer> cameronIndices = new ArrayList<>();

                for (int i = 0; i < binaryString.length(); i++) {
                    if (binaryString.charAt(i) == '0') {
                        jamieIndices.add(i);
                    } else {
                        cameronIndices.add(i);
                    }
                }

                if (isValidSchedule(events, jamieIndices) && isValidSchedule(events, cameronIndices)) {
                    for (int i = 0; i < binaryString.length(); i++) {
                        System.out.print(binaryString.charAt(i) == '0' ? 'J' : 'C');
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
    }

    private static boolean isValidSchedule(Event[] events, ArrayList<Integer> indices) {
        for (int i = 0; i < indices.size(); i++) {
            for (int j = i + 1; j < indices.size(); j++) {
                Event event1 = events[indices.get(i)];
                Event event2 = events[indices.get(j)];
                if (eventsOverlap(event1, event2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean eventsOverlap(Event event1, Event event2) {
        return (event1.start < event2.end && event2.start < event1.end);
    }
}