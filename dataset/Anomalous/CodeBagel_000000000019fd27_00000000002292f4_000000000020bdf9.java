import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numberOfCases; ++caseNumber) {
            int numberOfEvents = scanner.nextInt();
            List<Event> events = new ArrayList<>();
            List<Character> schedule = new ArrayList<>(Collections.nCopies(numberOfEvents, '_'));

            for (int i = 0; i < numberOfEvents; i++) {
                int start = scanner.nextInt();
                int finish = scanner.nextInt();
                events.add(new Event(start, finish));
            }

            boolean isPossible = true;
            Event cameronEvent = null;
            Event jamieEvent = null;

            for (int currentTime = 0; currentTime <= 1440 && isPossible; currentTime++) {
                for (int i = 0; i < events.size(); i++) {
                    Event event = events.get(i);
                    if (event.getStart() == currentTime) {
                        if (cameronEvent == null) {
                            cameronEvent = event;
                            schedule.set(i, 'C');
                        } else if (jamieEvent == null) {
                            jamieEvent = event;
                            schedule.set(i, 'J');
                        } else {
                            isPossible = false;
                            break;
                        }
                    }
                }

                if (cameronEvent != null && cameronEvent.getFinish() == currentTime) {
                    cameronEvent = null;
                }
                if (jamieEvent != null && jamieEvent.getFinish() == currentTime) {
                    jamieEvent = null;
                }
            }

            String result = isPossible ? toString(schedule) : "IMPOSSIBLE";
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static String toString(List<Character> schedule) {
        StringBuilder result = new StringBuilder();
        for (Character ch : schedule) {
            result.append(ch);
        }
        return result.toString();
    }

    private static class Event {
        private final int start;
        private final int finish;

        public Event(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

        public int getStart() {
            return start;
        }

        public int getFinish() {
            return finish;
        }
    }
}