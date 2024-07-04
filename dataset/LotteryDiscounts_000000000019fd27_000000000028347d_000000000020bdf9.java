import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {

    static class Event {
        int start, end;
        Integer id;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        Scanner in = new Scanner(
//                "4\n" +
//                        "3\n" +
//                        "360 480\n" +
//                        "420 540\n" +
//                        "600 660\n" +
//                        "3\n" +
//                        "0 1440\n" +
//                        "1 3\n" +
//                        "2 4\n" +
//                        "5\n" +
//                        "99 150\n" +
//                        "1 100\n" +
//                        "100 301\n" +
//                        "2 5\n" +
//                        "150 250\n" +
//                        "2\n" +
//                        "0 720\n" +
//                        "720 1440"
//        );

        int t = in.nextInt();
        for (int c = 1; c <= t; ++c) {
            TreeSet<Event> events = new TreeSet<Event>((e1, e2) -> {
                if (e1.start < e2.start) {
                    return -1;
                } else if (e1.start > e2.start) {
                    return 1;
                } else {
                    return e1.id.compareTo(e2.id);
                }
            });

            int count = in.nextInt();
            for (int i = 0; i < count; i++) {
                Event e = new Event();
                e.start = in.nextInt();
                e.end = in.nextInt();
                e.id = i;
                events.add(e);
            }

            char sequence[] = new char[count];
            Event C = null, J = null;
            for (Event event :
                    events) {
                if (C == null || C.end <= event.start) {
                    C = event;
                    sequence[event.id] = 'C';
                } else if (J == null || J.end <= event.start) {
                    J = event;
                    sequence[event.id] = 'J';
                } else {
                    sequence = null;
                    break;
                }
            }

            String out = "IMPOSSIBLE";
            if (sequence != null) {
                out = new String(sequence);
            }
            System.out.println("Case #" + c + ": " + out);
        }
    }
}
