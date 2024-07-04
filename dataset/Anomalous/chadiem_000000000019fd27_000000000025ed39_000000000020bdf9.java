import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        List<TestCase> testCases = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            int numberOfTestCases = scanner.nextInt();
            for (int i = 0; i < numberOfTestCases; i++) {
                TestCase testCase = new TestCase();
                testCase.parse(scanner);
                testCases.add(testCase);
            }
        }

        for (int i = 0; i < testCases.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + testCases.get(i).solve());
        }
    }

    private static class TestCase {
        private List<Event> originalEvents = new ArrayList<>();
        private List<Event> sortedEvents = new ArrayList<>();
        private int jEnd = 0;
        private int cEnd = 0;

        public void parse(Scanner scanner) {
            int numberOfEvents = scanner.nextInt();
            for (int i = 0; i < numberOfEvents; i++) {
                Event event = new Event(scanner.nextInt(), scanner.nextInt());
                originalEvents.add(event);
                sortedEvents.add(event);
            }
        }

        public String solve() {
            sortedEvents.sort(Comparator.comparingInt(event -> event.start));

            for (Event event : sortedEvents) {
                if (event.start < jEnd && event.start < cEnd) {
                    return "IMPOSSIBLE";
                }
                if (event.start >= jEnd) {
                    event.taker = "J";
                    jEnd = event.end;
                } else {
                    event.taker = "C";
                    cEnd = event.end;
                }
            }

            StringBuilder result = new StringBuilder();
            for (Event event : originalEvents) {
                result.append(event.taker);
            }
            return result.toString();
        }
    }

    private static class Event {
        int start;
        int end;
        String taker = "";

        Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}