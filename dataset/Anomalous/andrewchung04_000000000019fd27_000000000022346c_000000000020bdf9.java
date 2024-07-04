import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int intervals = scanner.nextInt();
            ArrayList<Event> events = new ArrayList<>();

            for (int j = 0; j < intervals; j++) {
                events.add(new Event(scanner.nextInt(), 1, j));
                events.add(new Event(scanner.nextInt(), -1, j));
            }

            Collections.sort(events);

            int countC = 0;
            int countJ = 0;
            boolean[] assignments = new boolean[intervals];
            boolean isImpossible = false;

            for (Event event : events) {
                if (event.type == 1) {
                    if (countC == 0 && countJ == 0) {
                        countC++;
                    } else if (countC == 1 && countJ == 0) {
                        assignments[event.index] = true;
                        countJ++;
                    } else if (countC == 0 && countJ == 1) {
                        countC++;
                    } else {
                        System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                        isImpossible = true;
                        break;
                    }
                } else {
                    if (assignments[event.index]) {
                        countJ--;
                    } else {
                        countC--;
                    }
                }
            }

            if (!isImpossible) {
                StringBuilder result = new StringBuilder();
                for (boolean assignment : assignments) {
                    result.append(assignment ? "J" : "C");
                }
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }
    }
}

class Event implements Comparable<Event> {
    public int time;
    public int type;
    public int index;

    public Event(int time, int type, int index) {
        this.time = time;
        this.type = type;
        this.index = index;
    }

    @Override
    public int compareTo(Event other) {
        return Integer.compare(this.time, other.time);
    }
}