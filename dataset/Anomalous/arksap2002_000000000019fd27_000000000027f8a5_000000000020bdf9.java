import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int q = 0; q < t; q++) {
            int n = scanner.nextInt();
            Event[] events = new Event[2 * n];
            
            for (int i = 0; i < n; i++) {
                events[2 * i] = new Event(scanner.nextInt(), i, 1);
                events[2 * i + 1] = new Event(scanner.nextInt(), i, -1);
            }
            
            Arrays.sort(events, (e1, e2) -> {
                if (e1.time == e2.time) {
                    return Integer.compare(e1.type, e2.type);
                }
                return Integer.compare(e1.time, e2.time);
            });
            
            char[] assignments = new char[n];
            int balance = 0;
            boolean conflict = false;
            boolean[] assigned = new boolean[2]; // [C, J]
            
            for (Event event : events) {
                balance += event.type;
                
                if (balance >= 3) {
                    conflict = true;
                }
                
                if (event.type == -1) {
                    if (assignments[event.index] == 'C') {
                        assigned[0] = false;
                    } else {
                        assigned[1] = false;
                    }
                } else {
                    if (balance == 1 || balance == 2) {
                        if (!assigned[0]) {
                            assignments[event.index] = 'C';
                            assigned[0] = true;
                        } else {
                            assignments[event.index] = 'J';
                            assigned[1] = true;
                        }
                    }
                }
            }
            
            if (conflict) {
                System.out.println("Case #" + (q + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (q + 1) + ": " + new String(assignments));
            }
        }
    }

    static class Event {
        int time;
        int index;
        int type;
        
        Event(int time, int index, int type) {
            this.time = time;
            this.index = index;
            this.type = type;
        }
    }
}