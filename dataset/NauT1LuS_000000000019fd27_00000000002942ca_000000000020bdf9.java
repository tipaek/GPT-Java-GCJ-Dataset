import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       
        int cases = in.nextInt();
        cases: for (int i = 1; i <= cases; i++) {
            int eventsCount = in.nextInt();
            char[] result = new char[eventsCount];
            List<Event> events = new ArrayList<>(eventsCount);
            boolean[][] actors = new boolean[2][24*60];

            for (int j = 0; j < eventsCount; j++) {
                Event event = new Event();
                event.start = in.nextInt();
                event.end = in.nextInt();
                event.order = j;
                events.add(event);
            }
            Collections.sort(events, (a,b) -> Integer.compare(a.start, b.start));

            for (Event event : events){
                if(vetify(actors[0], event)){
                    put(actors[0], event);
                    result[event.order] = 'C';
                }else if(vetify(actors[1], event)) {
                    put(actors[1], event);
                    result[event.order] = 'J';
                }else{
                    System.out.printf("Case #%d: %s", i, "IMPOSSIBLE");
                    System.out.println();
                    continue cases;
                }
            }
            System.out.printf("Case #%d: %s", i, String.valueOf(result));
            System.out.println();

        }

    }

    private static void put(boolean[] actor, Event event) {
        for (int i = event.start; i < event.end; i++) {
            actor[i] = true;
        }
    }

    private static boolean vetify(boolean[] actor, Event event) {
        for (int i = event.start; i < event.end; i++) {
            if(actor[i]) return false;
        }
        return true;
    }

    public static class Event{
        public int start;
        public int end;
        public int order;
    }
}