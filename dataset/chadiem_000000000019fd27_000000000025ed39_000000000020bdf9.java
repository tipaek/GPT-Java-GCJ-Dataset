import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        List<TestCase> testCaseList = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            int tc = sc.nextInt();
            for (int i = 0; i < tc; i++) {
                TestCase testCase = new TestCase();
                testCase.parse(sc);
                testCaseList.add(testCase);
            }
        }

        for (int i = 0; i < testCaseList.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + testCaseList.get(i).solve());
        }
    }

    private static class TestCase {

        List<Event> eventsOriginal = new ArrayList<>();
        List<Event> eventsToSort = new ArrayList<>();

        int j = 0;
        int c = 0;

        public void parse(Scanner sc) {
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                Event ev = new Event();
                ev.start = sc.nextInt();
                ev.end = sc.nextInt();

                eventsOriginal.add(ev);
                eventsToSort.add(ev);
            }
        }

        public String solve() {
            eventsToSort.sort(Comparator.comparing(event -> event.start));

            for (Event event : eventsToSort) {
                if (event.start < j && event.start < c) {
                    return "IMPOSSIBLE";
                }

                if (event.start >= j) {
                    event.taker = "J";
                    j = event.end;
                } else {
                    event.taker = "C";
                    c = event.end;
                }
            }

            StringBuilder sb = new StringBuilder();

            for (Event event : eventsOriginal) {
                sb.append(event.taker);
            }

            return sb.toString();
        }

    }

    private static class Event {
        int start;
        int end;

        String taker = "";
    }
}
