import java.util.*;

class Event {
    int s;
    int e;
    int getStart() {
        return s;
    }
}
class Solution {
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
                events.add(p);
            }

            events.sort(Comparator.comparing(Event::getStart));

            StringBuilder sb = new StringBuilder();
            int cb = 0;
            int jb = 0;
            
            for (Event event : events) {
                if (cb <= event.s) {
                    sb.append("C");
                    cb = event.e;
                } else if (jb <= event.s) {
                    sb.append("J");
                    jb = event.e;
                } else {
                    sb = new StringBuilder();
                    sb.append("IMPOSSIBLE");
                    break;
                }
            }
            
            System.out.println("Case #" + t + ": " + sb.toString());
        }
    }
}
