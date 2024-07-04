import java.util.*;

class Event {
    int s;
    int e;
    int i;
    int getStart() {
        return s;
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T;t++) {
            int N = sc.nextInt();
            List<Event> events = new ArrayList<>();

            for (int i = 0;i < N;i++) {
                Event p  = new Event();
                p.s = sc.nextInt();
                p.e = sc.nextInt();
                p.i = i;
                events.add(p);
            }

            events.sort(Comparator.comparing(Event::getStart));

            int cb = 0;
            int jb = 0;
            char[] chars = new char[N];
            boolean possible = true;
            for (Event event: events) {
                if (cb <= event.s) {
                    chars[event.i] = 'C';
                    cb = event.e;
                } else if (jb <= event.s) {
                    chars[event.i] = 'J';
                    jb = event.e;
                } else {
                   possible = false;
                   break;
                }
            }

            System.out.println("Case #" + t + ": " + (possible ? new String(chars) : "IMPOSSIBLE"));
        }
    }
}
