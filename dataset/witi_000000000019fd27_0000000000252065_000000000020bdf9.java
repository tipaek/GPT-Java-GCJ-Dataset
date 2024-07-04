import java.util.Arrays;
import java.util.Scanner;

class Event implements Comparable<Event> {
    public int start;
    public int end;
    public Event(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Event e) {
        return this.start - e.start;
    }
}


public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        casesloop:
        for (int t = 1; t<=T; t++) {

            int N = in.nextInt();

            Event[] events = new Event[N];




            int[] overl = new int[24*60];

            for (int i=0; i<N; i++) {
                int start = in.nextInt();
                int end = in.nextInt();

                events[i] = new Event(start, end);
            }

            Arrays.sort(events);

            for (int i=0; i<N; i++) {

                for (int time=events[i].start; time<events[i].end; time++) {
                    overl[time] += 1;

                    if (overl[time] > 2) {
                        System.out.println("Case #" + t + ": IMPOSSIBLE");
                        continue casesloop;
                    }
                }
            }

            boolean[] assign = new boolean[N];
            boolean[] overlB = new boolean[24*60];

            assignloop:
            for (int i=0; i<N; i++) {

                for (int time=events[i].start; time<events[i].end; time++) {
                    if (overlB[time])
                        continue assignloop;
                }
                assign[i] = true;
                for (int time=events[i].start; time<events[i].end; time++) {
                    overlB[time] = true;
                }
            }


            String out = new String("Case #" + t + ": ");

            for (int i=0; i<N; i++) {
                if (assign[i])
                    out += "C";
                else
                    out += "J";
            }

            System.out.println(out);
        }
    }
}
