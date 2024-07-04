import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int q = 0; q < t; q++) {
            int n = scanner.nextInt();
            Event[] events = new Event[2 * n];
            for (int i = 0; i < n; i++) {
                events[2 * i] = new Event(scanner.nextInt(), i, EventType.START);
                events[2 * i + 1] = new Event(scanner.nextInt(), i, EventType.END);
            }
            Arrays.sort(events, (e1, e2) -> {
                if (e1.time == e2.time) {
                    return e1.type.value - e2.type.value;
                }
                return e1.time - e2.time;
            });

            char[] assignments = new char[n];
            boolean isImpossible = false;
            int balance = 0;
            boolean[] isAssigned = new boolean[2];

            for (Event event : events) {
                balance += event.type.value;
                if (balance >= 3) {
                    isImpossible = true;
                }
                if (event.type == EventType.END) {
                    if (assignments[event.index] == 'C') {
                        isAssigned[0] = false;
                    } else {
                        isAssigned[1] = false;
                    }
                }
                if (balance == 1 && event.type == EventType.START) {
                    if (!isAssigned[0]) {
                        assignments[event.index] = 'C';
                        isAssigned[0] = true;
                    } else {
                        assignments[event.index] = 'J';
                        isAssigned[1] = true;
                    }
                }
                if (balance == 2) {
                    if (!isAssigned[0]) {
                        assignments[event.index] = 'C';
                        isAssigned[0] = true;
                    } else {
                        assignments[event.index] = 'J';
                        isAssigned[1] = true;
                    }
                }
            }
            if (isImpossible) {
                System.out.println("Case #" + (q + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (q + 1) + ": " + new String(assignments));
            }
        }
    }

    static class Event {
        int time;
        int index;
        EventType type;

        Event(int time, int index, EventType type) {
            this.time = time;
            this.index = index;
            this.type = type;
        }
    }

    enum EventType {
        START(1), END(-1);

        int value;

        EventType(int value) {
            this.value = value;
        }
    }
}