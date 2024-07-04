import java.util.*;

public class Solution {
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
                    return e1.type - e2.type;
                }
                return e1.time - e2.time;
            });
            
            char[] assignments = new char[n];
            boolean impossible = false;
            int balance = 0;
            boolean[] inUse = new boolean[2];
            
            for (Event event : events) {
                balance += event.type;
                
                if (balance >= 3) {
                    impossible = true;
                    break;
                }
                
                if (event.type == -1) {
                    if (assignments[event.index] == 'C') {
                        inUse[0] = false;
                    } else {
                        inUse[1] = false;
                    }
                }
                
                if (balance == 1 && event.type == 1) {
                    if (!inUse[0]) {
                        assignments[event.index] = 'C';
                        inUse[0] = true;
                    } else {
                        assignments[event.index] = 'J';
                        inUse[1] = true;
                    }
                }
                
                if (balance == 2) {
                    if (!inUse[0]) {
                        assignments[event.index] = 'C';
                        inUse[0] = true;
                    } else {
                        assignments[event.index] = 'J';
                        inUse[1] = true;
                    }
                }
            }
            
            if (impossible) {
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